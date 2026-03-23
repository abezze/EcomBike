package com.betacom.ecombike.dto.outputs;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class UtenteDTO {

	private String userName;
	private String password;
	private String email;
	private String role;
	private List<AnagraficaDTO> anagrafiche;
}
