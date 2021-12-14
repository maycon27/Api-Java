package com.gvendas.gestaovendas.dto.venda;

import java.time.LocalDate;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Venda retorno DTO")
public class VendaResponseDTO {
	
	@ApiModelProperty(value = "Codigo")
	private Long codigo;
	
	@ApiModelProperty(value = "Data")
	private LocalDate data;
	
	@ApiModelProperty(value = "Itens da venda")
	private List<ItemVendaResponseDTO> ItemVendaResponseDTO; 
	
	@ApiModelProperty(value = "Nome")
	private String nome;
	

	public VendaResponseDTO(Long codigo, LocalDate data,
			List<ItemVendaResponseDTO> itemVendaResponseDTO, String nome) {
		this.codigo = codigo;
		this.data = data;
		ItemVendaResponseDTO = itemVendaResponseDTO;
		this.nome = nome;
	}

	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	public List<ItemVendaResponseDTO> getItemVendaResponseDTO() {
		return ItemVendaResponseDTO;
	}


	public void setItemVendaResponseDTO(List<ItemVendaResponseDTO> itemVendaResponseDTO) {
		ItemVendaResponseDTO = itemVendaResponseDTO;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	

	
	

	
}
