package com.paaf.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Estoque {

	@Id private ObjectId id;
	private String lote;
	private boolean bloq;
	private int qtd;
	private int min;
	private int max;
	private Produto produto;
	
	public Estoque() {
		super();
	}

	public Estoque(ObjectId id, String lote, boolean bloq, int qtd, int min,
		int max, Produto produto) {
			super();
			this.id = id;
			this.lote = lote;
			this.bloq = bloq;
			this.qtd = qtd;
			this.min = min;
			this.max = max;
			this.produto = produto;
		}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
	
	public String getLote() {
		return lote;
	}

	public void setLote(String codigoLote) {
		this.lote = codigoLote;
	}

	public boolean isBloq() {
		return bloq;
	}

	public void setBloq(boolean bloq) {
		this.bloq = bloq;
	}

	public int getQuantidade() {
		return qtd;
	}

	public void setQuantidade(int qtd) {
		this.qtd = qtd;
	}

	public int getMinimo() {
		return min;
	}

	public void setMinimo(int min) {
		this.min = min;
	}

	public int getMaximo() {
		return max;
	}

	public void setMaximo(int max) {
		this.max = max;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
