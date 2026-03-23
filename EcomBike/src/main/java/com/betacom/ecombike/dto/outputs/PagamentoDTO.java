package com.betacom.ecombike.dto.outputs;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.betacom.ecombike.models.Ordine;
import com.betacom.ecombike.models.TipoPagamento;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class PagamentoDTO {

	private Long id;
	
	private BigDecimal amount;
	private LocalDate dataPagamento;
	private LocalTime orarioPagamento;
	//private TipoPagamentoDTO tipoPagamento;
	private OrdineDTO ordine;

}
