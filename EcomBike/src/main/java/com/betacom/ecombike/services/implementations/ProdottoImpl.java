package com.betacom.ecombike.services.implementations;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.ecombike.dto.inputs.ProdottoReq;
import com.betacom.ecombike.dto.outputs.ProdottoDTO;
import com.betacom.ecombike.exceptions.EcomBikeException;
import com.betacom.ecombike.models.Prodotto;
import com.betacom.ecombike.repositories.ICategoriaRepository;
import com.betacom.ecombike.repositories.IDettaglioOrdineRepository;
import com.betacom.ecombike.repositories.IProdottoRepository;
import com.betacom.ecombike.repositories.IProduttoreRepository;
import com.betacom.ecombike.services.interfaces.IProdottoServices;
import com.betacom.ecombike.utilities.Mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProdottoImpl implements IProdottoServices{
	
	private final IProdottoRepository prodottoR;
	private final ICategoriaRepository categoriaR;
	private final IDettaglioOrdineRepository dettaglioOrdineR;
	private final IProduttoreRepository produttoreR;
	
	private void checkProdotto(ProdottoReq req) {
		if (StringUtils.isBlank(req.getDescrizione()))
			throw new EcomBikeException("Descrizione non inserito");
		
		if (req.getPeso() == null)
			throw new EcomBikeException("Peso non inserito");
	}

	private void initializeProdotto(ProdottoReq req, Prodotto prodotto) {
		prodotto.setDescrizione(req.getDescrizione());
		prodotto.setColore(req.getColore());
		prodotto.setPeso(req.getPeso());
		prodotto.setQuantita(req.getQuantita());
		prodotto.setTaglia(req.getTaglia());
		
		if (req.getIdCategoria() != null)
			prodotto.setCategoria(categoriaR.findById(req.getIdCategoria())
					.orElseThrow(() -> 
					new EcomBikeException("Categoria non trovata : " + req.getIdCategoria())
					));
		
		if (req.getIdDettaglioOrdine() != null)
			prodotto.setDettaglioOrdine(dettaglioOrdineR.findById(req.getIdDettaglioOrdine())
					.orElseThrow(() -> 
					new EcomBikeException("DettaglioOrdine non trovato : " + req.getIdDettaglioOrdine())
					));
		
		if (req.getIdProduttore() != null)
			prodotto.setProduttore(produttoreR.findById(req.getIdProduttore())
					.orElseThrow(() -> 
					new EcomBikeException("Produttore non trovato : " + req.getIdProduttore())
					));
	}
	
	@Transactional (rollbackFor = EcomBikeException.class)
	@Override
	public void create(ProdottoReq req) throws Exception {
		log.debug("create []", req);
		
		checkProdotto(req);
		
		Prodotto prodotto =  new Prodotto();
		prodotto.setProductCode(req.getProductCode());
		initializeProdotto(req, prodotto);
		
		prodottoR.save(prodotto);
	}
	
	@Transactional (rollbackFor = EcomBikeException.class)
	@Override
	public void update(ProdottoReq req) throws Exception {
		log.debug("update {}", req);
		
		checkProdotto(req);
		
		Prodotto prodotto = prodottoR.findById(req.getProductCode())
				.orElseThrow(() -> new EcomBikeException("Prodotto non trovato"));
		
		initializeProdotto(req, prodotto);
		
		prodottoR.save(prodotto);
	}
	
	@Transactional (rollbackFor = EcomBikeException.class)
	@Override
	public void delete(Integer productCode) throws Exception {
		log.debug("delete {}", productCode);
		Prodotto prodotto = prodottoR.findById(productCode)
				.orElseThrow(() -> new EcomBikeException("Prodotto non trovato"));
		
		prodottoR.delete(prodotto);		
	}

	@Override
	public ProdottoDTO findByProductCode(Integer productCode) throws Exception {
		log.debug("findById: {}", productCode);
		Prodotto prodotto = prodottoR.findById(productCode)
				.orElseThrow(() -> new EcomBikeException("Prodotto non trovato: " + productCode));
		
		return Mapper.buildProdottoDTO(prodotto);
	}

	@Override
	public List<ProdottoDTO> list() {
		log.debug("list");
		List<Prodotto> produttori = prodottoR.findAll();
		return Mapper.buildProdottiDTO(produttori);
	}

}
