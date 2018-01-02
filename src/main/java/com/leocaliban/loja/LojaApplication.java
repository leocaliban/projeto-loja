package com.leocaliban.loja;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leocaliban.loja.domain.Categoria;
import com.leocaliban.loja.repositories.CategoriaRepository;

@SpringBootApplication
public class LojaApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);
	}

	//Através do CommandLineRunner por padrão será instanciado esses objetos ao iniciar a aplicação
	@Override
	public void run(String... arg0) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Telefonia");
		categoriaRepository.save(Arrays.asList(cat1,cat2));
	}
}
