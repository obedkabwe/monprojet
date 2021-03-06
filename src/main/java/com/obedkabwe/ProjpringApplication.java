package com.obedkabwe;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.obedkabwe.Domain.Categoria;
import com.obedkabwe.Domain.Cidade;
import com.obedkabwe.Domain.Cliente;
import com.obedkabwe.Domain.Endereco;
import com.obedkabwe.Domain.Estado;
import com.obedkabwe.Domain.ItemPedido;
import com.obedkabwe.Domain.Pagamento;
import com.obedkabwe.Domain.PagamentoComBoleto;
import com.obedkabwe.Domain.PagamentoComCartao;
import com.obedkabwe.Domain.Pedido;
import com.obedkabwe.Domain.Produto;
import com.obedkabwe.Domain.enums.Estadopagamento;
import com.obedkabwe.Domain.enums.TipoCliente;
import com.obedkabwe.repositories.CategoriaRepository;
import com.obedkabwe.repositories.CidadeRepository;
import com.obedkabwe.repositories.ClienteRepository;
import com.obedkabwe.repositories.EnderecoRepository;
import com.obedkabwe.repositories.EstadoRepository;
import com.obedkabwe.repositories.ItemPedidoRepository;
import com.obedkabwe.repositories.PagamentoRepository;
import com.obedkabwe.repositories.ProdutoRepository;
import com.obedkabwe.repositories.pedidoRepository;

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
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private pedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProjpringApplication.class, args);
	}
	@Override
	public void run( String... args) throws Exception {
		// TODO Auto-generated method stub
		
	
		
		Categoria cat1= new Categoria(1, "informatica");
		Categoria cat2 = new Categoria(2, "Escritorio");
		Categoria cat3 = new Categoria(3, "resource humano");
		Categoria cat4 = new Categoria(4, "limpeza");
		Categoria cat5 = new Categoria(5, "manutencao");
		Categoria cat6 = new Categoria(6, "seguranca");
		Categoria cat7 = new Categoria(7, "acougero");
		Categoria cat8 = new Categoria(8, "vegetable");
		Categoria cat9 = new Categoria(9, "diverse");
		Categoria cat10 = new Categoria(10, "bebida");
		
		
		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "MOUSE", 80.00);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2,cat3));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2,cat3,cat4,cat5,cat6,cat7,cat8,cat9,cat10));
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
		
		
		Cliente cli1= new Cliente(null, "Obed Kabwe", "kabwe@gmail.com", "791242497", TipoCliente.PESSOAFISCA);
		cli1.getTelefones().addAll(Arrays.asList("981820345","89737272"));
		
		Endereco e1 = new Endereco(null, "Rua Dasdores", "24", "Apt 308", "ceilandia", "394093", c1, cli1);
		Endereco e2 = new Endereco(null, "Villa ", "4", "Apt 08", "recanto", "3563", c2, cli1);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/05/1997 21:06"), cli1, e1 );
        Pedido ped2 = new Pedido(null, sdf.parse("03/11/1967 11:06"), cli1, e2);
				
		Pagamento pagto1 = new PagamentoComCartao(null, Estadopagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, Estadopagamento.PENDETE, ped2, sdf.parse("09/02/2017 21:06"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(p1, ped1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(p3, ped1, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(p2, ped2, 100.00, 1, 800.00);
	
	    ped1.getItens().addAll(Arrays.asList(ip1,ip2));
	    ped2.getItens().addAll(Arrays.asList(ip3));
	    
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
	
		
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
		
	
	}


}
