package com.betacom.ecombike.services.implementations;

import static com.betacom.ecombike.utilities.Mapper.buildAnagraficaDTO;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.ecombike.dto.inputs.AnagraficaReq;
import com.betacom.ecombike.dto.outputs.AnagraficaDTO;
import com.betacom.ecombike.enums.TipoIndirizzo;
import com.betacom.ecombike.exceptions.EcomBikeException;
import com.betacom.ecombike.models.Anagrafica;
import com.betacom.ecombike.models.Utente;
import com.betacom.ecombike.repositories.IAnagraficaRepository;
import com.betacom.ecombike.repositories.IUtenteRepository;
import com.betacom.ecombike.services.interfaces.IAnagraficaServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class AnagraficaImpl implements IAnagraficaServices{
	private final IAnagraficaRepository anagR;
	private final IUtenteRepository uteR;
	
	
	@Transactional (rollbackFor = EcomBikeException.class)
	@Override
	public void create(AnagraficaReq req) throws Exception {
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
		
		Utente ute = uteR.findById(req.getUserName())
				.orElseThrow(() -> new EcomBikeException("Utente non trovato :" + req.getUserName()));
		
		
		Anagrafica anag=  new Anagrafica();
		anag.setNome(req.getNome());
		anag.setCognome(req.getCognome());
		anag.setCap(req.getCap());
		anag.setCitta(req.getCitta());
		anag.setCodiceFiscale(req.getCodiceFiscale());
		anag.setNazione(req.getNazione());
		anag.setPartitaIva(req.getPartitaIva());
		anag.setTelefono(req.getTelefono());
		anag.setVia(req.getVia());
		anag.setTipoIndirizzo(TipoIndirizzo.valueOf(req.getTipoIndirizzo()));
		anag.setUtente(ute);
		
		anagR.save(anag);
				
	}
	
	@Transactional (rollbackFor = EcomBikeException.class)
	@Override
	public void update(AnagraficaReq req) throws Exception {
		log.debug("update {}", req);
		Anagrafica at = anagR.findById(req.getId())
				.orElseThrow(() -> new EcomBikeException("Anagrafica non trovata"));
		
		if (req.getNome()!=null)
			at.setNome(req.getNome());
		if (req.getCognome()!=null)
			at.setCognome(req.getCognome());
		if (req.getCap()!=null)
			at.setCap(req.getCap());
		if (req.getCitta()!=null)
			at.setCitta(req.getCitta());
		if (req.getCodiceFiscale()!=null)
			at.setCodiceFiscale(req.getCodiceFiscale());
		if (req.getNazione()!=null)
			at.setNazione(req.getNazione());
		if (req.getPartitaIva()!=null)
			at.setPartitaIva(req.getPartitaIva());
		if (req.getTelefono()!=null)
			at.setTelefono(req.getTelefono());
		if (req.getVia()!=null)
			at.setVia(req.getVia());
		if (req.getTipoIndirizzo()!=null)
			at.setTipoIndirizzo(TipoIndirizzo.valueOf(req.getTipoIndirizzo()));
		
		
		anagR.save(at);
	}
	@Transactional (rollbackFor = EcomBikeException.class)
	@Override
	public void delete(Long id) throws Exception {
		log.debug("delete {}", id);
		Anagrafica at = anagR.findById(id)
				.orElseThrow(() -> new EcomBikeException("Anagrafica non trovata"));
		
		
		
		anagR.delete(at);		
	}

	

	

	
	@Override
	public List<AnagraficaDTO> list() {
		log.debug("list");
		List<Anagrafica> lA = anagR.findAll();
		return buildAnagraficaDTO(lA);
	}

	
	@Override
	public AnagraficaDTO findById(Long id) throws Exception {
		log.debug("findById: {}", id);
		Anagrafica s = anagR.findById(id)
				.orElseThrow(() -> new EcomBikeException("Anagrafica non trovato in DB:" + id));
		
		return buildAnagraficaDTO(s);
	}



}
