package com.betacom.ecombike.dto.inputs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UtenteChangePwdReq {
	
	private String userName;
	private String oldPwd;
	private String newPwd;

}
