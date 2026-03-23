package com.betacom.ecombike.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.ecombike.models.TipoPagamento;

@Repository
public interface ITipoPagamentoRepository extends JpaRepository<TipoPagamento, Long>{

}
