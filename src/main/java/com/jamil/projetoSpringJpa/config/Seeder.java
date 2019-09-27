package com.jamil.projetoSpringJpa.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jamil.projetoSpringJpa.model.Categoria;
import com.jamil.projetoSpringJpa.repository.CategoriaRepository;

@Configuration
public class Seeder implements CommandLineRunner{

	@Autowired
	private CategoriaRepository catRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Escritorio");
		Categoria cat2 = new Categoria(null, "Informatica");
		
		catRepo.saveAll(Arrays.asList(cat1, cat2));
		
		
	}
	
	

}
