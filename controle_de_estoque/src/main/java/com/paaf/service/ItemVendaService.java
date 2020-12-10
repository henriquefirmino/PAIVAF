package com.paaf.service;

import java.util.List;

import com.paaf.exception.Excecao;
import com.paaf.model.ItemVenda;

public interface ItemVendaService {

	public List<ItemVenda> getListaItensVenda();
	
	public void salvarItemVenda(ItemVenda item);
	
	public void salvarListaItemVenda(List<ItemVenda> lista);
	
	public ItemVenda getItemVenda(Long id) throws Excecao;
	
	public void removerItemVenda(Long id) throws Excecao;
}
