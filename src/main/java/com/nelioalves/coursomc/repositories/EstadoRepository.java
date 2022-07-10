package com.nelioalves.coursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.coursomc.domain.Estado;

@Repository
public interface EstadoRepository  extends JpaRepository<Estado, Integer> {

}
