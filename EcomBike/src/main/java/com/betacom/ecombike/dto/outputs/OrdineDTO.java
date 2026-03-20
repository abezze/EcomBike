package com.betacom.ecombike.dto.outputs;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class OrdineDTO {

	private Long id;
	private LocalDate dataOrdine;
	private LocalTime orarioOrdine;
	private String statoOrdine;
	
	//private IndirizzoSpedizioneDTO indirizzo;
    //private List<DettaglioOrdineDTO> dettagli ;
    private UtenteDTO utente;
	//private PagamentoDTO pagamento;

}
