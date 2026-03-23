package com.betacom.ecombike.dto.inputs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProduttoreReq {

	private Long id;

	private String marchio;
	
	private String nomeAzienda;
	
	private String codiceFiscale;
	
	private String partitaIva;

}
