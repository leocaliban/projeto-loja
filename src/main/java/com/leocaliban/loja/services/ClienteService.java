package com.leocaliban.loja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leocaliban.loja.domain.Cliente;
import com.leocaliban.loja.repositories.ClienteRepository;
import com.leocaliban.loja.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	public Cliente buscar(Long id) {
		Cliente obj = repository.findOne(id);
		if (obj == null) {
			throw new ObjetoNaoEncontradoException("Objeto Não Encontrado! Id: "+id+", Tipo: "
					+Cliente.class.getName());
		}
		return obj;
	}
}
