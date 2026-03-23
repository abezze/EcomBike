package com.betacom.ecombike.services.implementations;

import static com.betacom.ecombike.utilities.Mapper.buildTipoPagamentoDTO;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.ecombike.dto.inputs.TipoPagamentoReq;
import com.betacom.ecombike.dto.outputs.TipoPagamentoDTO;
import com.betacom.ecombike.exceptions.EcomBikeException;
import com.betacom.ecombike.models.TipoPagamento;
import com.betacom.ecombike.repositories.ITipoPagamentoRepository;
import com.betacom.ecombike.services.interfaces.IMessaggioServices;
import com.betacom.ecombike.services.interfaces.ITipoPagamentoServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class TipoPagamentoImpl implements ITipoPagamentoServices{

	
	private final ITipoPagamentoRepository pagR;
	private final IMessaggioServices msgS;


    
	
    @Override
	public void create(TipoPagamentoReq req) throws Exception {
	
		log.debug("create {}", req);
		
		
		TipoPagamento pagam = new TipoPagamento();
		pagam.setSocietaCreditrice(req.getSocietaCreditrice());
		pagam.setTipoPagamento(req.getTipoPagamento());
	
		
		pagR.save(pagam);
	}
    

    

	@Override
	public void update(TipoPagamentoReq req) throws Exception {
		
		log.debug("update {}", req);
		TipoPagamento ut = pagR.findById(req.getId())
				.orElseThrow( () -> new EcomBikeException(msgS.get("user_nt_fnd")));
		if (req.getClass()!=null)
			ut.setSocietaCreditrice(req.getSocietaCreditrice());
		if (req.getTipoPagamento()!=null)
			ut.setTipoPagamento(req.getTipoPagamento());
		
			
		pagR.save(ut);
	}

	@Override
	public void delete(Long id) throws Exception {
		log.debug("delete {}", id);
		TipoPagamento ut = pagR.findById(id)
				.orElseThrow( () -> new EcomBikeException(msgS.get("user_nt_fnd")));
		
		pagR.delete(ut);
	}

	@Override
	public List<TipoPagamentoDTO> list() throws Exception{
		log.debug(" list TipoPagamento" );
		
		List<TipoPagamento> lU = pagR.findAll();
		
		
		return  buildTipoPagamentoDTO(lU);
	}

	@Override
	public TipoPagamentoDTO findById(Long id) throws Exception {
		log.debug("getByUserName   {}",id);
		
		TipoPagamento u = pagR.findById(id)
				.orElseThrow(() -> new EcomBikeException("user_ntfnd"));
		
		
		return buildTipoPagamentoDTO(u);
	}

}
