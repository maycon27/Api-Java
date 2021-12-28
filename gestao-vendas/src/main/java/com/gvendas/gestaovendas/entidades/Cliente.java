package com.gvendas.gestaovendas.entidades;

import lombok.Data;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "codigo")
	private Long codigo;

	@Column(name = "nome")
	private String nome;

	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "ativo")
	private Boolean ativo;
	
	@Embedded
	private Endereco endereco;
	
	public Cliente() {
	}

	public Cliente(String nome, String telefone, Boolean ativo, Endereco endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.ativo = ativo;
		this.endereco = endereco;
	}
	
	public Cliente(Long codigo, String nome, String telefone, Boolean ativo, Endereco endereco) {
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.ativo = ativo;
		this.endereco = endereco;
	}

	public Cliente(Long codigo) {
		this.codigo = codigo;

	}

}
