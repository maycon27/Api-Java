package com.gvendas.gestaovendas.dto.venda;

import java.time.LocalDate;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Venda Vendedor retorno DTO")
public class VendaVendedorResponseDTO {
	
	@ApiModelProperty(value = "Codigo")
	private Long codigo;
	
	@ApiModelProperty(value = "Data")
	private LocalDate data;
	
	@ApiModelProperty(value = "Itens da venda")
	private List<ItemVendaResponseDTO> ItemVendaResponseDTO; 
	
	
	@ApiModelProperty(value = "Nome do Cliente")
	private String nomeCliente;

	
	public VendaVendedorResponseDTO(Long codigo, LocalDate data, String nomeCliente,
			List<ItemVendaResponseDTO> itemVendaResponseDTO) {
		this.codigo = codigo;
		this.data = data;
		ItemVendaResponseDTO = itemVendaResponseDTO;
		this.nomeCliente = nomeCliente;
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


	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	


}
