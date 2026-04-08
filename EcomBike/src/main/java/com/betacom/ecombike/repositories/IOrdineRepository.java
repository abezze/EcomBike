package com.betacom.ecombike.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.betacom.ecombike.enums.StatoOrdine;
import com.betacom.ecombike.models.Ordine;
import com.betacom.ecombike.models.Utente;

@Repository
public interface IOrdineRepository extends JpaRepository<Ordine, Long>{
	//Optional<Prodotto> findByProductCode(Long prodottoId) throws Exception;
	Optional<Ordine> findFirstByUtenteAndStatoOrdineOrderByIdDesc (Utente utente, StatoOrdine statoOrdine) throws Exception;

	List<Ordine> findAllByOrderByIdAsc() throws Exception;
	
	@Query("SELECT o FROM Ordine o WHERE " +
		       "(:id IS NULL OR o.id = :id) AND " +
		       "(:utente IS NULL OR o.utente = :utente) AND " +
		       "(:statoOrdine IS NULL OR o.statoOrdine = :statoOrdine) " +
		       "ORDER BY o.id ASC")
		List<Ordine> cercaOrdiniFiltrati(
		    @Param("id") Long id, 
		    @Param("utente") Utente utente, 
		    @Param("statoOrdine") StatoOrdine statoOrdine
		);


}
