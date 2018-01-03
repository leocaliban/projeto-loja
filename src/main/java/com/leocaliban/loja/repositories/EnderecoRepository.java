package com.leocaliban.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leocaliban.loja.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
