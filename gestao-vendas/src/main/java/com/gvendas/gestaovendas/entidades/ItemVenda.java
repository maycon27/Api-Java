package com.gvendas.gestaovendas.entidades;

import lombok.Data;

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


@Entity
@Table(name = "item_venda")
@Data
public class ItemVenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "codigo")
	private Long codigo;
	
	@Column (name = "quantidade")
	private Integer quantidade;
	
	@Column (name = "preco_vendido")
	private BigDecimal precoVendido;

	@Column (name = "pagamento_a_vista")
	private BigDecimal pagamentoVista;
	
	@Column (name = "pagamento_a_prazo")
	private BigDecimal pagamentoPrazo;
	
	@ManyToOne
	@JoinColumn(name = "codigo_produto", referencedColumnName = "codigo")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "codigo_venda", referencedColumnName = "codigo")
	private Venda venda;
	
	
	public ItemVenda() {

	}

	
	public ItemVenda(Long codigo, Integer quantidade, BigDecimal precoVendido, BigDecimal pagamentoVista,
			BigDecimal pagamentoPrazo, Produto produto, Venda venda) {
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.precoVendido = precoVendido;
		this.pagamentoVista = pagamentoVista;
		this.pagamentoPrazo = pagamentoPrazo;
		this.produto = produto;
		this.venda = venda;
	}


	public ItemVenda(Integer quantidade, BigDecimal precoVendido, BigDecimal pagamentoVista, BigDecimal pagamentoPrazo,
			Produto produto, Venda venda) {
		this.quantidade = quantidade;
		this.precoVendido = precoVendido;
		this.pagamentoVista = pagamentoVista;
		this.pagamentoPrazo = pagamentoPrazo;
		this.produto = produto;
		this.venda = venda;
	}

}
