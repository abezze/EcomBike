package com.betacom.ecombike.dto.inputs;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class IndirizzoSpedizioneReq {
	
	 private Long id;
	 private String tipoIndirizzo;
	 private String nome;
	 private String cognome;
	 private String via;
	 private String citta;
	 private String cap;
	 private String nazione;
	 private String telefono;
	 private String codiceFiscale;
	 private String partitaIva;
	 private Long ordineId;

}
