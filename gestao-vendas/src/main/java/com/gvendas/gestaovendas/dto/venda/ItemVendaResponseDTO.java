package com.gvendas.gestaovendas.dto.venda;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("Itens da venda retorno DTO")
@Data
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
	
}
