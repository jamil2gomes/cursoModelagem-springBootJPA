package com.jamil.projetoSpringJpa.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jamil.projetoSpringJpa.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?>findBy(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findBy(id));
	}
	
	
	@GetMapping
	public ResponseEntity<?>findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	

}
