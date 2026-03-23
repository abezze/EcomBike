package com.betacom.ecombike.dto.inputs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DettaglioOrdineReq {
	
	private Long id;
	
    private int quantita;

    private Long ordineId;
    
	private Long prodottoId;

}
