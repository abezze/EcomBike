package com.betacom.ecombike.dto.outputs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class CategoriaDTO {

	private Long id;

	private String descrizione;
	
//	private List<ProdottoDTO> prodotti; TODO

}
