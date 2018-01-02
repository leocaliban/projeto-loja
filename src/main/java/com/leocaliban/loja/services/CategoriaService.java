package com.leocaliban.loja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leocaliban.loja.domain.Categoria;
import com.leocaliban.loja.repositories.CategoriaRepository;
import com.leocaliban.loja.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class CategoriaService {
	
	//Instancia automaticamente a dependencia
	@Autowired
	private CategoriaRepository repository;
	public Categoria buscar(Long id) {
		Categoria obj = repository.findOne(id);
		if (obj == null) {
			throw new ObjetoNaoEncontradoException("Objeto Não Encontrado! Id: "+id+", Tipo: "
					+Categoria.class.getName());
		}
		return obj;
	}
}
