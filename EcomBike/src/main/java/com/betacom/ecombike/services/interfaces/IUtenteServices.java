package com.betacom.ecombike.services.interfaces;

import java.util.List;

import com.betacom.ecombike.dto.inputs.UtenteReq;
import com.betacom.ecombike.dto.outputs.UtenteDTO;

public interface IUtenteServices {
	
	void create(UtenteReq req)throws Exception;
	void update(UtenteReq req)throws Exception;
	void delete(String userName)throws Exception;
	List<UtenteDTO>list() throws Exception; 
	UtenteDTO getByUserName(String userName)throws Exception;

}
