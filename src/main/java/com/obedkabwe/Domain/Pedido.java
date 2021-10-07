package com.obedkabwe.Domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
 
@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
@GeneratedValue(strategy = GenerationType.IDENTITY)

@Id
private Integer id;
private Date instante;
	
    @ManyToOne
    @JoinColumn(name="enderecoDeEntrega_id")
	private Endereco enderecoDeEntrega;
    
    @ManyToOne
    @JoinColumn(name="cliente_id")
	private Cliente cliente;
	
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private Pagamento pagamento;
	
	
	public Pedido() {
		
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getInstante() {
		return instante;
	}


	public void setInstante(Date instante) {
		this.instante = instante;
	}


	public Endereco getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}


	public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Pagamento getPagamento() {
		return pagamento;
	}


	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}


	public Pedido(Integer id, Date instante, Endereco enderecoDeEntrega, Cliente cliente, Pagamento pagamento) {
		super();
		this.id = id;
		this.instante = instante;
		this.enderecoDeEntrega = enderecoDeEntrega;
		this.cliente = cliente;
		this.pagamento = pagamento;
	}
	
	
	
	
	
}
