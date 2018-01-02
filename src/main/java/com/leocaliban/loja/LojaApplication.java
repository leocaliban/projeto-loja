package com.leocaliban.loja;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leocaliban.loja.domain.Categoria;
import com.leocaliban.loja.domain.Cidade;
import com.leocaliban.loja.domain.Estado;
import com.leocaliban.loja.domain.Produto;
import com.leocaliban.loja.repositories.CategoriaRepository;
import com.leocaliban.loja.repositories.CidadeRepository;
import com.leocaliban.loja.repositories.EstadoRepository;
import com.leocaliban.loja.repositories.ProdutoRepository;

@SpringBootApplication
public class LojaApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);
	}

	//Através do CommandLineRunner por padrão será instanciado esses objetos ao iniciar a aplicação
	@Override
	public void run(String... arg0) throws Exception {
		Categoria categoria1 = new Categoria(null, "Informática");
		Categoria categoria2 = new Categoria(null, "Telefonia");
				
		Produto produto1 = new Produto(null, "Computador", 3500.00);
		Produto produto2 = new Produto(null, "Teclado", 45.00);
		Produto produto3 = new Produto(null, "Mouse", 35.00);
		Produto produto4 = new Produto(null, "Celular", 890.00);
		Produto produto5 = new Produto(null, "Fone De Ouvido", 16.00);
		
		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3, produto5));
		categoria2.getProdutos().addAll(Arrays.asList(produto4, produto5));
		
		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));
		produto4.getCategorias().addAll(Arrays.asList(categoria2));
		produto5.getCategorias().addAll(Arrays.asList(categoria1, categoria2));

		categoriaRepository.save(Arrays.asList(categoria1, categoria2));
		produtoRepository.save(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
		
		Estado estado1 = new Estado(null, "São Paulo");
		Estado estado2 = new Estado(null, "Rio De Janeiro");
		
		Cidade cidade1 = new Cidade(null, "Santos", estado1);
		Cidade cidade2 = new Cidade(null, "Jundiaí", estado1);
		Cidade cidade3 = new Cidade(null, "Niterói", estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1, cidade2));
		estado2.getCidades().addAll(Arrays.asList(cidade3));
		
		estadoRepository.save(Arrays.asList(estado1, estado2));
		cidadeRepository.save(Arrays.asList(cidade1, cidade2, cidade3));
	}
}
