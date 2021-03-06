package com.paaf.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Venda {

	@Id private ObjectId databaseId;
	private Integer identificador;
	private String protocolo;
	private Date data;
	private Cliente cliente;
	private List<ItemVenda> listaItensVenda;
	private BigDecimal total;

	public Venda() {
		super();
	}

	public Venda(Integer id, String protocolo, Date data, Cliente cliente, List<ItemVenda> listaItensVenda,
		BigDecimal total) {
		super();
		this.identificador = id;
		this.protocolo = protocolo;
		this.data = data;
		this.cliente = cliente;
		this.listaItensVenda = listaItensVenda;
		this.total = total;
	}
	public Integer getId() {
		return identificador;
	}
	public void setId(Integer id) {
		this.identificador = id;
	}
	public String getProtocolo() {
		return protocolo;
	}
	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemVenda> getListaItensVenda() {
		return listaItensVenda;
	}
	public void setListaItensVenda(List<ItemVenda> listaItensVenda) {
		this.listaItensVenda = listaItensVenda;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}
