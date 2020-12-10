package com.paaf.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Cliente {

	@Id protected ObjectId id;
	private String nome;
	private String documento;
	private String telefone;
	private String email;
	private List<Venda> listaVendas;

	public Cliente() {
		super();
	}

	public Cliente(String nome, String documento, String telefone, String email, List<Venda> listaVendas) {
		super();
		this.nome = nome;
		this.documento = documento;
		this.telefone = telefone;
		this.email = email;
		this.listaVendas = listaVendas;
	}
	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Venda> getListaVendas() {
		return listaVendas;
	}

	public void setListaVendas(List<Venda> listaVendas) {
		this.listaVendas = listaVendas;
	}
}
