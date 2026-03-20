package com.betacom.ecombike.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.ecombike.models.Produttore;

@Repository
public interface IProduttoreRepository extends JpaRepository<Produttore, Long>{

}
