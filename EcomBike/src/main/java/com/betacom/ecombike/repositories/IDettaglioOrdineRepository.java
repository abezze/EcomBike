package com.betacom.ecombike.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.ecombike.models.DettaglioOrdine;
import com.betacom.ecombike.models.Ordine;
import com.betacom.ecombike.models.Prodotto;

@Repository
public interface IDettaglioOrdineRepository extends JpaRepository<DettaglioOrdine, Long>{
	
	Optional<DettaglioOrdine> findFirstByOrdineAndProdottoOrderByIdDesc (Ordine ordine, Prodotto prodotto) throws Exception;

}
