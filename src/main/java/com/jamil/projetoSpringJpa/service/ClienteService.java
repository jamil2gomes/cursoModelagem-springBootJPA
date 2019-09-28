package com.jamil.projetoSpringJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamil.projetoSpringJpa.model.Cliente;
import com.jamil.projetoSpringJpa.repository.ClienteRepository;
import com.jamil.projetoSpringJpa.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	
	public Cliente findBy(Long id) {
		
		return repo.findById(id).orElseThrow(()->new ObjectNotFoundException(""
				+ "Objeto não encontrado! Id: " + id + 
				", Tipo: " + Cliente.class.getName()));
	}
	
	public List<Cliente>findAll(){
		return repo.findAll();
	}
}
