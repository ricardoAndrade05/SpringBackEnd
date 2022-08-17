package com.nelioalves.coursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.nelioalves.coursomc.domain.enums.Perfil;
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
	private BCryptPasswordEncoder bCryptPasswordEncoder;
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

		Produto p12 = new Produto(null, "Produto 12", 10.00);
		Produto p13 = new Produto(null, "Produto 13", 10.00);
		Produto p14 = new Produto(null, "Produto 14", 10.00);
		Produto p15 = new Produto(null, "Produto 15", 10.00);
		Produto p16 = new Produto(null, "Produto 16", 10.00);
		Produto p17 = new Produto(null, "Produto 17", 10.00);
		Produto p18 = new Produto(null, "Produto 18", 10.00);
		Produto p19 = new Produto(null, "Produto 19", 10.00);
		Produto p20 = new Produto(null, "Produto 20", 10.00);
		Produto p21 = new Produto(null, "Produto 21", 10.00);
		Produto p22 = new Produto(null, "Produto 22", 10.00);
		Produto p23 = new Produto(null, "Produto 23", 10.00);
		Produto p24 = new Produto(null, "Produto 24", 10.00);
		Produto p25 = new Produto(null, "Produto 25", 10.00);
		Produto p26 = new Produto(null, "Produto 26", 10.00);
		Produto p27 = new Produto(null, "Produto 27", 10.00);
		Produto p28 = new Produto(null, "Produto 28", 10.00);
		Produto p29 = new Produto(null, "Produto 29", 10.00);
		Produto p30 = new Produto(null, "Produto 30", 10.00);
		Produto p31 = new Produto(null, "Produto 31", 10.00);
		Produto p32 = new Produto(null, "Produto 32", 10.00);
		Produto p33 = new Produto(null, "Produto 33", 10.00);
		Produto p34 = new Produto(null, "Produto 34", 10.00);
		Produto p35 = new Produto(null, "Produto 35", 10.00);
		Produto p36 = new Produto(null, "Produto 36", 10.00);
		Produto p37 = new Produto(null, "Produto 37", 10.00);
		Produto p38 = new Produto(null, "Produto 38", 10.00);
		Produto p39 = new Produto(null, "Produto 39", 10.00);
		Produto p40 = new Produto(null, "Produto 40", 10.00);
		Produto p41 = new Produto(null, "Produto 41", 10.00);
		Produto p42 = new Produto(null, "Produto 42", 10.00);
		Produto p43 = new Produto(null, "Produto 43", 10.00);
		Produto p44 = new Produto(null, "Produto 44", 10.00);
		Produto p45 = new Produto(null, "Produto 45", 10.00);
		Produto p46 = new Produto(null, "Produto 46", 10.00);
		Produto p47 = new Produto(null, "Produto 47", 10.00);
		Produto p48 = new Produto(null, "Produto 48", 10.00);
		Produto p49 = new Produto(null, "Produto 49", 10.00);
		Produto p50 = new Produto(null, "Produto 50", 10.00);

		cat1.getProdutos()
				.addAll(Arrays.asList(p01, p02, p03, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24,
						p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38, p39, p40, p41, p42, p43, p44,
						p45, p46, p47, p48, p49, p50));
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

		p12.getCategorias().add(cat1);
		p13.getCategorias().add(cat1);
		p14.getCategorias().add(cat1);
		p15.getCategorias().add(cat1);
		p16.getCategorias().add(cat1);
		p17.getCategorias().add(cat1);
		p18.getCategorias().add(cat1);
		p19.getCategorias().add(cat1);
		p20.getCategorias().add(cat1);
		p21.getCategorias().add(cat1);
		p22.getCategorias().add(cat1);
		p23.getCategorias().add(cat1);
		p24.getCategorias().add(cat1);
		p25.getCategorias().add(cat1);
		p26.getCategorias().add(cat1);
		p27.getCategorias().add(cat1);
		p28.getCategorias().add(cat1);
		p29.getCategorias().add(cat1);
		p30.getCategorias().add(cat1);
		p31.getCategorias().add(cat1);
		p32.getCategorias().add(cat1);
		p33.getCategorias().add(cat1);
		p34.getCategorias().add(cat1);
		p35.getCategorias().add(cat1);
		p36.getCategorias().add(cat1);
		p37.getCategorias().add(cat1);
		p38.getCategorias().add(cat1);
		p39.getCategorias().add(cat1);
		p40.getCategorias().add(cat1);
		p41.getCategorias().add(cat1);
		p42.getCategorias().add(cat1);
		p43.getCategorias().add(cat1);
		p44.getCategorias().add(cat1);
		p45.getCategorias().add(cat1);
		p46.getCategorias().add(cat1);
		p47.getCategorias().add(cat1);
		p48.getCategorias().add(cat1);
		p49.getCategorias().add(cat1);
		p50.getCategorias().add(cat1);

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		Cliente cli = new Cliente(null, "Maria Silva", "ricardo_teles_andrade@hotmail.com", "36378912377",
				TipoCliente.PESSOAFISICA, bCryptPasswordEncoder.encode("123"));
		cli.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

		Cliente cli2 = new Cliente(null, "Ricardo Teles", "ricardoSpringTeste@gmail.com", "05736810905",
				TipoCliente.PESSOAFISICA, bCryptPasswordEncoder.encode("123"));
		cli2.addPerfil(Perfil.ADMIN);

		Endereco end1 = new Endereco(null, "Rua das flores", "300", "apto 203", "Jardim", "36220634", c1, cli);
		Endereco end2 = new Endereco(null, "Av.Marcos", "105", "Sala 308", "Centro", "38777012", c2, cli);
		Endereco end3 = new Endereco(null, "Av.Brasil", "1025", "Sala 88", "Centro", "87020035", c2, cli2);

		cli.getEnderecos().addAll(Arrays.asList(end1, end2));
		cli2.getEnderecos().addAll(Arrays.asList(end3));

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
		produtoRepository.saveAll(Arrays.asList(p01, p02, p03, p04, p05, p06, p07, p08, p09, p10, p11, p12, p13, p14,
				p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36,
				p37, p38, p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		clienteRepository.saveAll(Arrays.asList(cli, cli2));
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}

}
