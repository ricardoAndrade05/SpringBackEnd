package com.nelioalves.coursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nelioalves.coursomc.domain.Categoria;
import com.nelioalves.coursomc.repositories.CategoriaRepository;
import com.nelioalves.coursomc.services.exceptions.DataIntegrityException;
import com.nelioalves.coursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		Optional<Categoria> categoria = repo.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria inserir(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria atualizar(Categoria obj) {
		buscar(obj.getId());
		return repo.save(obj);
	}

	public void excluir(Integer id) {
		buscar(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel exlcuir uma categoria que possui produtos");
		}
				
	}
	
	public List<Categoria> buscaTodas(){
		return repo.findAll();
	}
	
	
	public Page<Categoria> buscaPaginada(Integer pagina, Integer linhasPorPagina,String direction,String orderBy){
		PageRequest pageRequest = PageRequest.of(pagina,linhasPorPagina,Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);
	}	
}
