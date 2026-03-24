package com.betacom.ecombike.utilities;

import java.util.List;
import java.util.stream.Collectors;

import com.betacom.ecombike.dto.outputs.AnagraficaDTO;
import com.betacom.ecombike.dto.outputs.CategoriaDTO;
import com.betacom.ecombike.dto.outputs.DettaglioOrdineDTO;
import com.betacom.ecombike.dto.outputs.IndirizzoSpedizioneDTO;
import com.betacom.ecombike.dto.outputs.OrdineDTO;
import com.betacom.ecombike.dto.outputs.PagamentoDTO;
import com.betacom.ecombike.dto.outputs.ProdottoDTO;
import com.betacom.ecombike.dto.outputs.ProduttoreDTO;
import com.betacom.ecombike.dto.outputs.TipoPagamentoDTO;
import com.betacom.ecombike.dto.outputs.UtenteDTO;
import com.betacom.ecombike.models.Anagrafica;
import com.betacom.ecombike.models.Categoria;
import com.betacom.ecombike.models.DettaglioOrdine;
import com.betacom.ecombike.models.IndirizzoSpedizione;
import com.betacom.ecombike.models.Ordine;
import com.betacom.ecombike.models.Pagamento;
import com.betacom.ecombike.models.Prodotto;
import com.betacom.ecombike.models.Produttore;
import com.betacom.ecombike.models.TipoPagamento;
import com.betacom.ecombike.models.Utente;

public class Mapper {

	
	
	public static UtenteDTO buildUtenteDto(Utente u) {
		return UtenteDTO.builder() 
				.userName(u.getUserName())
			    .password(u.getPassword())
			    .role(u.getRole().toString())
			    .email(u.getEmail())
			    .anagrafiche(buildAnagraficaSenzaUtenteDTO(u.getAnagrafiche()))
			    .build();
	}
	
	public static UtenteDTO buildUtenteSenzaAnagraficheDto(Utente u) {
		return UtenteDTO.builder() 
				.userName(u.getUserName())
			    .password(u.getPassword())
			    .role(u.getRole().toString())
			    .email(u.getEmail())
			    //.anagrafiche(buildAnagraficaSenzaUtenteDTO(u.getAnagrafiche()))
			    .build();
	}
	
	public static UtenteDTO buildUtenteSenzaAnagraficaDto(Utente u) {
		return UtenteDTO.builder() 
				.userName(u.getUserName())
			    .password(u.getPassword())
			    .role(u.getRole().toString())
			    .email(u.getEmail())
			    .build();
	}
	
