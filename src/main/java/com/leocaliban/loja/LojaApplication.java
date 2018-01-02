package com.leocaliban.loja;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leocaliban.loja.domain.Categoria;
import com.leocaliban.loja.domain.Produto;
import com.leocaliban.loja.repositories.CategoriaRepository;
import com.leocaliban.loja.repositories.ProdutoRepository;

@SpringBootApplication
public class LojaApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);
	}

	//Através do CommandLineRunner por padrão será instanciado esses objetos ao iniciar a aplicação
	@Override
	public void run(String... arg0) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Telefonia");
				
		Produto p1 = new Produto(null, "Computador", 3500.00);
		Produto p2 = new Produto(null, "Teclado", 45.00);
		Produto p3 = new Produto(null, "Mouse", 35.00);
		Produto p4 = new Produto(null, "Celular", 890.00);
		Produto p5 = new Produto(null, "Fone De Ouvido", 16.00);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3,p5));
		cat2.getProdutos().addAll(Arrays.asList(p4,p5));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat1,cat2));
		
		categoriaRepository.save(Arrays.asList(cat1,cat2));
		produtoRepository.save(Arrays.asList(p1,p2,p3,p4,p5));
	}
}
