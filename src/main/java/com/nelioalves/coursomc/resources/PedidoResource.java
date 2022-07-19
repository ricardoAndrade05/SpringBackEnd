package com.nelioalves.coursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.coursomc.domain.Pedido;
import com.nelioalves.coursomc.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@RequestMapping(value ="/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id ) {
		Pedido pedido = service.buscar(id);
		ResponseEntity<Pedido> retorno = ResponseEntity.ok().body(pedido);
		return retorno;
	}

}
