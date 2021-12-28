package com.gvendas.gestaovendas.dto.produto;

import java.math.BigDecimal;

import com.gvendas.gestaovendas.dto.categoria.CategoriaResponseDTO;
import com.gvendas.gestaovendas.entidades.Categoria;
import com.gvendas.gestaovendas.entidades.Produto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@ApiModel(value = "Produto retorno DTO")
@Setter
@Getter
=======

@ApiModel(value = "Produto retorno DTO")
@Data
>>>>>>> 2cbab3cd0f1a9e7cab87eecc48895741cf37d9c9
public class ProdutoResponseDTO {

	@ApiModelProperty(value = "Código")
	private Long codigo;

	@ApiModelProperty(value = "Descrição")
	private String descricao;

	@ApiModelProperty(value = "Quantidade")
	private Integer quantidade;

	@ApiModelProperty(value = "Preço Custo")
	private BigDecimal precoCusto;

	@ApiModelProperty(value = "Preço Venda")
	private BigDecimal precoVenda;
	
	@ApiModelProperty(value = "Observação")
	private String observacao;

	@ApiModelProperty(value = "Categoria")
	private CategoriaResponseDTO categoria;

	
	
/*	public ProdutoResponseDTO(Long codigo, String descricao, Integer quantidade, BigDecimal precoCusto,
			BigDecimal precoVenda, String observacao, CategoriaResponseDTO categoria) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.observacao = observacao;
		this.categoria = categoria;
	}
	
	/*public static ProdutoResponseDTO converterParaProdutoDTO(Produto produto) {
		return new ProdutoResponseDTO(produto.getCodigo(), produto.getDescricao(), produto.getQuantidade(), 
				produto.getPrecoCusto(), produto.getPrecoVenda(), produto.getObservacao(),
				CategoriaResponseDTO.converterParaCategoriaDTO(produto.getCategoria()));
	}
<<<<<<< HEAD
*/
public static ProdutoResponseDTO converterParaProdutoDTO(Produto produto) {
	ModelMapper modelMapper = new ModelMapper();
	return modelMapper.map(produto, ProdutoResponseDTO.class);
}
=======


>>>>>>> 2cbab3cd0f1a9e7cab87eecc48895741cf37d9c9
}
