package com.jamil.projetoSpringJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamil.projetoSpringJpa.model.Pedido;
import com.jamil.projetoSpringJpa.repository.PedidoRepository;
import com.jamil.projetoSpringJpa.service.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	
	public Pedido findBy(Long id) {
		
		return repo.findById(id).orElseThrow(()->new ObjectNotFoundException(""
				+ "Objeto não encontrado! Id: " + id + 
				", Tipo: " + Pedido.class.getName()));
	}
	
	public List<Pedido>findAll(){
		return repo.findAll();
	}
}
