package com.betacom.ecombike.dto.outputs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class LoginDTO {
	
	private String id;
	private String role;

}
