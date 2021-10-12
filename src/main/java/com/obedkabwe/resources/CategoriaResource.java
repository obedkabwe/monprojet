package com.obedkabwe.resources;






import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.obedkabwe.Domain.Categoria;
import com.obedkabwe.service.CategoriaService;







@RestController
@RequestMapping(value = "/categoria")

public class CategoriaResource {

	@Autowired
	public CategoriaService service;
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Optional<Categoria>> find(@PathVariable  Integer id) {
	
		Optional<Categoria> obj = service.buscar(id);
		
	return ResponseEntity.ok().body(obj);
	}
	
     
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@RequestBody  Categoria obj){
		obj = service.insert(obj);
	
	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
	   return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> find(@PathVariable  Integer id, @RequestBody  Categoria obj) {
	
		return ResponseEntity.noContent().build();	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
