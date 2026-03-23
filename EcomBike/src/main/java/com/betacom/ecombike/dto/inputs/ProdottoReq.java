package com.betacom.ecombike.dto.inputs;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProdottoReq {
	
	private Integer productCode;

	private String descrizione;

	private String colore;

	private BigDecimal peso;

	private Integer quantita;

	private String taglia;

	private Long idCategoria;

	private Long idDettaglioOrdine;

	private Long idProduttore;

}
