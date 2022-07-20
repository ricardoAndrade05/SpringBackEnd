package com.nelioalves.coursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.coursomc.domain.Categoria;
import com.nelioalves.coursomc.domain.Cidade;
import com.nelioalves.coursomc.domain.Cliente;
import com.nelioalves.coursomc.domain.Endereco;
import com.nelioalves.coursomc.domain.Estado;
import com.nelioalves.coursomc.domain.ItemPedido;
import com.nelioalves.coursomc.domain.Pagamento;
import com.nelioalves.coursomc.domain.PagamentoComBoleto;
import com.nelioalves.coursomc.domain.PagamentoComCartao;
import com.nelioalves.coursomc.domain.Pedido;
import com.nelioalves.coursomc.domain.Produto;
import com.nelioalves.coursomc.domain.enums.EstadoPagamento;
import com.nelioalves.coursomc.domain.enums.TipoCliente;
import com.nelioalves.coursomc.repositories.CategoriaRepository;
import com.nelioalves.coursomc.repositories.CidadeRepository;
import com.nelioalves.coursomc.repositories.ClienteRepository;
import com.nelioalves.coursomc.repositories.EnderecoRepository;
import com.nelioalves.coursomc.repositories.EstadoRepository;
import com.nelioalves.coursomc.repositories.ItemPedidoRepository;
import com.nelioalves.coursomc.repositories.PagamentoRepository;
import com.nelioalves.coursomc.repositories.PedidoRepository;
import com.nelioalves.coursomc.repositories.ProdutoRepository;

@Service
public class DBService {

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
	@Autowired
	PagamentoRepository pagamentoRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ItemPedidoRepository itemPedidoRepository;

	public void instantiateDatabase() throws ParseException {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletronicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		
		Produto p01 = new Produto(null, "Computador", 2000.00);
		Produto p02 = new Produto(null, "Impressora", 800.00);
		Produto p03 = new Produto(null, "Mouse", 80.00);
		Produto p04 = new Produto(null, "Mesa de escritório", 300.00);
		Produto p05 = new Produto(null, "Toalha", 50.00);
		Produto p06 = new Produto(null, "Colcha", 200.00);
		Produto p07 = new Produto(null, "Tv true color", 1200.00);
		Produto p08 = new Produto(null, "Roçadeira", 800.00);
		Produto p09 = new Produto(null, "Abajour", 100.00);
		Produto p10 = new Produto(null, "Pendente", 180.00);
		Produto p11 = new Produto(null, "Shampoo", 90.00);

		cat1.getProdutos().addAll(Arrays.asList(p01, p02, p03));
		cat2.getProdutos().addAll(Arrays.asList(p02, p04));
		cat3.getProdutos().addAll(Arrays.asList(p05, p06));
		cat4.getProdutos().addAll(Arrays.asList(p01, p02, p03, p07));
		cat5.getProdutos().addAll(Arrays.asList(p08));
		cat6.getProdutos().addAll(Arrays.asList(p10, p09));
		cat7.getProdutos().addAll(Arrays.asList(p11));

		p01.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p02.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p03.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p04.getCategorias().addAll(Arrays.asList(cat2));
		p05.getCategorias().addAll(Arrays.asList(cat3));
		p06.getCategorias().addAll(Arrays.asList(cat3));
		p07.getCategorias().addAll(Arrays.asList(cat4));
		p08.getCategorias().addAll(Arrays.asList(cat5));
		p09.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		Cliente cli = new Cliente(null, "Maria Silva", "Maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

		Endereco end1 = new Endereco(null, "Rua das flores", "300", "apto 203", "Jardim", "36220634", c1, cli);
		Endereco end2 = new Endereco(null, "Av.Marcos", "105", "Sala 308", "Centro", "38777012", c2, cli);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli, end1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli, end2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
				null);
		ped2.setPagamento(pagto2);
		cli.getPedidos().addAll(Arrays.asList(ped1, ped2));

		ItemPedido ip1 = new ItemPedido(ped1, p01, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p03, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p02, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p01.getItens().addAll(Arrays.asList(ip1));
		p02.getItens().addAll(Arrays.asList(ip3));
		p03.getItens().addAll(Arrays.asList(ip2));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p01, p02, p03, p04, p05, p06, p07, p08, p09, p10, p11));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		clienteRepository.saveAll(Arrays.asList(cli));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}

}
