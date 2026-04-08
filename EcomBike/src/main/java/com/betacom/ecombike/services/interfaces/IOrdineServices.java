package com.betacom.ecombike.services.interfaces;

import java.util.List;

import com.betacom.ecombike.dto.inputs.OrdineReq;
import com.betacom.ecombike.dto.outputs.OrdineDTO;
import com.betacom.ecombike.enums.StatoOrdine;

public interface IOrdineServices {
	OrdineDTO create(OrdineReq req) throws Exception;
	void update(OrdineReq req) throws Exception;
	void delete(Long id) throws Exception;

	
	OrdineDTO findById(Long id) throws Exception;
	
	List<OrdineDTO> list() throws Exception;
	void setPagamento(OrdineReq req) throws Exception;
	void setIndirizzoSpedizione(OrdineReq req) throws Exception;
	OrdineDTO findLastByUtenteAndStatoOrdine(String userName) throws Exception;
	
	List<OrdineDTO> cercaOrdiniFiltrati(Long id, String userName, StatoOrdine statoOrdine) throws Exception;
}
