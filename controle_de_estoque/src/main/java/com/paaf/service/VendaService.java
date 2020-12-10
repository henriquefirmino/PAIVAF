package com.paaf.service;

import java.util.List;

import com.paaf.exception.Excecao;
import com.paaf.model.Venda;

public interface VendaService {

	public List<Venda> getListaVendas();
	
	public void salvarVenda(Venda venda);
	
	public Venda getVenda(Long id) throws Excecao;
	
	public void removerVenda(Long id) throws Excecao;
}
