package com.jamil.projetoSpringJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamil.projetoSpringJpa.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
