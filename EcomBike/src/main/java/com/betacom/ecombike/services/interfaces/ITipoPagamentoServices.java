package com.betacom.ecombike.services.interfaces;

import java.util.List;

import com.betacom.ecombike.dto.inputs.TipoPagamentoReq;
import com.betacom.ecombike.dto.outputs.TipoPagamentoDTO;

public interface ITipoPagamentoServices {
	void create(TipoPagamentoReq req) throws Exception;
	void update(TipoPagamentoReq req) throws Exception;
	void delete(Long id) throws Exception;

	
	TipoPagamentoDTO findById(Long id) throws Exception;
	
	List<TipoPagamentoDTO> list() throws Exception;
}
