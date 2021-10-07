package com.obedkabwe.Domain;

import javax.persistence.Entity;

import com.obedkabwe.Domain.enums.Estadopagamento;

@Entity
public class PagamentoComCartao extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDaParcelas;
	
	
	
	public PagamentoComCartao() {
		
	}



	public PagamentoComCartao(Integer id, Estadopagamento estado, Pedido pedido,  Integer numeroDaParcelas) {
		super(id, estado, pedido);
		this.numeroDaParcelas = numeroDaParcelas;
	}



	public Integer getNumeroDaParcelas() {
		return numeroDaParcelas;
	}



	public void setNumeroDaParcelas(Integer numeroDaParcelas) {
		this.numeroDaParcelas = numeroDaParcelas;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
