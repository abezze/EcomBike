package com.betacom.ecombike.services.implementations;

import static com.betacom.ecombike.utilities.Mapper.buildPagamentoDTO;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.ecombike.dto.inputs.PagamentoReq;
import com.betacom.ecombike.dto.outputs.PagamentoDTO;
import com.betacom.ecombike.exceptions.EcomBikeException;
import com.betacom.ecombike.models.Ordine;
import com.betacom.ecombike.models.Pagamento;
import com.betacom.ecombike.models.TipoPagamento;
import com.betacom.ecombike.repositories.IOrdineRepository;
import com.betacom.ecombike.repositories.IPagamentoRepository;
import com.betacom.ecombike.repositories.ITipoPagamentoRepository;
import com.betacom.ecombike.services.interfaces.IMessaggioServices;
import com.betacom.ecombike.services.interfaces.IPagamentoServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class PagamentoImpl implements IPagamentoServices{

	
	private final IPagamentoRepository pagR;
	private final IMessaggioServices msgS;
	private final IOrdineRepository ordR;
	private final ITipoPagamentoRepository tipoPagamR;


    
	
    @Override
	public void create(PagamentoReq req) throws Exception {
	
		log.debug("create {}", req);
		
		
		TipoPagamento tipPag = tipoPagamR.findById(req.getTipoPagamentoId())
				.orElseThrow(() -> new EcomBikeException("TipoPagamento non trovato :" + req.getTipoPagamentoId()));
		
		Ordine ord = ordR.findById(req.getOrdineId())
				.orElseThrow(() -> new EcomBikeException("Ordine non trovato : "+ req.getOrdineId()));
		
		Pagamento pagam = new Pagamento();
		pagam.setDataPagamento(req.getDataPagamento());
		pagam.setOrarioPagamento(req.getOrarioPagamento());
		pagam.setAmount(req.getAmount());
		
		pagam.setOrdine(ord);
		pagam.setTipoPagamento(tipPag);
	
		
		pagR.save(pagam);
	}
    

    

	@Override
	public void update(PagamentoReq req) throws Exception {
		
		log.debug("update {}", req);
		Pagamento ut = pagR.findById(req.getId())
				.orElseThrow( () -> new EcomBikeException(msgS.get("user_nt_fnd")));
		if(req.getDataPagamento()!= null)
			ut.setDataPagamento(req.getDataPagamento());
		if(req.getOrarioPagamento()!=null)
			ut.setOrarioPagamento(req.getOrarioPagamento());;
		if(req.getAmount()!=null)
			ut.setAmount(req.getAmount());
		
			
		pagR.save(ut);
	}

	@Override
	public void delete(Long id) throws Exception {
		log.debug("delete {}", id);
		Pagamento ut = pagR.findById(id)
				.orElseThrow( () -> new EcomBikeException(msgS.get("user_nt_fnd")));
		
		pagR.delete(ut);
	}

	@Override
	public List<PagamentoDTO> list() throws Exception{
		log.debug(" list Pagamento" );
		
		List<Pagamento> lU = pagR.findAll();
		
		
		return  buildPagamentoDTO(lU);
	}

	@Override
	public PagamentoDTO findById(Long id) throws Exception {
		log.debug("getByUserName   {}",id);
		
		Pagamento u = pagR.findById(id)
				.orElseThrow(() -> new EcomBikeException("user_ntfnd"));
		
		
		return buildPagamentoDTO(u);
	}

}
