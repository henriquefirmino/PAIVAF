package com.paaf.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.paaf.exception.Excecao;
import com.paaf.model.Fornecedor;

public interface FornecedorService {

	public List<Fornecedor> getListaFornecedores();
	
	public void salvarFornecedor(Fornecedor fornecedor);
	
	public Fornecedor getFornecedor(ObjectId id) throws Excecao;
	
	public void removerFornecedor(ObjectId id) throws Excecao;
}
