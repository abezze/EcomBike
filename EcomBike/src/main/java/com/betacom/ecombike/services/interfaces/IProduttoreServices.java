package com.betacom.ecombike.services.interfaces;

import java.util.List;

import com.betacom.ecombike.dto.inputs.ProduttoreReq;
import com.betacom.ecombike.dto.outputs.ProduttoreDTO;

public interface IProduttoreServices {

	void create(ProduttoreReq req) throws Exception;

	void update(ProduttoreReq req) throws Exception;

	void delete(Long id) throws Exception;

	List<ProduttoreDTO> list();

	ProduttoreDTO findById(Long id) throws Exception;

}
