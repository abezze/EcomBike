package com.betacom.ecombike.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.ecombike.enums.StatoOrdine;
import com.betacom.ecombike.models.Ordine;
import com.betacom.ecombike.models.Utente;

@Repository
public interface IOrdineRepository extends JpaRepository<Ordine, Long>{
	//Optional<Prodotto> findByProductCode(Long prodottoId) throws Exception;
	Optional<Ordine> findFirstByUtenteAndStatoOrdineOrderByIdDesc (Utente utente, StatoOrdine statoOrdine) throws Exception;

}
