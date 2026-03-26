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

import com.betacom.ecombike.dto.inputs.LoginReq;
import com.betacom.ecombike.dto.inputs.UtenteChangePwdReq;
import com.betacom.ecombike.dto.inputs.UtenteReq;
import com.betacom.ecombike.dto.outputs.UtenteDTO;
import com.betacom.ecombike.enums.Roles;
import com.betacom.ecombike.exceptions.EcomBikeException;
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
	
	@GetMapping("/findByUserName")
	public ResponseEntity<Object> findById (@RequestParam (required = true)  String userName){
		Object r = new Object();
		HttpStatus status = HttpStatus.OK;
		try {
			r= utS.getByUserName(userName);
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
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody(required = true)  LoginReq req){
		Object r = new Object();
		HttpStatus status = HttpStatus.OK;
		try {
			r = utS.login(req);
			//r.setMsg(msgS.get("login_valid"));
		} catch (Exception e) {
			r= new Resp();
			((Resp) r).setMsg(e.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);		
	}
	
	@PutMapping("/changePwd")
	public ResponseEntity<Resp> changePwd(@RequestBody(required = true)  UtenteChangePwdReq req){
		Resp r = new Resp();
		Object old = new Object();
		boolean updated=false;
		HttpStatus status = HttpStatus.OK;
		try {
			if(!req.getNewPwd().equals(req.getOldPwd())) {
				
				old= utS.getByUserName(req.getUserName());
				if (old!=null) {
					if (old instanceof UtenteDTO) {
						UtenteDTO newUser = (UtenteDTO) old;
						UtenteReq uReq = new UtenteReq();
						if (newUser.getPassword().equals(req.getOldPwd())) {
							uReq.setPassword(req.getNewPwd());
							uReq.setUserName(req.getUserName());
							utS.update(uReq);
							r.setMsg(msgS.get("rest_updated"));
							updated = true;
						} else r.setMsg("Not Updated, wrong old password");
						
						
					} else r.setMsg("Not Updated,user not found");
					
				} else r.setMsg("Not Updated,user not found");
			} else r.setMsg("Not Updated,  old password equal to new one");
			
			log.debug("changePwd   {}",r.getMsg());
			if (!updated)
				throw new EcomBikeException(r.getMsg());
			
		} catch (Exception e) {
			log.debug("Error:" + e.getMessage());
			r.setMsg(e.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);		
	}

}
