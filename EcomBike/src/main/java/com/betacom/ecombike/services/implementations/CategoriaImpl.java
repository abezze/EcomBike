package com.betacom.ecombike.services.implementations;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.ecombike.dto.inputs.CategoriaReq;
import com.betacom.ecombike.dto.outputs.CategoriaDTO;
import com.betacom.ecombike.exceptions.EcomBikeException;
import com.betacom.ecombike.models.Categoria;
import com.betacom.ecombike.repositories.ICategoriaRepository;
import com.betacom.ecombike.services.interfaces.ICategoriaServices;
import com.betacom.ecombike.utilities.Mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class CategoriaImpl implements ICategoriaServices{
	
	private final ICategoriaRepository categoriaR;
	
	private void checkCategoria(CategoriaReq req) {
		if (StringUtils.isBlank(req.getDescrizione()))
			throw new EcomBikeException("Descrizione non inserito");
	}

	private void initializeCategoria(CategoriaReq req, Categoria categoria) {
		categoria.setDescrizione(req.getDescrizione());
	}
	
	@Transactional (rollbackFor = EcomBikeException.class)
	@Override
	public void create(CategoriaReq req) throws Exception {
		log.debug("create []", req);
		
		checkCategoria(req);
		
		Categoria categoria =  new Categoria();
		initializeCategoria(req, categoria);
		
		categoriaR.save(categoria);
	}
	
	@Transactional (rollbackFor = EcomBikeException.class)
	@Override
	public void update(CategoriaReq req) throws Exception {
		log.debug("update {}", req);
		
		checkCategoria(req);
		
		Categoria categoria = categoriaR.findById(req.getId())
				.orElseThrow(() -> new EcomBikeException("Categoria non trovato"));
		
		initializeCategoria(req, categoria);
		
		categoriaR.save(categoria);
	}
	
	@Transactional (rollbackFor = EcomBikeException.class)
	@Override
	public void delete(Long id) throws Exception {
		log.debug("delete {}", id);
		Categoria categoria = categoriaR.findById(id)
				.orElseThrow(() -> new EcomBikeException("Categoria non trovato"));
		
		categoriaR.delete(categoria);		
	}

	@Override
	public CategoriaDTO findById(Long id) throws Exception {
		log.debug("findById: {}", id);
		Categoria categoria = categoriaR.findById(id)
				.orElseThrow(() -> new EcomBikeException("Categoria non trovato in DB:" + id));
		
		return Mapper.buildCategoriaDTO(categoria);
	}

	@Override
	public List<CategoriaDTO> list() {
		log.debug("list");
		List<Categoria> produttori = categoriaR.findAll();
		return Mapper.buildCategorieDTO(produttori);
	}

}
