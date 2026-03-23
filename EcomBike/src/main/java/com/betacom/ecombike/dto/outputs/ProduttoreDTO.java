package com.betacom.ecombike.dto.outputs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ProduttoreDTO {

	private Long id;

	private String marchio;
	
	private String nomeAzienda;
	
	private String codiceFiscale;
	
	private String partitaIva;
	
//	private List<ProdottoDTO> prodotti; TODO

}
