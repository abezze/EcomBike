package com.betacom.ecombike.models;

import com.betacom.ecombike.enums.Roles;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
	private String userName;
	private String password;
	private String email;
	private Roles role;
	

}
