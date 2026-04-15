package com.betacom.ecombike.services.implementations;

import static com.betacom.ecombike.utilities.Mapper.buildOrdineDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.betacom.ecombike.dto.inputs.OrdineReq;
import com.betacom.ecombike.dto.outputs.OrdineDTO;
import com.betacom.ecombike.enums.StatoOrdine;
import com.betacom.ecombike.exceptions.EcomBikeException;
import com.betacom.ecombike.models.DettaglioOrdine;
import com.betacom.ecombike.models.IndirizzoSpedizione;
import com.betacom.ecombike.models.Ordine;
import com.betacom.ecombike.models.Pagamento;
import com.betacom.ecombike.models.Prodotto;
import com.betacom.ecombike.models.Utente;
import com.betacom.ecombike.repositories.IDettaglioOrdineRepository;
import com.betacom.ecombike.repositories.IIndirizzoSpedizioneRepository;
import com.betacom.ecombike.repositories.IOrdineRepository;
import com.betacom.ecombike.repositories.IPagamentoRepository;
import com.betacom.ecombike.repositories.IProdottoRepository;
import com.betacom.ecombike.repositories.IUtenteRepository;
import com.betacom.ecombike.services.interfaces.IMessaggioServices;
import com.betacom.ecombike.services.interfaces.IOrdineServices;
import com.betacom.ecombike.utilities.OrdineMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class OrdineImpl implements IOrdineServices{

	
	private final IOrdineRepository ordR;
	private final IMessaggioServices msgS;
	private final IUtenteRepository uteR;
	private final IIndirizzoSpedizioneRepository indSpedR;
	private final IPagamentoRepository pagamR;
	private final IDettaglioOrdineRepository dettOrdR;
	private final IProdottoRepository prodR;

	public final OrdineMapper ORD_M;
    
	
    @Override
	public OrdineDTO create(OrdineReq req) throws Exception {
	
		log.debug("create {}", req);
		
		
		Utente ute = uteR.findById(req.getUserName())
				.orElseThrow(() -> new EcomBikeException("Utente non trovato :" + req.getUserName()));
		
		IndirizzoSpedizione ind = null;
		
		if (req.getIndirizzoSpedizioneId()!=null) {
			ind = indSpedR.findById(req.getIndirizzoSpedizioneId())
				.orElseThrow(() -> new EcomBikeException("Indirizzo spedizione non trovato : "+ req.getIndirizzoSpedizioneId()));
		}
		
		Ordine ord = new Ordine();
		if (req.getDataOrdine()!=null)
			ord.setDataOrdine(req.getDataOrdine());
		else 
			ord.setDataOrdine(LocalDate.now());
		if (req.getOrarioOrdine()!=null)
			ord.setOrarioOrdine(req.getOrarioOrdine());
		else
			ord.setOrarioOrdine(LocalTime.now());
		if (ord.getStatoOrdine()!=null)
			ord.setStatoOrdine(StatoOrdine.valueOf(req.getStatoOrdine()));
		else 
			ord.setStatoOrdine(StatoOrdine.IN_CORSO);
		ord.setUtente(ute);
		
		ord.setIndirizzo(ind);
		
		Ordine save = ordR.save(ord);
		
		return buildOrdineDTO(save);
	}
    

    @Override
	public void setPagamento(OrdineReq req) throws Exception {
	
    	log.debug("set pagamento {}", req);
		
    	Ordine ord = ordR.findById(req.getId())
				.orElseThrow(() -> new EcomBikeException("Ordine non trovato : "+ req.getId()));
		
		Pagamento pag = pagamR.findById(req.getPagamentoId())
				.orElseThrow(() -> new EcomBikeException("Pagamento non trovato : "+ req.getPagamentoId()));
		
		ord.setDataOrdine(req.getDataOrdine());
		ord.setOrarioOrdine(req.getOrarioOrdine());
		ord.setStatoOrdine(StatoOrdine.PAGATO);
		
		ord.setPagamento(pag);
		
		ordR.save(ord);
	}

	@Override
	public void update(OrdineReq req) throws Exception {
		
		log.debug("update {}", req);
		Ordine ut = ordR.findById(req.getId())
				.orElseThrow( () -> new EcomBikeException(msgS.get("user_nt_fnd")));
		if(req.getDataOrdine()!= null)
			ut.setDataOrdine(req.getDataOrdine());
		if(req.getOrarioOrdine()!=null)
			ut.setOrarioOrdine(req.getOrarioOrdine());;
		if(req.getStatoOrdine()!=null) {
			StatoOrdine nuovoSO = StatoOrdine.valueOf(req.getStatoOrdine());
			if (!ut.getStatoOrdine().equals(nuovoSO)) {
				for (DettaglioOrdine dettaglioOrdine : ut.getDettagli()) {
					// NB: Potrebbero mancare da implementare altre casistiche
					Prodotto prodotto = prodR.findById(dettaglioOrdine.getProdotto().getProductCode())
							.orElseThrow( () -> new EcomBikeException(msgS.get("prodotto_nt_fnd")));
					
					if(ut.getStatoOrdine().equals(StatoOrdine.IN_CORSO) && nuovoSO.equals(StatoOrdine.CONFERMATO)) {
						Integer quantitaProdRimanenti = prodotto.getQuantita() - dettaglioOrdine.getQuantita();
						if (quantitaProdRimanenti < 0)
							throw new EcomBikeException("Sono disponibili solo " + prodotto.getQuantita() + " pezzi per il prodotto con productCode: " + prodotto.getProductCode());
						
						prodotto.setQuantita(quantitaProdRimanenti);
					} else if (
						!ut.getStatoOrdine().equals(StatoOrdine.IN_CORSO) && (
							(!ut.getStatoOrdine().equals(StatoOrdine.RESTITUITO) && nuovoSO.equals(StatoOrdine.CANCELLATO)) ||
							(!ut.getStatoOrdine().equals(StatoOrdine.CANCELLATO) && nuovoSO.equals(StatoOrdine.RESTITUITO))
						)
					) {
						prodotto.setQuantita(prodotto.getQuantita() + dettaglioOrdine.getQuantita());
					}
					
					prodR.save(prodotto);
				}
				ut.setStatoOrdine(nuovoSO);
			}
		}
		
		ordR.save(ut);
	}

	@Override
	public void delete(Long id) throws Exception {
		log.debug("delete {}", id);
		Ordine ord = ordR.findById(id)
				.orElseThrow( () -> new EcomBikeException(msgS.get("user_nt_fnd")));
		
		for (DettaglioOrdine dettOrd : ord.getDettagli()) {
			dettOrdR.delete(dettOrd);
		}
		
		if (ord.getIndirizzo() != null) {
			indSpedR.delete(ord.getIndirizzo());
		}
		
		ordR.delete(ord);
	}

	@Override
	public List<OrdineDTO> list() throws Exception{
		log.debug(" list Ordine" );
		
		List<Ordine> lU = ordR.findAllByOrderByIdAsc();
		
		
		return  ORD_M.buildOrdineDTO(lU);
	}

	@Override
	public OrdineDTO findById(Long id) throws Exception {
		log.debug("getByUserName   {}",id);
		
		Ordine u = ordR.findById(id)
				.orElseThrow(() -> new EcomBikeException("user_ntfnd"));
		
		
		return buildOrdineDTO(u);
	}
	
	@Override
	public void setIndirizzoSpedizione(OrdineReq req) throws Exception {
    	log.debug("setIndirizzoSpedizione {}", req);
		
    	Ordine ord = ordR.findById(req.getId())
				.orElseThrow(() -> new EcomBikeException("Ordine non trovato : "+ req.getId()));
    	
    	IndirizzoSpedizione indSped = null;
    	if (req.getIndirizzoSpedizioneId() != null) {
	    	indSped = indSpedR.findById(req.getIndirizzoSpedizioneId())
					.orElseThrow(() -> new EcomBikeException("Indirizzo di spedizione non trovato: "+ req.getIndirizzoSpedizioneId()));
    	}
    	
    	ord.setIndirizzo(indSped);
		
		ordR.save(ord);
	}


	@Override
	public OrdineDTO findLastByUtenteAndStatoOrdine(String userName) throws Exception {
		
				
		Utente ute = uteR.findById(userName)
				.orElseThrow(() -> new EcomBikeException("Utente non trovato : {}" + userName));
		
		Optional<Ordine> ord = ordR.findFirstByUtenteAndStatoOrdineOrderByIdDesc(ute, StatoOrdine.IN_CORSO);
		
		if (ord.isPresent())
			return buildOrdineDTO(ord.get());
		else
			return null;
	}


	@Override
	public List<OrdineDTO> cercaOrdiniFiltrati(Long id, String userName, StatoOrdine statoOrdine) throws Exception {
		log.debug("cercaOrdiniFiltrati: {}, {}, {}", id, userName, statoOrdine );
		
		Utente ute = null;
		if (userName != null) {
			ute = uteR.findById(userName).orElse(null);
			if (ute == null) return new ArrayList<OrdineDTO>();
		}
		
		List<Ordine> lU = ordR.cercaOrdiniFiltrati(id, ute, statoOrdine);
		
		return  ORD_M.buildOrdineDTO(lU);
	}

}
