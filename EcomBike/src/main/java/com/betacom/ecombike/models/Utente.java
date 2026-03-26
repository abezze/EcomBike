package com.betacom.ecombike.models;

import java.util.ArrayList;
import java.util.List;

import com.betacom.ecombike.enums.Roles;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table (name="utente")
public class Utente {
	
	@Id
	@Column(name = "userName", nullable = false, length = 40)
	private String userName;
	@Column(name = "password", nullable = false, length = 40)
	private String password;
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	private Roles role;
	
	
	 @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Anagrafica> anagrafiche = new ArrayList<>();
	 
	/*
	@OneToOne(
			mappedBy = "utente",
			cascade =  CascadeType.REMOVE
			)
	private Anagrafica anagrafica;*/
	
	@OneToMany(mappedBy = "utente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ordine> ordini = new ArrayList<>();
	

}
