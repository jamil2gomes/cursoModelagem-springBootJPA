package com.jamil.projetoSpringJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamil.projetoSpringJpa.model.Categoria;
import com.jamil.projetoSpringJpa.repository.CategoriaRepository;
import com.jamil.projetoSpringJpa.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	
	public Categoria findBy(Long id) {
		
		return repo.findById(id).orElseThrow(()->new ObjectNotFoundException(""
				+ "Objeto não encontrado! Id: " + id + 
				", Tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria>findAll(){
		return repo.findAll();
	}
}
