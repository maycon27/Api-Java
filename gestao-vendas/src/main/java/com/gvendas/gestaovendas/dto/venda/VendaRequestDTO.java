package com.gvendas.gestaovendas.dto.venda;

import java.time.LocalDate;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Venda requisição DTO")
public class VendaRequestDTO {
	
	@ApiModelProperty(value = "Data")
	private LocalDate data;
	
	@ApiModelProperty(value = "Itens")
	private List<ItemVendaRequestDTO> ItensVendaDto;
	
	@ApiModelProperty(value = "Codigo Cliente")
	private Long codigoCliente;
	
	@ApiModelProperty(value = "Codigo Vendedor")
	private Long codigoVendedor;

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<ItemVendaRequestDTO> getItensVendaDto() {
		return ItensVendaDto;
	}

	public void setItensVendaDto(List<ItemVendaRequestDTO> itensVendaDto) {
		ItensVendaDto = itensVendaDto;
	}

	public Long getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Long getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(Long codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
	
	

}
