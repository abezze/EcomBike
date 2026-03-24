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

import com.betacom.ecombike.dto.inputs.IndirizzoSpedizioneReq;
import com.betacom.ecombike.enums.TipoIndirizzo;
import com.betacom.ecombike.response.Resp;
import com.betacom.ecombike.services.interfaces.IIndirizzoSpedizioneServices;
import com.betacom.ecombike.services.interfaces.IMessaggioServices;

import lombok.RequiredArgsConstructor;

//@CrossOrigin("http://localhost:4200/")
@RequiredArgsConstructor
@RestController
@RequestMapping("rest/indirizzoSpedizione")
public class IndirizzoSpedizioneController {
	
	private final IMessaggioServices    msgS;
	private final IIndirizzoSpedizioneServices    indirizzoSpedizioneServices;
	
	@PostMapping("/create")
	public ResponseEntity<Resp> create(@RequestBody(required = true)  IndirizzoSpedizioneReq req){
		Resp r = new Resp();
		HttpStatus status = HttpStatus.OK;
		try {
			indirizzoSpedizioneServices.create(req);
			r.setMsg(msgS.get("rest_created"));
		} catch (Exception e) {
			r.setMsg(e.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Resp> update(@RequestBody(required = true)  IndirizzoSpedizioneReq req){
		Resp r = new Resp();
		HttpStatus status = HttpStatus.OK;
		try {
			indirizzoSpedizioneServices.update(req);
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
			indirizzoSpedizioneServices.delete(id);
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
			r= indirizzoSpedizioneServices.list();
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
			r= indirizzoSpedizioneServices.findById(id);
		} catch (Exception e) {
			r=e.getMessage();
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
		
	}
	
	@GetMapping("/listTipoIndirizzo")
	public ResponseEntity<Object> listTipoIndirizzo(){
		
		HttpStatus status = HttpStatus.OK;
		
			List<TipoIndirizzo> enumValues = Arrays.asList(TipoIndirizzo.values());
		
		return ResponseEntity.status(status).body(enumValues);
		
	}
}
