package com.gvendas.gestaovendas.dto.venda;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Venda requisição DTO")
public class VendaRequestDTO {
	
	@ApiModelProperty(value = "Data")
	@NotNull(message = "Data")
	private LocalDate data;

	@NotNull(message = "Ativo")
	@ApiModelProperty(value = "Ativo")
	private Boolean ativo;

	@ApiModelProperty(value = "Itens")
	@NotNull(message = "Itens")
	@Valid
	private List<ItemVendaRequestDTO> ItensVendaDto;
	
	@ApiModelProperty(value = "Codigo Cliente")
	@NotNull(message = "Codigo Cliente")
	private Long codigoCliente;
	
	@ApiModelProperty(value = "Codigo Vendedor")
	@NotNull(message = "Codigo Vendedor")
	private Long codigoVendedor;

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
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
