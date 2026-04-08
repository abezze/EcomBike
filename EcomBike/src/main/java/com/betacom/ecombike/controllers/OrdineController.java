package com.betacom.ecombike.controllers;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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

import com.betacom.ecombike.dto.inputs.OrdineReq;
import com.betacom.ecombike.enums.StatoOrdine;
import com.betacom.ecombike.response.Resp;
import com.betacom.ecombike.services.interfaces.IMessaggioServices;
import com.betacom.ecombike.services.interfaces.IOrdineServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("rest/ordine")
public class OrdineController {
	
	private final IOrdineServices ordS;
	private final IMessaggioServices    msgS;
	
	
	
	@GetMapping("/listStatiOrdine")
	public ResponseEntity<Object> listStatiOrdine(){
		
		HttpStatus status = HttpStatus.OK;
		
			List<StatoOrdine> enumValues = Arrays.asList(StatoOrdine.values());
		
		return ResponseEntity.status(status).body(enumValues);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> create(@RequestBody(required = true)  OrdineReq req){
		Object r = new Object();
		HttpStatus status = HttpStatus.OK;
		try {
			r = ordS.create(req);
			
		} catch (Exception e) {
			r=e.getMessage();
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
		
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Resp> update(@RequestBody(required = true)  OrdineReq req){
		Resp r = new Resp();
		HttpStatus status = HttpStatus.OK;
		try {
			ordS.update(req);
			r.setMsg(msgS.get("rest_updated"));
		} catch (Exception e) {
			r.setMsg(e.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);		
	}

	@PutMapping("/setPagamento")
	public ResponseEntity<Resp> setPagamento(@RequestBody(required = true)  OrdineReq req){
		Resp r = new Resp();
		HttpStatus status = HttpStatus.OK;
		try {
			ordS.setPagamento(req);
			r.setMsg(msgS.get("rest_updated"));
		} catch (Exception e) {
			r.setMsg(e.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Resp> delete(@PathVariable(required = true)  Long id){
		Resp r = new Resp();
		HttpStatus status = HttpStatus.OK;
		try {
			ordS.delete(id);
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
			r= ordS.list();
		} catch (Exception e) {
			r=e.getMessage();
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
		
	}
	
	@GetMapping("/findById")
	public ResponseEntity<Object> findById (@RequestParam (required = true)  Long id){
		Object r = new Object();
		HttpStatus status = HttpStatus.OK;
		try {
			r= ordS.findById(id);
		} catch (Exception e) {
			r=e.getMessage();
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
		
	}

	@PutMapping("/setIndirizzoSpedizione")
	public ResponseEntity<Resp> setIndirizzoSpedizione(@RequestBody(required = true)  OrdineReq req){
		Resp r = new Resp();
		HttpStatus status = HttpStatus.OK;
		try {
			ordS.setIndirizzoSpedizione(req);
			r.setMsg(msgS.get("rest_updated"));
		} catch (Exception e) {
			r.setMsg(e.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);		
	}
	
	@GetMapping("/findLastByUtenteAndStatoOrdine")
	public ResponseEntity<Object> findLastByUtenteAndStatoOrdine (@RequestParam (required = true)  String userName ){
		Object r = new Object();
		HttpStatus status = HttpStatus.OK;
		try {
			r= ordS.findLastByUtenteAndStatoOrdine(userName);
		} catch (Exception e) {
			r=e.getMessage();
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
		
	}
	
	@GetMapping("/cercaOrdiniFiltrati")
	public ResponseEntity<Object> cercaOrdiniFiltrati (
			@RequestParam (required = false)  Long id,
			@RequestParam (required = false)  String userName,
			@RequestParam (required = false)  String statoOrdine
	){
		Object r = new Object();
		HttpStatus status = HttpStatus.OK;
		try {
			r= ordS.cercaOrdiniFiltrati(
				id, 
				(StringUtils.isBlank(userName) ? null : userName), 
				(StringUtils.isBlank(statoOrdine) ? null : StatoOrdine.valueOf(statoOrdine))
			);
		} catch (Exception e) {
			r=e.getMessage();
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
	}

}
