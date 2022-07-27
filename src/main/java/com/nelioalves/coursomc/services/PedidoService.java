package com.nelioalves.coursomc.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nelioalves.coursomc.domain.Cliente;
import com.nelioalves.coursomc.domain.ItemPedido;
import com.nelioalves.coursomc.domain.PagamentoComBoleto;
import com.nelioalves.coursomc.domain.Pedido;
import com.nelioalves.coursomc.domain.Produto;
import com.nelioalves.coursomc.domain.enums.EstadoPagamento;
import com.nelioalves.coursomc.repositories.ItemPedidoRepository;
import com.nelioalves.coursomc.repositories.PagamentoRepository;
import com.nelioalves.coursomc.repositories.PedidoRepository;
import com.nelioalves.coursomc.security.UserSS;
import com.nelioalves.coursomc.services.exceptions.AuthorizationException;
import com.nelioalves.coursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired EmailService emailService;

	
	public Pedido find(Integer id) {
		Optional<Pedido> pedido = repo.findById(id);
		return pedido.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	
	@Transactional
	public Pedido insert(Pedido pedido) {
		pedido.setId(null);
		pedido.setInstante(new Date());
		pedido.setCliente(clienteService.find(pedido.getCliente().getId()));
		pedido.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		pedido.getPagamento().setPedido(pedido);
		if(pedido.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) pedido.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto,pedido.getInstante());
		}
		pedido = repo.save(pedido);
		pagamentoRepository.save(pedido.getPagamento());
		for(ItemPedido ip : pedido.getItens()) {
			ip.setDesconto(0.0);
			Produto produto = produtoService.find(ip.getProduto().getId());
			ip.setProduto(produto);
			ip.setPreco(produto.getPreco());
			ip.setPedido(pedido);
		}
		itemPedidoRepository.saveAll(pedido.getItens());
		emailService.sendOrderConfirmationHtmlEmail(pedido);
		return pedido;
	}

	public Page<Pedido> buscaPaginada(Integer pagina, Integer linhasPorPagina, String direction, String orderBy) {
		UserSS user = UserService.authenticated();
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direction), orderBy);
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		Cliente cliente = clienteService.find(user.getId());
		return repo.findByCliente(cliente, pageRequest);
	}

}
