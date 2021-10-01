package com.obedkabwe;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.obedkabwe.Domain.Categoria;
import com.obedkabwe.Domain.Cidade;
import com.obedkabwe.Domain.Estado;
import com.obedkabwe.Domain.Produto;
import com.obedkabwe.repositories.CategoriaRepository;
import com.obedkabwe.repositories.CidadeRepository;
import com.obedkabwe.repositories.EstadoRepository;
import com.obedkabwe.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjpringApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProjpringApplication.class, args);
	}
	@Override
	public void run( String... args) throws Exception {
		// TODO Auto-generated method stub
		
	
		
		Categoria cat1= new Categoria(1, "informatica");
		Categoria cat2 = new Categoria(2, "Escritorio");
		
		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "MOUSE", 80.00);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
	    
		Estado est1 = new Estado(1, "Minas gerais" );
		Estado est2 = new Estado(2, "Sao paulo");
		
		Cidade c1= new Cidade(null, "Uberlandia");
		Cidade c2= new Cidade(null, "Sao paulo");
		Cidade c3= new Cidade(null, "Campinas");
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
		
		
		
		
		
		
		
	}


}
