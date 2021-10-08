package com.obedkabwe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.obedkabwe.Domain.Pedido;

@Repository
public interface pedidoRepository extends JpaRepository<Pedido, Integer> {

	
	
	
}
