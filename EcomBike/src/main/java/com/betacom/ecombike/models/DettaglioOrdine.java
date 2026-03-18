package com.betacom.ecombike.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "dettaglio_ordine")
public class DettaglioOrdine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prodotto;
    private int quantita;

    
    @ManyToOne
    @JoinColumn(name = "ordine_id") 
    private Ordine ordine;

    
}
