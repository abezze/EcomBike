package com.betacom.ecombike.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.ecombike.models.Ordine;

@Repository
public interface IOrdineRepository extends JpaRepository<Ordine, Long>{

}
