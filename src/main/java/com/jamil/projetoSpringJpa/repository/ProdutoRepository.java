package com.jamil.projetoSpringJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamil.projetoSpringJpa.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
