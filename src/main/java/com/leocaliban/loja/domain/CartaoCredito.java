package com.leocaliban.loja.domain;

import com.leocaliban.loja.domain.enums.EstadoPagamento;

public class CartaoCredito extends Pagamento {
	
	private static final long serialVersionUID = 1L;

	private Integer parcelas;
	
	public CartaoCredito() {
		
	}

	public CartaoCredito(Long id, EstadoPagamento estado, Pedido pedido, Integer parcelas) {
		super(id, estado, pedido);
		this.parcelas = parcelas;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}
	
	
}
