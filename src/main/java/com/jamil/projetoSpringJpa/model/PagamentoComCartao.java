package com.jamil.projetoSpringJpa.model;

import com.jamil.projetoSpringJpa.model.enums.EstadoPagamento;

public class PagamentoComCartao extends Pagamento{
	private static final long serialVersionUID = 1L;

	private Integer numParcelas;
	
	public PagamentoComCartao() {
		// TODO Auto-generated constructor stub
	}

	public PagamentoComCartao(Long id, EstadoPagamento estadoPagamento, Pedido pedido, Integer numParcelas) {
		super(id, estadoPagamento, pedido);
		this.numParcelas = numParcelas;
	}

	public Integer getNumParcelas() {
		return numParcelas;
	}

	public void setNumParcelas(Integer numParcelas) {
		this.numParcelas = numParcelas;
	}
	
	
	
	
}
