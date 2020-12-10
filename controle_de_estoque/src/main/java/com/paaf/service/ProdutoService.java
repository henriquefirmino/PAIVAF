package com.paaf.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.paaf.exception.Excecao;
import com.paaf.model.Produto;

public interface ProdutoService {

	public List<Produto> getListaProdutos();
	
	public void salvarProduto(Produto produto);
	
	public Produto getProduto(ObjectId id) throws Excecao;
	
	public void removerProduto(ObjectId id) throws Excecao;
}
