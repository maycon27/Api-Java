package com.gvendas.gestaovendas.dto.venda;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("Venda requisição DTO")
@Data
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

}
