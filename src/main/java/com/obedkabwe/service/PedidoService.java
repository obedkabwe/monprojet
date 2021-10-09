package com.obedkabwe.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obedkabwe.Domain.Pedido;
import com.obedkabwe.repositories.pedidoRepository;

@Service
public class PedidoService {

	@Autowired
	public pedidoRepository  repo;
	
	public Optional<Pedido> buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
