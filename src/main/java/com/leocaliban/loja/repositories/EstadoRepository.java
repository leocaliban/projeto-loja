package com.leocaliban.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leocaliban.loja.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
