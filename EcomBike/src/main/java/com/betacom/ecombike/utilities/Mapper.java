package com.betacom.ecombike.utilities;

import com.betacom.ecombike.dto.outputs.UtenteDTO;
import com.betacom.ecombike.models.Utente;

public class Mapper {

	
	
	public static UtenteDTO buildUtenteDto(Utente u) {
		return UtenteDTO.builder() 
				.userName(u.getUserName())
			    .password(u.getPassword())
			    .role(u.getRole().toString())
			    .email(u.getEmail())
			    .build();
	}
	
	


}
