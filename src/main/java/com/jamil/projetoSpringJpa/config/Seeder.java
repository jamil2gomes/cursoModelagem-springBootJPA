package com.jamil.projetoSpringJpa.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jamil.projetoSpringJpa.model.Categoria;
import com.jamil.projetoSpringJpa.model.Cidade;
import com.jamil.projetoSpringJpa.model.Cliente;
import com.jamil.projetoSpringJpa.model.Endereco;
import com.jamil.projetoSpringJpa.model.Estado;
import com.jamil.projetoSpringJpa.model.Produto;
import com.jamil.projetoSpringJpa.model.enums.TipoPessoa;
import com.jamil.projetoSpringJpa.repository.CategoriaRepository;
import com.jamil.projetoSpringJpa.repository.CidadeRepository;
import com.jamil.projetoSpringJpa.repository.ClienteRepository;
import com.jamil.projetoSpringJpa.repository.EnderecoRepository;
import com.jamil.projetoSpringJpa.repository.EstadoRepository;
import com.jamil.projetoSpringJpa.repository.ProdutoRepository;

@Configuration
public class Seeder implements CommandLineRunner{

	@Autowired
	private CategoriaRepository catRepo;
	
	@Autowired
	private ProdutoRepository prodRepo;
	
	@Autowired
	private CidadeRepository cidRepo;
	
	@Autowired
	private EstadoRepository estRepo;
	
	@Autowired
	private ClienteRepository cliRepo;
	
	@Autowired
	private EnderecoRepository endRepo;
	
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
		
		
		
		Estado es1 = new Estado(null, "Maranhao");
		Estado es2 = new Estado(null, "Recife");
		
		estRepo.saveAll(Arrays.asList(es1, es2));
		
		Cidade cid1 = new Cidade(null, "Sao Luis", es1);
		
		cidRepo.saveAll(Arrays.asList(cid1));
		
		Cliente c1 = new Cliente(null, "John Green","user@gmail.com", "23454346", TipoPessoa.PESSOAFISICA);
		Cliente c2 = new Cliente(null, "Mary Blue","user23@gmail.com", "23454346", TipoPessoa.PESSOAFISICA);

		c1.getTelefones().addAll(Arrays.asList("32365543", "982034532"));
		c2.getTelefones().addAll(Arrays.asList("32364443", "983334532"));
		
		cliRepo.saveAll(Arrays.asList(c1, c2));
		
		Endereco end1 = new Endereco(null, "Rua 1", "09", "Quadra H","Cohama","6500000", c1, cid1);
		Endereco end2 = new Endereco(null, "Rua 2", "23", "Quadra M","Angelim","6500000", c2, cid1);
		
		endRepo.saveAll(Arrays.asList(end1, end2));
		
	}
	
	

}
