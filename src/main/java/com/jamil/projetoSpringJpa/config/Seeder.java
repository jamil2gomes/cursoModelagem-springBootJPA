package com.jamil.projetoSpringJpa.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jamil.projetoSpringJpa.model.Categoria;
import com.jamil.projetoSpringJpa.model.Produto;
import com.jamil.projetoSpringJpa.repository.CategoriaRepository;
import com.jamil.projetoSpringJpa.repository.ProdutoRepository;

@Configuration
public class Seeder implements CommandLineRunner{

	@Autowired
	private CategoriaRepository catRepo;
	
	@Autowired
	private ProdutoRepository prodRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Escritorio");
		Categoria cat2 = new Categoria(null, "Informatica");
		
		Produto p1 = new Produto(null, "Impressora", 800.00);
		Produto p2 = new Produto(null, "Mouse", 20.00);
		Produto p3 = new Produto(null, "Computador", 2000.00);
		
		cat1.adicionaProduto(p1);
		cat2.adicionaProduto(p1);
		cat2.adicionaProduto(p2);
		cat2.adicionaProduto(p3);
		
		p1.adicionaCategoria(cat1);
		p1.adicionaCategoria(cat2);
		p2.adicionaCategoria(cat2);
		p3.adicionaCategoria(cat2);
		
		
		catRepo.saveAll(Arrays.asList(cat1, cat2));
		prodRepo.saveAll(Arrays.asList(p1, p2, p3));
		
		
	}
	
	

}
