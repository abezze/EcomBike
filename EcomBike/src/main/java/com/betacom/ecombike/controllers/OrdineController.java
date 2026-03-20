package com.betacom.ecombike.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.ecombike.enums.StatoOrdine;
import com.betacom.ecombike.services.interfaces.IMessaggioServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("rest/utente")
public class OrdineController {
	
	
	private final IMessaggioServices    msgS;
	
	
	
	@GetMapping("/listStatiOrdine")
	public ResponseEntity<Object> listRuoli(){
		
		HttpStatus status = HttpStatus.OK;
		
			List<StatoOrdine> enumValues = Arrays.asList(StatoOrdine.values());
		
		return ResponseEntity.status(status).body(enumValues);
		
	}

}
