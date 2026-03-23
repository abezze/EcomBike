package com.betacom.ecombike.services.interfaces;

import java.util.List;

import com.betacom.ecombike.dto.inputs.IndirizzoSpedizioneReq;
import com.betacom.ecombike.dto.outputs.IndirizzoSpedizioneDTO;

public interface IIndirizzoSpedizioneServices {
	void create(IndirizzoSpedizioneReq req) throws Exception;
	void update(IndirizzoSpedizioneReq req) throws Exception;
	void delete(Long id) throws Exception;

	
	IndirizzoSpedizioneDTO findById(Long id) throws Exception;
	
	List<IndirizzoSpedizioneDTO> list();
}
