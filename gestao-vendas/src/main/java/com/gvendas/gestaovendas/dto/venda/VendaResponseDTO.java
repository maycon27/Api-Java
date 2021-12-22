package com.gvendas.gestaovendas.dto.venda;

import java.time.LocalDate;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Venda Cliente retorno DTO")
public class VendaResponseDTO {
	
	@ApiModelProperty(value = "Codigo")
	private Long codigo;
	
	@ApiModelProperty(value = "Data")
	private LocalDate data;
	
	@ApiModelProperty(value = "Itens da venda")
	private List<ItemVendaResponseDTO> ItemVendaResponseDTO; 
	
	@ApiModelProperty(value = "Nome do Vendedor")
	private String nomeVendedor;
	


	public VendaResponseDTO(Long codigo, LocalDate data,
			List<ItemVendaResponseDTO> itemVendaResponseDTO, String nomeVendedor) {
		this.codigo = codigo;
		this.data = data;
		ItemVendaResponseDTO = itemVendaResponseDTO;
		this.nomeVendedor = nomeVendedor;
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


	public String getNomeVendedor() {
		return nomeVendedor;
	}


	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}	
	

	
}
