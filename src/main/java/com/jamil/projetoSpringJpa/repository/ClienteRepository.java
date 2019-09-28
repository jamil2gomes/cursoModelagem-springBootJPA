package com.jamil.projetoSpringJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamil.projetoSpringJpa.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
