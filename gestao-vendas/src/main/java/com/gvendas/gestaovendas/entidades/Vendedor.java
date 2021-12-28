package com.gvendas.gestaovendas.entidades;

import lombok.Data;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vendedor")
@Data
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
<<<<<<< HEAD

=======
	
>>>>>>> 2cbab3cd0f1a9e7cab87eecc48895741cf37d9c9
}
