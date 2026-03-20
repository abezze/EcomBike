package com.betacom.ecombike.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.ecombike.models.DettaglioOrdine;

@Repository
public interface IDettaglioOrdineRepository extends JpaRepository<DettaglioOrdine, Long>{

}
