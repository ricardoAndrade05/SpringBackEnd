package com.nelioalves.coursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.coursomc.domain.Categoria;
import com.nelioalves.coursomc.domain.Cidade;
import com.nelioalves.coursomc.domain.Cliente;
import com.nelioalves.coursomc.domain.Endereco;
import com.nelioalves.coursomc.domain.Estado;
import com.nelioalves.coursomc.domain.Produto;
import com.nelioalves.coursomc.domain.enums.TipoCliente;
import com.nelioalves.coursomc.repositories.CategoriaRepository;
import com.nelioalves.coursomc.repositories.CidadeRepository;
import com.nelioalves.coursomc.repositories.ClienteRepository;
import com.nelioalves.coursomc.repositories.EnderecoRepository;
import com.nelioalves.coursomc.repositories.EstadoRepository;
import com.nelioalves.coursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	EstadoRepository estadoRepository;
	@Autowired
	CidadeRepository cidadeRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");

		Cidade c1 = new Cidade(null,"Uberlândia",est1);
		Cidade c2 = new Cidade(null,"São Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli = new Cliente(null, "Maria Silva", "Maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		Endereco end1 = new Endereco(null, "Rua das flores", "300", "apto 203", "Jardim", "36220634", c1, cli);
		Endereco end2 = new Endereco(null, "Av.Marcos", "105", "Sala 308", "Centro", "38777012", c2, cli);
		
		clienteRepository.saveAll(Arrays.asList(cli));
		enderecoRepository.saveAll(Arrays.asList(end1,end2));
		
	 }

}
