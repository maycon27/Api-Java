package com.gvendas.gestaovendas.dto.venda;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Vendedor da venda retorno DTO")
public class VendedorVendaResponseDTO {

	@ApiModelProperty(value = "Nome Vendedor")
	private String nome;
	
	@ApiModelProperty(value = "Venda")
	private List<VendaResponseDTO> vendaResponseDTO;

	public VendedorVendaResponseDTO(String nome, List<VendaResponseDTO> vendaResponseDTO) {
		this.nome = nome;
		this.vendaResponseDTO = vendaResponseDTO;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<VendaResponseDTO> getVendaResponseDTO() {
		return vendaResponseDTO;
	}

	public void setVendaResponseDTO(List<VendaResponseDTO> vendaResponseDTO) {
		this.vendaResponseDTO = vendaResponseDTO;
	}
	
}
