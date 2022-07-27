package com.nelioalves.coursomc.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nelioalves.coursomc.domain.Pedido;
import com.nelioalves.coursomc.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@RequestMapping(value ="/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id ) {
		Pedido pedido = service.find(id);
		ResponseEntity<Pedido> retorno = ResponseEntity.ok().body(pedido);
		return retorno;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Pedido pedido){
		pedido = service.insert(pedido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(pedido.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<Pedido>> findPage(
			@RequestParam(value ="page" ,defaultValue="0") Integer page,
			@RequestParam(value ="linesPerPage" ,defaultValue="24") Integer linesPerPage,
			@RequestParam(value ="direction" ,defaultValue="DESC") String direction,
			@RequestParam(value ="orderBy" ,defaultValue="instante") String orderBy) {
		Page<Pedido> pedidos = service.buscaPaginada(page,linesPerPage,direction,orderBy);
		return ResponseEntity.ok().body(pedidos);
	}

}
