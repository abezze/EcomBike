package com.betacom.ecombike.services.implementations;

import static com.betacom.ecombike.utilities.Mapper.buildOrdineDTO;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.ecombike.dto.inputs.OrdineReq;
import com.betacom.ecombike.dto.outputs.OrdineDTO;
import com.betacom.ecombike.enums.StatoOrdine;
import com.betacom.ecombike.exceptions.EcomBikeException;
import com.betacom.ecombike.models.DettaglioOrdine;
import com.betacom.ecombike.models.IndirizzoSpedizione;
import com.betacom.ecombike.models.Ordine;
import com.betacom.ecombike.models.Pagamento;
import com.betacom.ecombike.models.Utente;
import com.betacom.ecombike.repositories.IDettaglioOrdineRepository;
import com.betacom.ecombike.repositories.IIndirizzoSpedizioneRepository;
import com.betacom.ecombike.repositories.IOrdineRepository;
import com.betacom.ecombike.repositories.IPagamentoRepository;
import com.betacom.ecombike.repositories.IUtenteRepository;
import com.betacom.ecombike.services.interfaces.IMessaggioServices;
import com.betacom.ecombike.services.interfaces.IOrdineServices;

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


    
	
    @Override
	public void create(OrdineReq req) throws Exception {
	
		log.debug("create {}", req);
		
		
		Utente ute = uteR.findById(req.getUserName())
				.orElseThrow(() -> new EcomBikeException("Utente non trovato :" + req.getUserName()));
		
		IndirizzoSpedizione ind = null;
		
		if (req.getIndirizzoSpedizioneId()!=null) {
			ind = indSpedR.findById(req.getIndirizzoSpedizioneId())
				.orElseThrow(() -> new EcomBikeException("Indirizzo spedizione non trovato : "+ req.getIndirizzoSpedizioneId()));
		}
		
		Ordine ord = new Ordine();
		ord.setDataOrdine(req.getDataOrdine());
		ord.setOrarioOrdine(req.getOrarioOrdine());
		ord.setStatoOrdine(StatoOrdine.valueOf(req.getStatoOrdine()));
		ord.setUtente(ute);
		
		ord.setIndirizzo(ind);
		
		ordR.save(ord);
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
		if(req.getStatoOrdine()!=null)
			ut.setStatoOrdine(StatoOrdine.valueOf(req.getStatoOrdine()));
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
		
		List<Ordine> lU = ordR.findAll();
		
		
		return  buildOrdineDTO(lU);
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

}
