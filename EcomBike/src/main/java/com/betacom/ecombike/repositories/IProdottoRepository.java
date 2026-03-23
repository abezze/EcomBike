package com.betacom.ecombike.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.ecombike.models.Ordine;
import com.betacom.ecombike.models.Prodotto;

@Repository
public interface IProdottoRepository extends JpaRepository<Prodotto, Integer>{

	Optional<Prodotto> findByProductCode(Long prodottoId) throws Exception;

}
