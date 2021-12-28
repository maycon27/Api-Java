package com.gvendas.gestaovendas.entidades;

import lombok.Data;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class Endereco {

	@Column(name = "logradouro")
	private String logradouro;

	@Column(name = "numero")
	private Integer numero;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "cep")
	private String cep;

	@Column(name = "cidade")
	private String cidade;

	@Column(name = "estado")
	private String estado;

	public Endereco() {
	}

	public Endereco(String logradouro, Integer numero, String complemento, String bairro, String cep, String cidade,
			String estado) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}

}
