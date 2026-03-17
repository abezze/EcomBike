package com.betacom.ecombike.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.ecombike.dto.inputs.UtenteReq;
import com.betacom.ecombike.enums.Roles;
import com.betacom.ecombike.response.Resp;
import com.betacom.ecombike.services.interfaces.IMessaggioServices;
import com.betacom.ecombike.services.interfaces.IUtenteServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("rest/utente")
public class UtenteController {
	
	private final IUtenteServices utS;
	private final IMessaggioServices    msgS;
	
	@PostMapping("/create")
	public ResponseEntity<Resp> create(@RequestBody(required = true)  UtenteReq req){
		Resp r = new Resp();
		HttpStatus status = HttpStatus.OK;
		try {
			utS.create(req);
			r.setMsg(msgS.get("rest_created"));
		} catch (Exception e) {
			r.setMsg(e.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Resp> update(@RequestBody(required = true)  UtenteReq req){
		Resp r = new Resp();
		HttpStatus status = HttpStatus.OK;
		try {
			utS.update(req);
			r.setMsg(msgS.get("rest_updated"));
		} catch (Exception e) {
			log.debug("Error:" + e.getMessage());
			r.setMsg(e.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Resp> delete(@PathVariable(required = true)  String id){
		Resp r = new Resp();
		HttpStatus status = HttpStatus.OK;
		try {
			utS.delete(id);
			r.setMsg(msgS.get("rest_deleted"));
		} catch (Exception e) {
			r.setMsg(e.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);		
	}
	
	@GetMapping("/list")
	public ResponseEntity<Object> list(){
		Object r = new Object();
		HttpStatus status = HttpStatus.OK;
		try {
			r= utS.list();
		} catch (Exception e) {
			r=e.getMessage();
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
		
	}
	
	@GetMapping("/findById")
	public ResponseEntity<Object> findById (@RequestParam (required = true)  String id){
		Object r = new Object();
		HttpStatus status = HttpStatus.OK;
		try {
			r= utS.getByUserName(id);
		} catch (Exception e) {
			r=e.getMessage();
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
		
	}
	
	@GetMapping("/listRuoli")
	public ResponseEntity<Object> listRuoli(){
		
		HttpStatus status = HttpStatus.OK;
		
			List<Roles> enumValues = Arrays.asList(Roles.values());
		
		return ResponseEntity.status(status).body(enumValues);
		
	}

}
