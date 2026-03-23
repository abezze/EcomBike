package com.betacom.ecombike.services.implementations;

import static com.betacom.ecombike.utilities.Mapper.buildIndirizzoSpedizioneDTO;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.ecombike.dto.inputs.IndirizzoSpedizioneReq;
import com.betacom.ecombike.dto.outputs.IndirizzoSpedizioneDTO;
import com.betacom.ecombike.enums.TipoIndirizzo;
import com.betacom.ecombike.exceptions.EcomBikeException;
import com.betacom.ecombike.models.IndirizzoSpedizione;
import com.betacom.ecombike.models.Ordine;
import com.betacom.ecombike.repositories.IIndirizzoSpedizioneRepository;
import com.betacom.ecombike.repositories.IOrdineRepository;
import com.betacom.ecombike.services.interfaces.IIndirizzoSpedizioneServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class IndirizzoSpedizioneImpl implements IIndirizzoSpedizioneServices{
	private final IIndirizzoSpedizioneRepository indirizzoR;
	private final IOrdineRepository uteR;
	
	
	@Transactional (rollbackFor = EcomBikeException.class)
	@Override
	public void create(IndirizzoSpedizioneReq req) throws Exception {
		log.debug("create []", req);
		
		
		if (req.getCognome()== null)
			throw new EcomBikeException("Cognome non caricato");
		
		if (req.getNome()== null)
			throw new EcomBikeException("Nome non caricato");
		
		if (req.getCap()== null)
			throw new EcomBikeException("Cap non caricato");
		
		if (req.getCitta()== null)
			throw new EcomBikeException("Città non caricato");
		
		if (req.getTipoIndirizzo()== null)
			throw new EcomBikeException("Descrizione non caricato");
		
		if (req.getNazione()== null)
			throw new EcomBikeException("Nazione non caricato");
		
		if (req.getTelefono()== null)
			throw new EcomBikeException("Telefono non caricato");
		
		if (req.getVia()== null)
			throw new EcomBikeException("Via non caricato");
		
		if (req.getCodiceFiscale()== null && req.getPartitaIva()==null)
			throw new EcomBikeException("Inserire almeno uno tra codice Fiscale e partita IVA");
		
		Ordine ord = uteR.findById(req.getOrdineId())
				.orElseThrow(() -> new EcomBikeException("Ordine non trovato :" + req.getOrdineId()));
		
		
		IndirizzoSpedizione indirizzo=  new IndirizzoSpedizione();
		indirizzo.setNome(req.getNome());
		indirizzo.setCognome(req.getCognome());
		indirizzo.setCap(req.getCap());
		indirizzo.setCitta(req.getCitta());
		indirizzo.setCodiceFiscale(req.getCodiceFiscale());
		indirizzo.setNazione(req.getNazione());
		indirizzo.setPartitaIva(req.getPartitaIva());
		indirizzo.setTelefono(req.getTelefono());
		indirizzo.setVia(req.getVia());
		indirizzo.setTipoIndirizzo(TipoIndirizzo.valueOf(req.getTipoIndirizzo()));

		indirizzo.setOrdineIndirizzo(ord);
		
		indirizzoR.save(indirizzo);
				
	}
	
	@Transactional (rollbackFor = EcomBikeException.class)
	@Override
	public void update(IndirizzoSpedizioneReq req) throws Exception {
		log.debug("update {}", req);
		IndirizzoSpedizione at = indirizzoR.findById(req.getId())
				.orElseThrow(() -> new EcomBikeException("IndirizzoSpedizione non trovata"));
		
		if (req.getNome()!=null)
			at.setNome(req.getNome());
		if (req.getCognome()!=null)
			at.setCognome(req.getCognome());
		
		
		indirizzoR.save(at);
	}
	@Transactional (rollbackFor = EcomBikeException.class)
	@Override
	public void delete(Long id) throws Exception {
		log.debug("delete {}", id);
		IndirizzoSpedizione at = indirizzoR.findById(id)
				.orElseThrow(() -> new EcomBikeException("IndirizzoSpedizione non trovata"));
		
		
		
		indirizzoR.delete(at);		
	}

	

	

	
	@Override
	public List<IndirizzoSpedizioneDTO> list() {
		log.debug("list");
		List<IndirizzoSpedizione> lA = indirizzoR.findAll();
		return buildIndirizzoSpedizioneDTO(lA);
	}

	
	@Override
	public IndirizzoSpedizioneDTO findById(Long id) throws Exception {
		log.debug("findById: {}", id);
		IndirizzoSpedizione s = indirizzoR.findById(id)
				.orElseThrow(() -> new EcomBikeException("IndirizzoSpedizione non trovato in DB:" + id));
		
		return buildIndirizzoSpedizioneDTO(s);
	}



}
