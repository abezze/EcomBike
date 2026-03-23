package com.betacom.ecombike.services.interfaces;

import java.util.List;

import com.betacom.ecombike.dto.inputs.AnagraficaReq;
import com.betacom.ecombike.dto.outputs.AnagraficaDTO;

public interface IAnagraficaServices {
	void create(AnagraficaReq req) throws Exception;
	void update(AnagraficaReq req) throws Exception;
	void delete(Long id) throws Exception;

	
	AnagraficaDTO findById(Long id) throws Exception;
	
	List<AnagraficaDTO> list() throws Exception;
}
