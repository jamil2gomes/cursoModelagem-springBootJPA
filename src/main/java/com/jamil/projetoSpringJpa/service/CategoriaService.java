package com.jamil.projetoSpringJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamil.projetoSpringJpa.model.Categoria;
import com.jamil.projetoSpringJpa.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	
	public Categoria findBy(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public List<Categoria>findAll(){
		return repo.findAll();
	}
}
