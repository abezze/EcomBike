package com.betacom.ecombike.utilities;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.betacom.ecombike.dto.outputs.ProdottoDTO;
import com.betacom.ecombike.models.Prodotto;
import com.betacom.ecombike.services.interfaces.IUploadServices;

import static com.betacom.ecombike.utilities.Mapper.buildCategoriaDTO;
import static com.betacom.ecombike.utilities.Mapper.buildDettaglioOrdineSenzaOrdineDTO;
import static com.betacom.ecombike.utilities.Mapper.buildProduttoreDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ProdottoMapper {

	private final IUploadServices uplS; 
	
	public  ProdottoDTO buildProdottoDTO(Prodotto p) {
		return ProdottoDTO.builder()
				.productCode(p.getProductCode())
				.descrizione(p.getDescrizione())
				.colore(p.getColore())
				.peso(p.getPeso())
				.taglia(p.getTaglia())
				.quantita(p.getQuantita())
				.image(uplS.buildUrl(p.getImage()))
				.categoria(p.getCategoria()!=null?
						buildCategoriaDTO(p.getCategoria()): null
						)
				/*.dettaglioOrdine(p.getDettaglioOrdine()!=null?
						buildDettaglioOrdineSenzaOrdineDTO(p.getDettaglioOrdine()):null
						)*/
				.produttore(p.getProduttore()!=null?
						buildProduttoreDTO(p.getProduttore()):null
						)
				.build();
	}
	
	
	
	public  List<ProdottoDTO> buildProdottiDTO(List<Prodotto> lP){
		return lP.stream()
				.map(p-> buildProdottoDTO(p))
				.collect(Collectors.toList());
	}
}
