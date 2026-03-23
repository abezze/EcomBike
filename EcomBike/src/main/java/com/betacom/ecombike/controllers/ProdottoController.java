package com.betacom.ecombike.controllers;

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

import com.betacom.ecombike.dto.inputs.ProdottoReq;
import com.betacom.ecombike.response.Resp;
import com.betacom.ecombike.services.interfaces.IMessaggioServices;
import com.betacom.ecombike.services.interfaces.IProdottoServices;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("rest/prodotto")
public class ProdottoController {
	
	private final IMessaggioServices    msgS;
	private final IProdottoServices    prodottoServices;
	
	@PostMapping("/create")
	public ResponseEntity<Resp> create(@RequestBody(required = true)  ProdottoReq req){
		Resp r = new Resp();
		HttpStatus status = HttpStatus.OK;
		try {
			prodottoServices.create(req);
			r.setMsg(msgS.get("rest_created"));
		} catch (Exception e) {
			r.setMsg(e.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Resp> update(@RequestBody(required = true)  ProdottoReq req){
		Resp r = new Resp();
		HttpStatus status = HttpStatus.OK;
		try {
			prodottoServices.update(req);
			r.setMsg(msgS.get("rest_updated"));
		} catch (Exception e) {
			r.setMsg(e.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);		
	}

	@DeleteMapping("/delete/{productCode}")
	public ResponseEntity<Resp> delete(@PathVariable(required = true)  Integer productCode){
		Resp r = new Resp();
		HttpStatus status = HttpStatus.OK;
		try {
			prodottoServices.delete(productCode);
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
			r= prodottoServices.list();
		} catch (Exception e) {
			r=e.getMessage();
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
		
	}
	
	@GetMapping("/findByProductCode")
	public ResponseEntity<Object> findByProductCode (@RequestParam (required = true)  Integer productCode){
		Object r = new Object();
		HttpStatus status = HttpStatus.OK;
		try {
			r= prodottoServices.findByProductCode(productCode);
		} catch (Exception e) {
			r=e.getMessage();
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
		
	}
}
