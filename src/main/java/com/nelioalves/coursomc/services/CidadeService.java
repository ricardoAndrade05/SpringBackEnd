package com.nelioalves.coursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.coursomc.domain.Cidade;
import com.nelioalves.coursomc.repositories.CidadeRepository;
import com.nelioalves.coursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repo;
	
	public Cidade find(Integer id) {
		Optional<Cidade> cidade = repo.findById(id);
		return cidade.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
	}
	
	public List<Cidade> findByEstado(Integer estadoId){
		List<Cidade> cidades = repo.findCidades(estadoId);
		if (cidades.isEmpty()) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! , Tipo: " + Cidade.class.getName());
		}
		return cidades;
	}

}
