package com.gvendas.gestaovendas.dto.produto;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import com.gvendas.gestaovendas.entidades.Categoria;
import com.gvendas.gestaovendas.entidades.Produto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Produto requisição DTO")
@Data
public class ProdutoRequestDTO {
	
	@ApiModelProperty(value = "Descrição")
	@NotBlank(message = "Descrição")
	@Length(min = 3 , max = 100, message = "Descrição")
	private String descricao;

	@NotNull(message = "Quantidade")
	@ApiModelProperty(value = "Quantidade")
	private Integer quantidade;

	@NotNull(message = "Preço custo")
	@ApiModelProperty(value = "Preço Custo")
	private BigDecimal precoCusto;

	@NotNull(message = "Preço venda")
	@ApiModelProperty(value = "Preço Venda")
	private BigDecimal precoVenda;
	
	@Length(max = 500, message = "Observação")
	@ApiModelProperty(value = "Observação")
	private String observacao;
	
	@NotNull(message = "Categoria")
	@ApiModelProperty(value = "Categoria")
	private Long codigoCategoria;

	public Produto converterParaEntidade() {
		return new Produto(descricao, quantidade, precoCusto, precoVenda, observacao, new Categoria(codigoCategoria));
	}

	public Produto converterParaEntidade(Long codigoProduto) {
		return new Produto(codigoProduto,descricao, quantidade, precoCusto, precoVenda, observacao, new Categoria(codigoCategoria));
	}
	
}