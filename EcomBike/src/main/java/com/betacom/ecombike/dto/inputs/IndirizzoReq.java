package com.betacom.ecombike.dto.inputs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class IndirizzoReq {
	
	 private Long id;
	 private String via;
	 private String citta;
	 private String cap;
	 private String telefono;

}
