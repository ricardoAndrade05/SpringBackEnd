package com.nelioalves.coursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.coursomc.domain.Cidade;
import com.nelioalves.coursomc.domain.Estado;
import com.nelioalves.coursomc.dto.CidadeDTO;
import com.nelioalves.coursomc.dto.EstadoDTO;
import com.nelioalves.coursomc.services.CidadeService;
import com.nelioalves.coursomc.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

	@Autowired
	private EstadoService service;
	
	@Autowired
	private CidadeService cidadeService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Estado> find(@PathVariable Integer id) {
		Estado estado = service.find(id);
		ResponseEntity<Estado> retorno = ResponseEntity.ok().body(estado);
		System.out.println(retorno);
		return retorno;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EstadoDTO>> findAll() {
		List<Estado> estados = service.findAll();
		List<EstadoDTO> estadosDTO = estados.stream().map(estado -> new EstadoDTO(estado)).collect(Collectors.toList());
		return ResponseEntity.ok().body(estadosDTO);
	}
	
	@RequestMapping(value = "/{estadoId}/cidades", method = RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer estadoId){
		List<Cidade> cidades = cidadeService.findByEstado(estadoId);
		List<CidadeDTO> cidadesDTO = cidades.stream().map(cidade -> new CidadeDTO(cidade)).collect(Collectors.toList());
		return ResponseEntity.ok().body(cidadesDTO);
	}
	

}
