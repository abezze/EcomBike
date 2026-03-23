package com.betacom.ecombike.dto.outputs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class DettaglioOrdineDTO {

	private Long id;
	
    private Integer quantita;

    private OrdineDTO ordine;
    
	private ProdottoDTO prodotto;

}
