package com.leocaliban.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leocaliban.loja.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
