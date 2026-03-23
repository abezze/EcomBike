package com.betacom.ecombike.utilities;

import java.util.List;
import java.util.stream.Collectors;

import com.betacom.ecombike.dto.outputs.AnagraficaDTO;
import com.betacom.ecombike.dto.outputs.CategoriaDTO;
import com.betacom.ecombike.dto.outputs.OrdineDTO;
import com.betacom.ecombike.dto.outputs.ProduttoreDTO;
import com.betacom.ecombike.dto.outputs.UtenteDTO;
import com.betacom.ecombike.models.Anagrafica;
import com.betacom.ecombike.models.Categoria;
import com.betacom.ecombike.models.Ordine;
import com.betacom.ecombike.models.Produttore;
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
	
	public static OrdineDTO buildOrdineDTO(Ordine o) {
		return OrdineDTO.builder()
				.dataOrdine(o.getDataOrdine())
				.id(o.getId())
				.orarioOrdine(o.getOrarioOrdine())
				.statoOrdine(o.getStatoOrdine().toString())
				.utente(buildUtenteDto(o.getUtente()))
				//.indirizzo(null)
				//.dettagli
				//.pagamento
				.build();
				
				
	}
	
	public static List<OrdineDTO> buildOrdineDTO(List<Ordine> lO) {
		return lO.stream()
				.map(o -> buildOrdineDTO(o))
				.collect(Collectors.toList());
		
	}

	public static ProduttoreDTO buildProduttoreDTO(Produttore p) {
		return ProduttoreDTO.builder()
				.id(p.getId())
				.marchio(p.getMarchio())
				.nomeAzienda(p.getNomeAzienda())
				.codiceFiscale(p.getCodiceFiscale())
				.partitaIva(p.getPartitaIva())
				.build();
	}
	
	public static List<ProduttoreDTO> buildProduttoriDTO(List<Produttore> lP) {
		return lP.stream()
				.map(p -> buildProduttoreDTO(p))
				.collect(Collectors.toList());
				
	}

	public static CategoriaDTO buildCategoriaDTO(Categoria c) {
		return CategoriaDTO.builder()
				.id(c.getId())
				.descrizione(c.getDescrizione())
				.build();
	}
	
	public static List<CategoriaDTO> buildCategorieDTO(List<Categoria> lC) {
		return lC.stream()
				.map(c -> buildCategoriaDTO(c))
				.collect(Collectors.toList());
				
	}

}
