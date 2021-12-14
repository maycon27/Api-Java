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


@Entity
@Table(name = "item_venda")
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

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPrecoVendido() {
		return precoVendido;
	}

	public void setPrecoVendido(BigDecimal precoVendido) {
		this.precoVendido = precoVendido;
	}

	public BigDecimal getPagamentoVista() {
		return pagamentoVista;
	}

	public void setPagamentoVista(BigDecimal pagamentoVista) {
		this.pagamentoVista = pagamentoVista;
	}

	public BigDecimal getPagamentoPrazo() {
		return pagamentoPrazo;
	}

	public void setPagamentoPrazo(BigDecimal pagamentoPrazo) {
		this.pagamentoPrazo = pagamentoPrazo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, pagamentoPrazo, pagamentoVista, precoVendido, produto, quantidade, venda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ItemVenda)) {
			return false;
		}
		ItemVenda other = (ItemVenda) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(pagamentoPrazo, other.pagamentoPrazo)
				&& Objects.equals(pagamentoVista, other.pagamentoVista)
				&& Objects.equals(precoVendido, other.precoVendido) && Objects.equals(produto, other.produto)
				&& Objects.equals(quantidade, other.quantidade) && Objects.equals(venda, other.venda);
	}
	
	
}
