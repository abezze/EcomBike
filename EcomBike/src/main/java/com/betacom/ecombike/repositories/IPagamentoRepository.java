package com.betacom.ecombike.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.ecombike.models.Pagamento;

@Repository
public interface IPagamentoRepository extends JpaRepository<Pagamento, Long>{

}
