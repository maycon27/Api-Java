package com.gvendas.gestaovendas.entidades;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "categoria")
@Data
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "codigo")
	private Long codigo;

	@Column(name = "nome")
	private String nome;

	public Categoria() {
	
	}
	public Categoria(String nome) {
		this.nome = nome;
	}
	
	public Categoria(Long codigo) {
		this.codigo = codigo;
	}
	public Categoria(Long codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
<<<<<<< HEAD
=======
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
>>>>>>> 2cbab3cd0f1a9e7cab87eecc48895741cf37d9c9

}
