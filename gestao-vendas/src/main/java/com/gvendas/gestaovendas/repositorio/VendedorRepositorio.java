package com.gvendas.gestaovendas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gvendas.gestaovendas.entidades.Vendedor;


public interface VendedorRepositorio extends JpaRepository<Vendedor, Long> {

	 Vendedor findByNome(String descricao);
}
