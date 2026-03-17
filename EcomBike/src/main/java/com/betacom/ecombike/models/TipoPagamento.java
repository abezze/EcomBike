package com.betacom.ecombike.models;

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
@Table(name = "tipo_pagamento")
public class TipoPagamento {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	@Column (
			name="pagamento",
			nullable = false
			)
	private String pagamento;
	@Column (
			name="societa_creditrice",
			nullable = false
			)
	private String societaCreditrice;

}
