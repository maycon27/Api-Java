package com.gvendas.gestaovendas.dto.venda;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Itens da venda requisição DTO")
public class ItemVendaRequestDTO {

	@ApiModelProperty(value = "Codigo Produto")
	private Long codigoProduto;
	
	@ApiModelProperty(value = "Quantidade")
	private Integer quantidade;
	
	@ApiModelProperty(value = "Preco Vendido")
	private BigDecimal precoVendido;
	
	@ApiModelProperty(value = "Pagamento a Vista")
	private BigDecimal pagamentoVista;
	
	@ApiModelProperty(value = "Pagamento a Prazo")
	private BigDecimal pagamentoPrazo;

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
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
	
	
}
