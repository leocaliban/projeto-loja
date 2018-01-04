package com.leocaliban.loja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leocaliban.loja.domain.Pedido;
import com.leocaliban.loja.repositories.PedidoRepository;
import com.leocaliban.loja.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class PedidoService {
	
	//Instancia automaticamente a dependencia
	@Autowired
	private PedidoRepository repository;
	public Pedido buscar(Long id) {
		Pedido obj = repository.findOne(id);
		if (obj == null) {
			throw new ObjetoNaoEncontradoException("Objeto Não Encontrado! Id: "+id+", Tipo: "
					+Pedido.class.getName());
		}
		return obj;
	}
}
