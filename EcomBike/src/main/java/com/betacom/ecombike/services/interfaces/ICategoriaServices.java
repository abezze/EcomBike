package com.betacom.ecombike.services.interfaces;

import java.util.List;

import com.betacom.ecombike.dto.inputs.CategoriaReq;
import com.betacom.ecombike.dto.outputs.CategoriaDTO;

public interface ICategoriaServices {

	void create(CategoriaReq req) throws Exception;

	void update(CategoriaReq req) throws Exception;

	void delete(Long id) throws Exception;

	List<CategoriaDTO> list();

	CategoriaDTO findById(Long id) throws Exception;

}
