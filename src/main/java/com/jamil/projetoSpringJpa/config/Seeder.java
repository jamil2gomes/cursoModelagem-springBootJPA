package com.jamil.projetoSpringJpa.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jamil.projetoSpringJpa.model.Categoria;
import com.jamil.projetoSpringJpa.model.Cidade;
import com.jamil.projetoSpringJpa.model.Cliente;
import com.jamil.projetoSpringJpa.model.Endereco;
import com.jamil.projetoSpringJpa.model.Estado;
import com.jamil.projetoSpringJpa.model.ItemPedido;
import com.jamil.projetoSpringJpa.model.Pagamento;
import com.jamil.projetoSpringJpa.model.PagamentoComBoleto;
import com.jamil.projetoSpringJpa.model.PagamentoComCartao;
import com.jamil.projetoSpringJpa.model.Pedido;
import com.jamil.projetoSpringJpa.model.Produto;
import com.jamil.projetoSpringJpa.model.enums.EstadoPagamento;
import com.jamil.projetoSpringJpa.model.enums.TipoPessoa;
import com.jamil.projetoSpringJpa.repository.CategoriaRepository;
import com.jamil.projetoSpringJpa.repository.CidadeRepository;
import com.jamil.projetoSpringJpa.repository.ClienteRepository;
import com.jamil.projetoSpringJpa.repository.EnderecoRepository;
import com.jamil.projetoSpringJpa.repository.EstadoRepository;
import com.jamil.projetoSpringJpa.repository.ItemPedidoRepository;
import com.jamil.projetoSpringJpa.repository.PagamentoRepository;
import com.jamil.projetoSpringJpa.repository.PedidoRepository;
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
	
	@Autowired
	private PedidoRepository pedRepo;
	
	@Autowired
	private PagamentoRepository pagRepo;
	
	@Autowired
	private ItemPedidoRepository ipRepo;
	
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("23/05/2019 10:32"), c1, end1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/09/2019 18:52"), c1, end2);
		
		Pagamento pag1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pag1);
		
		Pagamento pag2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/08/2019 00:00"), null);
		ped2.setPagamento(pag2);
		
		c1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedRepo.saveAll(Arrays.asList(ped1, ped2));
		pagRepo.saveAll(Arrays.asList(pag1, pag2));
		
		ItemPedido i1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido i2 = new ItemPedido(ped1, p3, 0.00, 2,80.00);
		ItemPedido i3 = new ItemPedido(ped2, p2, 100.00, 2, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(i1, i2));
		ped2.getItens().addAll(Arrays.asList(i3));
		
		p1.getItens().addAll(Arrays.asList(i1));
		p2.getItens().addAll(Arrays.asList(i3));
		p3.getItens().addAll(Arrays.asList(i2));
		
		ipRepo.saveAll(Arrays.asList(i1, i2, i3));
	}
	
	

}
