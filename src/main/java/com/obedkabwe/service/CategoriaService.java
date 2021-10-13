package com.obedkabwe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.obedkabwe.Domain.Categoria;
import com.obedkabwe.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	public CategoriaRepository repo;
	
	public Optional<Categoria> buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj;
	}
	
	
public Categoria insert (Categoria obj) {
	obj.setId(null);
	return repo.save(obj);
}
	
	
public Categoria update (Categoria obj) {
	buscar(obj.getId());
	return repo.save(obj);
}	
	
	
	
public void delete(Integer id) {
	
	 repo.deleteById(id);
	
}


public List<Categoria> findAll() {
	// TODO Auto-generated method stub
	return repo.findAll() ;
}	
	
	
	
	
	
	
	
	
	
	
}
