package com.betacom.ecombike.dto.inputs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TipoPagamentoReq {
	
	private Long id;
	
	private String tipoPagamento;
	
	private String societaCreditrice;

}
