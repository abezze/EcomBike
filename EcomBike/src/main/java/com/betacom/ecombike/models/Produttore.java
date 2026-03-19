package com.betacom.ecombike.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "produttore")
public class Produttore {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String marchio; 
	
	private String nomeAzienda;
	
	@Column(name = "codiceFiscale", nullable = true, length = 20)
	 private String codiceFiscale;
	 
	 @Column(name = "partitaIva", nullable = true, length = 20)
	 private String partitaIva;
	
	@OneToMany(mappedBy = "produttore", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prodotto> prodotti = new ArrayList<>();
	

}
