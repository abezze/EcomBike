package com.betacom.ecombike.services.implementations;

import static com.betacom.ecombike.utilities.Mapper.buildUtenteDto;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.ecombike.dto.inputs.UtenteReq;
import com.betacom.ecombike.dto.outputs.UtenteDTO;
import com.betacom.ecombike.enums.Roles;
import com.betacom.ecombike.exceptions.EcomBikeException;
import com.betacom.ecombike.models.Utente;
import com.betacom.ecombike.repositories.IUtenteRepository;
import com.betacom.ecombike.services.interfaces.IMessaggioServices;
import com.betacom.ecombike.services.interfaces.IUtenteServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class UtenteImpl implements IUtenteServices{

	
	private final IUtenteRepository utR;
	private final IMessaggioServices msgS;


    
	
    @Override
	public void create(UtenteReq req) throws Exception {
	
		log.debug("create {}", req);
		
		if(utR.existsByUserName(req.getUserName()))
			throw new EcomBikeException(msgS.get("user_exist"));
		Utente ut = new Utente();
		ut.setEmail(req.getEmail());
		ut.setPassword(req.getPassword());
		ut.setUserName(req.getUserName());
		ut.setRole(Roles.valueOf(req.getRole()));
		
		utR.save(ut);
	}

	@Override
	public void update(UtenteReq req) throws Exception {
		
		log.debug("update {}", req);
		Utente ut = utR.findById(req.getUserName())
				.orElseThrow( () -> new EcomBikeException(msgS.get("user_nt_fnd")));
		if(req.getPassword()!= null)
			ut.setPassword(req.getPassword());
		if(req.getEmail()!=null)
			ut.setEmail(req.getEmail());
		if(req.getRole()!=null)
			ut.setRole(Roles.valueOf(req.getRole()));
		utR.save(ut);
	}

	@Override
	public void delete(String userName) throws Exception {
		log.debug("delete {}", userName);
		Utente ut = utR.findById(userName)
				.orElseThrow( () -> new EcomBikeException(msgS.get("user_nt_fnd")));
		
		utR.delete(ut);
	}

	@Override
	public List<UtenteDTO> list() throws Exception{
		log.debug(" list Utente" );
		
		List<Utente> lU = utR.findAll();
		
		
		return lU.stream()
				.map(( u -> buildUtenteDto(u))
					    ).toList();
	}

	@Override
	public UtenteDTO getByUserName(String userName) throws Exception {
		log.debug("getByUserName   {}",userName);
		
		Utente u = utR.findById(userName)
				.orElseThrow(() -> new EcomBikeException("user_ntfnd"));
		
		
		return buildUtenteDto(u);
	}

}
