package com.betacom.ecombike.services.interfaces;

import java.util.List;

import com.betacom.ecombike.dto.inputs.ProdottoReq;
import com.betacom.ecombike.dto.outputs.ProdottoDTO;

public interface IProdottoServices {

	void create(ProdottoReq req) throws Exception;

	void update(ProdottoReq req) throws Exception;

	void delete(Integer id) throws Exception;

	List<ProdottoDTO> list();

	ProdottoDTO findByProductCode(Integer productCode) throws Exception;

	List<ProdottoDTO> find(Long categoria, Long produttore) throws Exception;

}
