package com.nelioalves.coursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.coursomc.domain.Produto;
import com.nelioalves.coursomc.dto.ProdutoDTO;
import com.nelioalves.coursomc.resources.utils.URL;
import com.nelioalves.coursomc.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@RequestMapping(value ="/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id ) {
		Produto pedido = service.find(id);
		ResponseEntity<Produto> retorno = ResponseEntity.ok().body(pedido);
		System.out.println(retorno);
		return retorno;	
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDTO>> findPage(
			@RequestParam(value ="nome" ,defaultValue="0") String nome,
			@RequestParam(value ="categorias" ,defaultValue="0") String categorias,
			@RequestParam(value ="page" ,defaultValue="0") Integer page,
			@RequestParam(value ="linesPerPage" ,defaultValue="24") Integer linesPerPage,
			@RequestParam(value ="direction" ,defaultValue="ASC") String direction,
			@RequestParam(value ="orderBy" ,defaultValue="nome") String orderBy) {
		String nomeDecoded = URL.decodeParam(nome);
		List<Integer> ids = URL.stringTOIntegerList(categorias);
		Page<Produto> produtos = service.search(nomeDecoded,ids,page,linesPerPage,direction,orderBy);
		Page<ProdutoDTO> produtosDTO = produtos.map(produto -> new ProdutoDTO(produto));
		return ResponseEntity.ok().body(produtosDTO);
	}

}
