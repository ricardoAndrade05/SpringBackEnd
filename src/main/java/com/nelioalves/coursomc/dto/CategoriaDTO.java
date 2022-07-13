package com.nelioalves.coursomc.dto;

import java.io.Serializable;

import com.nelioalves.coursomc.domain.Categoria;

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String Nome;

	public CategoriaDTO() {

	}
	
	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.Nome = categoria.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

}
