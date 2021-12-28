package com.gvendas.gestaovendas.dto.venda;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("Cliente da venda retorno DTO")
@Data
public class ClienteVendaResponseDTO {
	
	@ApiModelProperty(value = "Nome Cliente")
	private String nome;
	
	@ApiModelProperty(value = "Venda")
	private List<VendaResponseDTO> vendaResponseDTO;

	public ClienteVendaResponseDTO(String nome, List<VendaResponseDTO> vendaResponseDTO) {
		this.nome = nome;
		this.vendaResponseDTO = vendaResponseDTO;
	}


}
