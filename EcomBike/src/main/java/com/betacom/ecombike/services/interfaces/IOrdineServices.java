package com.betacom.ecombike.services.interfaces;

import java.util.List;

import com.betacom.ecombike.dto.inputs.OrdineReq;
import com.betacom.ecombike.dto.outputs.OrdineDTO;

public interface IOrdineServices {
	void create(OrdineReq req) throws Exception;
	void update(OrdineReq req) throws Exception;
	void delete(Long id) throws Exception;

	
	OrdineDTO findById(Long id) throws Exception;
	
	List<OrdineDTO> list();
}
