package com.betacom.ecombike.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.betacom.ecombike.models.Prodotto;

@Repository
public interface IProdottoRepository extends JpaRepository<Prodotto, Integer>{

	Optional<Prodotto> findByProductCode(Long prodottoId) throws Exception;
	
	@Query (name ="prodotto.selectByFilter")
	List<Prodotto> searchByFilter(
			@Param("categoria") Long categoria,
			@Param("produttore") Long produttore
			);

}
