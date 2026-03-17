package com.betacom.ecombike.dto.outputs;

import com.betacom.ecombike.models.Utente;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class IndirizzoDTO {

	 private Long id;
	 private String via;
	 private String citta;
	 private String cap;
	 private String telefono;
	 private Utente utente;
}
