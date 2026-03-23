package com.betacom.ecombike.dto.outputs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class AnagraficaDTO {

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
	 private UtenteDTO utente;
	 
}
