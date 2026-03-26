package com.betacom.ecombike.dto.outputs;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ProdottoDTO {

	private Integer productCode;

	private String descrizione;

	private String colore;

	private BigDecimal peso;

	private Integer quantita;

	private String taglia;
	
	private String image;

	private CategoriaDTO categoria;

	private DettaglioOrdineDTO dettaglioOrdine;

	private ProduttoreDTO produttore;

}
