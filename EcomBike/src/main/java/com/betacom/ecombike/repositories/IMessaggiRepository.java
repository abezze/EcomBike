package com.betacom.ecombike.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.ecombike.models.MessageID;
import com.betacom.ecombike.models.Messaggi;

public interface IMessaggiRepository extends JpaRepository<Messaggi, MessageID>{

}
