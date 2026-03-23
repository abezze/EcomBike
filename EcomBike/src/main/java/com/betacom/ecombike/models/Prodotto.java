package com.betacom.ecombike.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "prodotto")
public class Prodotto {

	@Id
	private Integer productCode;

	@Column(name = "descrizione", nullable = false, length = 200)
	private String descrizione;

	@Column(name = "colore", nullable = true, length = 200)
	private String colore;

	@Column(nullable = false)
	private BigDecimal peso;

	@Column(nullable = false)
	private Integer quantita;

	@Column(name = "taglia", nullable = true, length = 20)
	private String taglia;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@OneToOne
	@JoinColumn(name = "idDettaglioOrdine", referencedColumnName = "id")
	private DettaglioOrdine dettaglioOrdine;

	@ManyToOne
	@JoinColumn(name = "produttore_id")
	private Produttore produttore;

}
