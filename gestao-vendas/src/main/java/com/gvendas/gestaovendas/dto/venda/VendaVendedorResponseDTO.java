package com.gvendas.gestaovendas.dto.venda;

import java.time.LocalDate;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("Venda Vendedor retorno DTO")
@Data
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
	


}
