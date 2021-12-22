package com.gvendas.gestaovendas.entidades;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vendedor")
public class Vendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "codigo")
	private Long codigo;

	@Column(name = "nome")
	private String nome;

	public Vendedor() {
		
	}
	
	public Vendedor(String nome) {
		this.nome = nome;
	}

	public Vendedor(Long codigo) {
		this.codigo = codigo;
	}
	
	public Vendedor(Long codigo,String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Vendedor)) {
			return false;
		}
		Vendedor other = (Vendedor) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(nome, other.nome);
	}
	
	
}
