package com.betacom.ecombike.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.ecombike.models.IndirizzoSpedizione;

@Repository
public interface IIndirizzoSpedizioneRepository extends JpaRepository<IndirizzoSpedizione, Long>{

}
