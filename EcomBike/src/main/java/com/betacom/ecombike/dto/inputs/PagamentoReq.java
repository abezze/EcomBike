package com.betacom.ecombike.dto.inputs;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PagamentoReq {
	
private Long id;
	
	private BigDecimal amount;
	private LocalDate dataPagamento;
	private LocalTime orarioPagamento;
	
	private Long tipoPagamentoId;
	private Long ordineId;

}
