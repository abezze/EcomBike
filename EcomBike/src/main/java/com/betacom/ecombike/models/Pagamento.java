package com.betacom.ecombike.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "pagamento")
public class Pagamento {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	private BigDecimal amount;
	
	@Column (name="data_pagamento")
	private LocalDate dataPagamento;
	
	@Column (name="orario_pagamento")
	private LocalTime orarioPagamento;

}
