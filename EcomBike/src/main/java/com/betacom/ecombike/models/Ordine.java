package com.betacom.ecombike.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.betacom.ecombike.enums.StatoOrdine;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "ordine")
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name="data_ordine")
	private LocalDate dataOrdine;
	
	@Column (name="orario_ordine")
	private LocalTime orarioOrdine;
	
	private StatoOrdine statoOrdine;
/*
    @OneToOne(
			mappedBy = "ordineIndirizzo",
			cascade =  CascadeType.REMOVE
			)
	private IndirizzoSpedizione indirizzo;
    */
    
    @OneToOne
	@JoinColumn(
			name="ordine_indirizzo",
			referencedColumnName = "id"
			)
    private IndirizzoSpedizione indirizzo;
     
    
    
    @OneToMany(mappedBy = "ordine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DettaglioOrdine> dettagli = new ArrayList<>();
    
    
    @ManyToOne
    @JoinColumn(name = "utente_id") 
    private Utente utente;
    
    @OneToOne(
			mappedBy = "ordine",
			cascade =  CascadeType.REMOVE
			)
	private Pagamento pagamento;

    
}