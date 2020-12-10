package com.paaf.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.paaf.exception.Excecao;
import com.paaf.model.Cliente;

public interface ClienteService {

	public List<Cliente> getListaClientes();
	
	public void salvarCliente(Cliente cliente);

	public Cliente getCliente(ObjectId id) throws Excecao;
	
	public void removerCliente(ObjectId id) throws Excecao;
}
