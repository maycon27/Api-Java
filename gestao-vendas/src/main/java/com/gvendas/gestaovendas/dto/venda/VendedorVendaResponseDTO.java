package com.gvendas.gestaovendas.dto.venda;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("Vendedor da venda retorno DTO")
@Data
public class VendedorVendaResponseDTO {

	@ApiModelProperty(value = "Nome Vendedor")
	private String nome;
	
	@ApiModelProperty(value = "Venda")
	private List<VendaVendedorResponseDTO> vendaResponseDTO;

	public VendedorVendaResponseDTO(String nome, List<VendaVendedorResponseDTO> vendaResponseDTO) {
		this.nome = nome;
		this.vendaResponseDTO = vendaResponseDTO;
	}

}
