package com.obedkabwe.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obedkabwe.Domain.Cliente;
import com.obedkabwe.repositories.ClienteRepository;




@Service
public class ClienteService {

	@Autowired
	public ClienteRepository repo;
	
	public Optional<Cliente> buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
