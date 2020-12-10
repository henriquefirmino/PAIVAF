package com.paaf.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.paaf.exception.Excecao;
import com.paaf.model.CategoriaProduto;

public interface CategoriaProdutoService {

	public List<CategoriaProduto> getListaCategorias();
	
	public void salvarCategoria(CategoriaProduto categoria);
	
	public void salvarListaCategoria(List<CategoriaProduto> lista);
	
	public CategoriaProduto getCategoria(ObjectId id) throws Excecao;
	
	public void removerCategoria(ObjectId id) throws Excecao;
	
	public CategoriaProduto buscarPorNome(String nome);
	
}