	public static AnagraficaDTO buildAnagraficaSenzaUtenteDTO(Anagrafica a) {
		return AnagraficaDTO.builder()
				.id(a.getId())
				//.utente(buildUtenteDto(a.getUtente()))
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
	
	public static List<AnagraficaDTO> buildAnagraficaSenzaUtenteDTO(List<Anagrafica> lA) {
		return lA.stream()
				.map( a -> buildAnagraficaSenzaUtenteDTO(a))
				.collect(Collectors.toList());
				
	}
	
	public static AnagraficaDTO buildAnagraficaDTO(Anagrafica a) {
		return AnagraficaDTO.builder()
				.id(a.getId())
				.utente(buildUtenteSenzaAnagraficaDto(a.getUtente()))
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
				.utente(o.getUtente()!=null?buildUtenteSenzaAnagraficheDto(o.getUtente()): null)
				.indirizzo(o.getIndirizzo()!=null? buildIndirizzoSpedizioneDTO(o.getIndirizzo()) : null)
				.dettagli(o.getDettagli()!=null ? buildDettaglioOrdineSenzaOrdineDTO(o.getDettagli()):null)
				.pagamento(o.getPagamento()!=null? buildPagamentoDTO(o.getPagamento()):null)
				.build();
				
	}
	
	public static List<OrdineDTO> buildOrdineDTO(List<Ordine> lO) {
		return lO.stream()
				.map(o -> buildOrdineDTO(o))
				.collect(Collectors.toList());
		
	}

	public static ProduttoreDTO buildProduttoreDTO(Produttore p) {
		if (p == null) return null;
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
		if (c == null) return null;
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
	
	public static IndirizzoSpedizioneDTO buildIndirizzoSpedizioneDTO(IndirizzoSpedizione a) {
		return IndirizzoSpedizioneDTO.builder()
				.id(a.getId())
				//.ordineIndirizzo(buildOrdineDTO(a.getOrdineIndirizzo()))
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
	
	public static List<IndirizzoSpedizioneDTO> buildIndirizzoSpedizioneDTO(List<IndirizzoSpedizione> lA) {
		return lA.stream()
				.map( a -> buildIndirizzoSpedizioneDTO(a))
				.collect(Collectors.toList());
				
	}
	
	public static PagamentoDTO buildPagamentoDTO(Pagamento p) {
		return PagamentoDTO.builder()
				.id(p.getId())
				.amount(p.getAmount())
				.dataPagamento(p.getDataPagamento())
				.orarioPagamento(p.getOrarioPagamento())
				.tipoPagamento(buildTipoPagamentoDTO(p.getTipoPagamento()))
				.ordine(null)
				.build();
				
	}
	
	public static List<PagamentoDTO> buildPagamentoDTO(List<Pagamento> lP) {
		return lP.stream()
				.map(p -> buildPagamentoDTO(p))
				.collect(Collectors.toList());
	}
	
	public static TipoPagamentoDTO buildTipoPagamentoDTO(TipoPagamento t) {
		return TipoPagamentoDTO.builder()
				.id(t.getId())
				.societaCreditrice(t.getSocietaCreditrice())
				.tipoPagamento(t.getTipoPagamento())
				.build();
	}
	
	public static List<TipoPagamentoDTO> buildTipoPagamentoDTO(List<TipoPagamento> lT){
		return lT.stream()
				.map(p-> buildTipoPagamentoDTO(p))
				.collect(Collectors.toList());
	}
	
	public static DettaglioOrdineDTO buildDettaglioOrdineDTO(DettaglioOrdine d) {
		if (d == null) return null;
		return DettaglioOrdineDTO.builder()
				.id(d.getId())
				.quantita(d.getQuantita())
				.ordine(buildOrdineDTO(d.getOrdine()))
				//.prodotto(buildProdottoDTO(d.getProdotto()))
				.build();
	}
	public static DettaglioOrdineDTO buildDettaglioOrdineSenzaOrdineDTO(DettaglioOrdine d) {
		if (d == null) return null;
		return DettaglioOrdineDTO.builder()
				.id(d.getId())
				.quantita(d.getQuantita())
				//.ordine(buildOrdineDTO(d.getOrdine()))
				//.prodotto(buildProdottoDTO(d.getProdotto()))
				.build();
	}
	
	public static List<DettaglioOrdineDTO> buildDettaglioOrdineSenzaOrdineDTO(List<DettaglioOrdine> lD) {
		return lD.stream()
				.map(d -> buildDettaglioOrdineSenzaOrdineDTO(d) )
				.collect(Collectors.toList());
	}
	
	public static List<DettaglioOrdineDTO> buildDettaglioOrdineDTO(List<DettaglioOrdine> lD) {
		return lD.stream()
				.map(d -> buildDettaglioOrdineDTO(d) )
				.collect(Collectors.toList());
	}
	
	public static ProdottoDTO buildProdottoDTO(Prodotto p) {
		return ProdottoDTO.builder()
				.productCode(p.getProductCode())
				.descrizione(p.getDescrizione())
				.colore(p.getColore())
				.peso(p.getPeso())
				.taglia(p.getTaglia())
				.categoria(
						buildCategoriaDTO(p.getCategoria())
						)
				.dettaglioOrdine(
						buildDettaglioOrdineDTO(p.getDettaglioOrdine())
						)
				.produttore(
						buildProduttoreDTO(p.getProduttore())
						)
				.build();
	}
	
	public static List<ProdottoDTO> buildProdottiDTO(List<Prodotto> lP){
		return lP.stream()
				.map(p-> buildProdottoDTO(p))
				.collect(Collectors.toList());
	}

}
