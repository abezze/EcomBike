package com.betacom.ecombike.models;

import com.betacom.ecombike.enums.Roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "indirizzi")
public class Indirizzi {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(name = "via", nullable = false, length = 100)
 private String via;

 @Column(name = "citta", nullable = false, length = 50)
 private String citta;

 @Column(name = "cap", nullable = false, length = 10)
 private String cap;


}
