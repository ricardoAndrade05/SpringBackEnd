package com.nelioalves.coursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.coursomc.domain.Estado;
import com.nelioalves.coursomc.repositories.EstadoRepository;
import com.nelioalves.coursomc.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repo;
	
	public Estado find(Integer id) {
		Optional<Estado> estado = repo.findById(id);
		return estado.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));
	}
	
	public List<Estado> findAll(){
		List<Estado> estados = repo.findAllByOrderByNome();
		if (estados.isEmpty()) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado!" + ", Tipo: " + Estado.class.getName());
		}
		return estados;
	}

}
