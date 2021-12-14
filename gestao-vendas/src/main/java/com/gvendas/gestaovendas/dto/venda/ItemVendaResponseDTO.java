package com.gvendas.gestaovendas.dto.venda;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Itens da venda retorno DTO")
public class ItemVendaResponseDTO {

	@ApiModelProperty(value = "Codigo")
	private Long codigo;
	
	@ApiModelProperty(value = "Quantidade")
	private Integer quantidade;
	
	@ApiModelProperty(value = "Preco Vendido")
	private BigDecimal precoVendido;
	
	@ApiModelProperty(value = "Pagamento a Vista")
	private BigDecimal pagamentoVista;
	
	@ApiModelProperty(value = "Pagamento a Prazo")
	private BigDecimal pagamentoPrazo;
	
	@ApiModelProperty(value = "Codigo Produto")
	private Long codigoProduto;
	
	@ApiModelProperty(value = "Produto Descricao")
	private String produtoDescricao;

	public ItemVendaResponseDTO(Long codigo, Integer quantidade, BigDecimal precoVendido, BigDecimal pagamentoVista,
			BigDecimal pagamentoPrazo, Long codigoProduto, String produtoDescricao) {
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.precoVendido = precoVendido;
		this.pagamentoVista = pagamentoVista;
		this.pagamentoPrazo = pagamentoPrazo;
		this.codigoProduto = codigoProduto;
		this.produtoDescricao = produtoDescricao;
	}

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

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getProdutoDescricao() {
		return produtoDescricao;
	}

	public void setProdutoDescricao(String produtoDescricao) {
		this.produtoDescricao = produtoDescricao;
	}
	
	
	
}
