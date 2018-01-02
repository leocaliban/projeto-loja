package com.leocaliban.loja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leocaliban.loja.domain.Categoria;
import com.leocaliban.loja.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	//Instancia automaticamente a dependencia
	@Autowired
	private CategoriaRepository repository;
	public Categoria buscar(Long id) {
		Categoria obj = repository.findOne(id);
		return obj;
	}
}
