package com.betacom.ecombike.services.implementations;

import static com.betacom.ecombike.utilities.Mapper.buildDettaglioOrdineSenzaOrdineDTO;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.betacom.ecombike.dto.inputs.DettaglioOrdineReq;
import com.betacom.ecombike.dto.outputs.DettaglioOrdineDTO;
import com.betacom.ecombike.exceptions.EcomBikeException;
import com.betacom.ecombike.models.DettaglioOrdine;
import com.betacom.ecombike.models.Ordine;
import com.betacom.ecombike.models.Prodotto;
import com.betacom.ecombike.repositories.IDettaglioOrdineRepository;
import com.betacom.ecombike.repositories.IOrdineRepository;
import com.betacom.ecombike.repositories.IProdottoRepository;
import com.betacom.ecombike.services.interfaces.IDettaglioOrdineServices;
import com.betacom.ecombike.services.interfaces.IMessaggioServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class DettaglioOrdineImpl implements IDettaglioOrdineServices{

	
	private final IDettaglioOrdineRepository dettR;
	private final IMessaggioServices msgS;
	private final IProdottoRepository prodR;
	private final IOrdineRepository ordR;


	
    @Override
	public void create(DettaglioOrdineReq req) throws Exception {
	
		log.debug("create {}", req);
		
		Ordine ord = null;
		if (req.getOrdineId()!=null) {
			ord = ordR.findById(req.getOrdineId())
				.orElseThrow(() -> new EcomBikeException("Ordine non trovato :" + req.getOrdineId()));
		}
		
		Prodotto prodotto = null;
		if (req.getProdottoId()!=null) {
			prodotto = prodR.findByProductCode(req.getProdottoId())
				.orElseThrow(() -> new EcomBikeException("Prodotto non trovato :" + req.getProdottoId()));
		}
		
		DettaglioOrdine dett=null;
		
		if (ord!=null && prodotto!=null) {
			Optional<DettaglioOrdine> firstByOrdineAndProdottoOrderByIdDesc = dettR.findFirstByOrdineAndProdottoOrderByIdDesc(ord,prodotto);
			if (firstByOrdineAndProdottoOrderByIdDesc.isPresent())
				dett= firstByOrdineAndProdottoOrderByIdDesc.get();
			else {
				dett = new DettaglioOrdine();
				dett.setQuantita(req.getQuantita());
				
			}
			dett.setQuantita(dett.getQuantita()+req.getQuantita());
			if(prodotto.getQuantita()<dett.getQuantita())
				throw new EcomBikeException("superata quantità disponibile");
		} else {
			dett = new DettaglioOrdine();
			dett.setQuantita(req.getQuantita());
		}
		
		
		dett.setOrdine(ord);
		dett.setProdotto(prodotto);
		
		dettR.save(dett);
	}
    

    

	@Override
	public void update(DettaglioOrdineReq req) throws Exception {
		
		log.debug("update {}", req);
		DettaglioOrdine ut = dettR.findById(req.getId())
				.orElseThrow( () -> new EcomBikeException(msgS.get("user_nt_fnd")));
		if (req.getQuantita()!=null)
			ut.setQuantita(req.getQuantita());
		dettR.save(ut);
	}

	@Override
	public void delete(Long id) throws Exception {
		log.debug("delete {}", id);
		DettaglioOrdine ut = dettR.findById(id)
				.orElseThrow( () -> new EcomBikeException(msgS.get("user_nt_fnd")));
		
		dettR.delete(ut);
	}

	@Override
	public List<DettaglioOrdineDTO> list() throws Exception{
		log.debug(" list DettaglioOrdine" );
		
		List<DettaglioOrdine> lU = dettR.findAll();
		
		
		return  buildDettaglioOrdineSenzaOrdineDTO(lU);
	}

	@Override
	public DettaglioOrdineDTO findById(Long id) throws Exception {
		log.debug("getByUserName   {}",id);
		
		DettaglioOrdine u = dettR.findById(id)
				.orElseThrow(() -> new EcomBikeException("user_ntfnd"));
		
		
		return buildDettaglioOrdineSenzaOrdineDTO(u);
	}

	@Override
	public List<DettaglioOrdineDTO>	findAllByOrdine (Long  ordineId) throws Exception {
		
		Ordine ord = null;
		
		if (ordineId!=null) {
			ord = ordR.findById(ordineId)
				.orElseThrow(() -> new EcomBikeException("Ordine non trovato :" + ordineId));
		}
		
		List<DettaglioOrdine> list = dettR.findAllByOrdine(ord);
		
		return buildDettaglioOrdineSenzaOrdineDTO(list);
		
		
		
	}
}
