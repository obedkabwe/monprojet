package com.obedkabwe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;


import com.obedkabwe.Domain.Cliente;

import com.obedkabwe.dto.ClienteDTO;
import com.obedkabwe.repositories.ClienteRepository;




@Service
public class ClienteService {

	@Autowired
	public ClienteRepository repo;
	
	public Optional<Cliente> find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj;
	}
	
	
	
	
	
public Cliente update (Cliente obj) {
	find(obj.getId());
	return repo.save(obj);
}	
	
	
	
public void delete(Integer id) {
	find(id);
	try {
	repo.deleteById(id);
	}
catch (DataIntegrityViolationException e) {
    throw new DataIntegrityViolationException("nao e possivel excluir uma categoria q possui produtos");
}

}
	
	public List<Cliente> findAll() {
	// TODO Auto-generated method stub
	return repo.findAll() ;
}	
	
	
	
	public	Page<Cliente> findPage(Integer page, Integer linesPerPage,String orderBy, String direction ){
   	 PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
   			 orderBy);
   	 return repo.findAll(pageRequest);
    }
	
	
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}
	
	
	
	
	
	
	
	
	
	
	
}
