package com.betacom.ecombike.services.interfaces;

import java.util.List;

import com.betacom.ecombike.dto.inputs.PagamentoReq;
import com.betacom.ecombike.dto.outputs.PagamentoDTO;

public interface IPagamentoServices {
	void create(PagamentoReq req) throws Exception;
	void update(PagamentoReq req) throws Exception;
	void delete(Long id) throws Exception;

	
	PagamentoDTO findById(Long id) throws Exception;
	
	List<PagamentoDTO> list() throws Exception;
}
