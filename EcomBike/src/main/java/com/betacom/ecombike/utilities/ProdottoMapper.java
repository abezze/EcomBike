package com.betacom.ecombike.utilities;

import static com.betacom.ecombike.utilities.Mapper.buildCategoriaDTO;
import static com.betacom.ecombike.utilities.Mapper.buildProduttoreDTO;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.betacom.ecombike.dto.outputs.DettaglioOrdineDTO;
import com.betacom.ecombike.dto.outputs.ProdottoDTO;
import com.betacom.ecombike.models.DettaglioOrdine;
import com.betacom.ecombike.models.Prodotto;
import com.betacom.ecombike.services.interfaces.IUploadServices;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ProdottoMapper {

	private final IUploadServices uplS; 
	
	public  ProdottoDTO buildProdottoDTO(Prodotto p) {
		String image = null;
		try {
			image = uplS.buildUrl(p.getImage());
		} catch(Exception ignore) {}
		
		return ProdottoDTO.builder()
				.productCode(p.getProductCode())
				.descrizione(p.getDescrizione())
				.colore(p.getColore())
				.peso(p.getPeso())
				.taglia(p.getTaglia())
				.quantita(p.getQuantita())
				.prezzo(p.getPrezzo())
				.image(image)
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
	
	public  List<DettaglioOrdineDTO> buildDettaglioOrdineSenzaOrdineDTO(List<DettaglioOrdine> lD) {
		return lD.stream()
				.map(d -> buildDettaglioOrdineSenzaOrdineDTO(d) )
				.collect(Collectors.toList());
	}
	public DettaglioOrdineDTO buildDettaglioOrdineSenzaOrdineDTO(DettaglioOrdine d) {
		if (d == null) return null;
		return DettaglioOrdineDTO.builder()
				.id(d.getId())
				.quantita(d.getQuantita())
				//.ordine(buildOrdineDTO(d.getOrdine()))
				.prodotto(buildProdottoDTO(d.getProdotto()))
				.build();
	}
	
	
}
