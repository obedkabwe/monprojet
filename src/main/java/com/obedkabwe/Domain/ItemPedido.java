package com.obedkabwe.Domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemPedidoPk id = new ItemPedidoPk();
	
	
	private Double desconto;
	private Integer quantidade;
	private Double preco;
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}

	public ItemPedido() {
		
	}


	public ItemPedidoPk getId() {
		return id;
	}


	public void setId(ItemPedidoPk id) {
		this.id = id;
	}


	public Double getDesconto() {
		return desconto;
	}


	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public ItemPedido(Produto produto, Pedido pedido, Double desconto, Integer quantidade, Double preco) {
		super();
		id.setProduto(produto);
		id.setPedido(pedido);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
