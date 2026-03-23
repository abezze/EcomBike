package com.betacom.ecombike.services.implementations;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.ecombike.dto.inputs.ProduttoreReq;
import com.betacom.ecombike.dto.outputs.ProduttoreDTO;
import com.betacom.ecombike.exceptions.EcomBikeException;
import com.betacom.ecombike.models.Produttore;
import com.betacom.ecombike.repositories.IProduttoreRepository;
import com.betacom.ecombike.services.interfaces.IProduttoreServices;
import com.betacom.ecombike.utilities.AnagraficaUtils;
import com.betacom.ecombike.utilities.Mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProduttoreImpl implements IProduttoreServices{
	
	private final IProduttoreRepository produttoreR;
	
	private void checkProduttore(ProduttoreReq req) {
		if (req.getMarchio()== null)
			throw new EcomBikeException("Marchio non inserito");
		
		if (req.getNomeAzienda()== null)
			throw new EcomBikeException("Nome azienda non inserito");
		
		if (StringUtils.isBlank(req.getCodiceFiscale()) && StringUtils.isBlank(req.getPartitaIva()))
			throw new EcomBikeException("Inserire almeno uno tra Codice Fiscale e Partita IVA");
		
		if (!StringUtils.isBlank(req.getCodiceFiscale()) && !AnagraficaUtils.isCodiceFiscaleValido(req.getCodiceFiscale()))
			throw new EcomBikeException("Formato del Codice Fiscale non valido");
		
		if (!StringUtils.isBlank(req.getPartitaIva()) && !AnagraficaUtils.isPartitaIvaValida(req.getPartitaIva()))
			throw new EcomBikeException("Formato della partita IVA non valido");
	}

	private void initializeProduttore(ProduttoreReq req, Produttore produttore) {
		produttore.setMarchio(req.getMarchio());
		produttore.setNomeAzienda(req.getNomeAzienda());
		produttore.setCodiceFiscale(req.getCodiceFiscale());
		produttore.setPartitaIva(req.getPartitaIva());
	}
	
	@Transactional (rollbackFor = EcomBikeException.class)
	@Override
	public void create(ProduttoreReq req) throws Exception {
		log.debug("create []", req);
		
		checkProduttore(req);
		
		Produttore produttore =  new Produttore();
		initializeProduttore(req, produttore);
		
		produttoreR.save(produttore);
	}
	
	@Transactional (rollbackFor = EcomBikeException.class)
	@Override
	public void update(ProduttoreReq req) throws Exception {
		log.debug("update {}", req);
		
		checkProduttore(req);
		
		Produttore produttore = produttoreR.findById(req.getId())
				.orElseThrow(() -> new EcomBikeException("Produttore non trovato"));
		
		initializeProduttore(req, produttore);
		
		produttoreR.save(produttore);
	}
	
	@Transactional (rollbackFor = EcomBikeException.class)
	@Override
	public void delete(Long id) throws Exception {
		log.debug("delete {}", id);
		Produttore produttore = produttoreR.findById(id)
				.orElseThrow(() -> new EcomBikeException("Produttore non trovato"));
		
		produttoreR.delete(produttore);		
	}

	@Override
	public ProduttoreDTO findById(Long id) throws Exception {
		log.debug("findById: {}", id);
		Produttore produttore = produttoreR.findById(id)
				.orElseThrow(() -> new EcomBikeException("Produttore non trovato in DB:" + id));
		
		return Mapper.buildProduttoreDTO(produttore);
	}

	@Override
	public List<ProduttoreDTO> list() {
		log.debug("list");
		List<Produttore> produttori = produttoreR.findAll();
		return Mapper.buildProduttoriDTO(produttori);
	}

}
