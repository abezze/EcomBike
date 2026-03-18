package com.betacom.ecombike.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "anagrafica")
public class Anagrafica {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 
 @Column(name = "nome", nullable = false, length = 50)
 private String nome;
 
 @Column(name = "cognome", nullable = false, length = 50)
 private String cognome;

 @Column(name = "via", nullable = false, length = 100)
 private String via;

 @Column(name = "citta", nullable = false, length = 50)
 private String citta;

 @Column(name = "cap", nullable = false, length = 10)
 private String cap;
 
 @Column(name = "nazione", nullable = false, length = 30)
 private String nazione;
 
 @Column(name = "telefono", nullable = false, length = 20)
 private String telefono;
 
 @Column(name = "codiceFiscale", nullable = true, length = 20)
 private String codiceFiscale;
 
 @Column(name = "partitaIva", nullable = true, length = 20)
 private String partitaIva;

 @OneToOne
	@JoinColumn(
			name="utente_userName",
			referencedColumnName = "userName"
			)
	private Utente utente;

}
