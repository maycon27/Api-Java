package com.gvendas.gestaovendas.entidades;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "produto")
@Data
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "quantidade")
	private Integer quantidade;

	
	@Column(name = "preco_custo")
	private BigDecimal precoCusto;

	
	@Column(name = "preco_venda")
	private BigDecimal precoVenda;

	
	@Column(name = "observacao")
	private String observacao;

	
	@ManyToOne
	@JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo")
	private Categoria categoria;

	public Produto() {
		
	}
	
	public Produto(Long codigo) {
		this.codigo = codigo;
	}
	
	public Produto(Long codigo, String descricao, Integer quantidade, BigDecimal precoCusto, BigDecimal precoVenda,
			String observacao, Categoria categoria) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.observacao = observacao;
		this.categoria = categoria;
	}
	
	public Produto(String descricao, Integer quantidade, BigDecimal precoCusto, BigDecimal precoVenda,
			String observacao, Categoria categoria) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.observacao = observacao;
		this.categoria = categoria;
	}

}
