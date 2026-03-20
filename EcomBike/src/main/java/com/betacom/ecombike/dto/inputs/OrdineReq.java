package com.betacom.ecombike.dto.inputs;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrdineReq {
	
	private Long id;
	private LocalDate dataOrdine;
	private LocalTime orarioOrdine;
	private String statoOrdine;
	
	private Long indirizzoSpedizioneId;
	private String userName;
	private Long pagamentoId;

}
