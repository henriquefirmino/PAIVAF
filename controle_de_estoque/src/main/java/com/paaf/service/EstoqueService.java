package com.paaf.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.paaf.exception.Excecao;
import com.paaf.model.Estoque;

public interface EstoqueService {

	public List<Estoque> getListaEstoques();
	
	public Estoque salvarEstoque(Estoque estoque);

	public Estoque getEstoque(ObjectId id) throws Excecao;
	
	public void removerEstoque(ObjectId id) throws Excecao;
}
