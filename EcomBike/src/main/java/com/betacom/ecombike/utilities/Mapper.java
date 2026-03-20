package com.betacom.ecombike.utilities;

import java.util.List;
import java.util.stream.Collectors;

import com.betacom.ecombike.dto.outputs.AnagraficaDTO;
import com.betacom.ecombike.dto.outputs.UtenteDTO;
import com.betacom.ecombike.models.Anagrafica;
import com.betacom.ecombike.models.Utente;

public class Mapper {

	
	
	public static UtenteDTO buildUtenteDto(Utente u) {
		return UtenteDTO.builder() 
				.userName(u.getUserName())
			    .password(u.getPassword())
			    .role(u.getRole().toString())
			    .email(u.getEmail())
			    .build();
	}
	
	public static AnagraficaDTO buildAnagraficaDTO(Anagrafica a) {
		return AnagraficaDTO.builder()
				.id(a.getId())
				.nome(a.getNome())
				.cognome(a.getCognome())
				.tipoIndirizzo(a.getTipoIndirizzo().toString())
				.codiceFiscale(a.getCodiceFiscale())
				.partitaIva(a.getPartitaIva())
				.citta(a.getCitta())
				.nazione(a.getNazione())
				.cap(a.getCap())
				.via(a.getVia())
				.telefono(a.getTelefono())
				.build();
				
	}
	
	public static List<AnagraficaDTO> buildAnagraficaDTO(List<Anagrafica> lA) {
		return lA.stream()
				.map( a -> buildAnagraficaDTO(a))
				.collect(Collectors.toList());
				
	}


}
