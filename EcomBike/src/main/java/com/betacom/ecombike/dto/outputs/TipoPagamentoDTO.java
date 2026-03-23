package com.betacom.ecombike.dto.outputs;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class TipoPagamentoDTO {

	private Long id;
	
	private String tipo_pagamento;
	
	private String societaCreditrice;
	
	private List<PagamentoDTO> pagamentos;

}
