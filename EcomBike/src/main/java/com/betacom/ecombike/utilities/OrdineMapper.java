package com.betacom.ecombike.utilities;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.betacom.ecombike.dto.outputs.OrdineDTO;
import com.betacom.ecombike.models.Ordine;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class OrdineMapper {
	
	public final ProdottoMapper PROD_M;
	
	public OrdineDTO buildOrdineDTO(Ordine o) {
		return OrdineDTO.builder()
				.dataOrdine(o.getDataOrdine())
				.id(o.getId())
				.orarioOrdine(o.getOrarioOrdine())
				.statoOrdine(o.getStatoOrdine().toString())
				.utente(o.getUtente()!=null?Mapper.buildUtenteSenzaAnagraficheDto(o.getUtente()): null)
				.indirizzo(o.getIndirizzo()!=null? Mapper.buildIndirizzoSpedizioneDTO(o.getIndirizzo()) : null)
				.dettagli(o.getDettagli()!=null ? PROD_M.buildDettaglioOrdineSenzaOrdineDTO(o.getDettagli()):null)
				.pagamento(o.getPagamento()!=null? Mapper.buildPagamentoDTO(o.getPagamento()):null)
				.build();
				
	}
	
	public List<OrdineDTO> buildOrdineDTO(List<Ordine> lO) {
		return lO.stream()
				.map(o -> buildOrdineDTO(o))
				.collect(Collectors.toList());
		
	}

}
