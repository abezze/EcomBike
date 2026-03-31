package com.betacom.ecombike.services.interfaces;

import java.util.List;

import com.betacom.ecombike.dto.inputs.DettaglioOrdineReq;
import com.betacom.ecombike.dto.outputs.DettaglioOrdineDTO;

public interface IDettaglioOrdineServices {
	void create(DettaglioOrdineReq req) throws Exception;
	void update(DettaglioOrdineReq req) throws Exception;
	void delete(Long id) throws Exception;

	
	DettaglioOrdineDTO findById(Long id) throws Exception;
	
	List<DettaglioOrdineDTO> list() throws Exception;
	List<DettaglioOrdineDTO> findAllByOrdine(Long ordineId) throws Exception;
}
