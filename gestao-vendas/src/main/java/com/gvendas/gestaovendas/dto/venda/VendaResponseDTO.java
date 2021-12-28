package com.gvendas.gestaovendas.dto.venda;

import java.time.LocalDate;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("Venda retorno DTO")
@Data
public class VendaResponseDTO {
	
	@ApiModelProperty(value = "Codigo")
	private Long codigo;
	
	@ApiModelProperty(value = "Data")
	private LocalDate data;

	@ApiModelProperty(value = "Data")
	private Boolean ativo;

	@ApiModelProperty(value = "Itens da venda")
	private List<ItemVendaResponseDTO> ItemVendaResponseDTO; 
	
	@ApiModelProperty(value = "Nome do Vendedor")
	private String nomeVendedor;

	@ApiModelProperty(value = "Nome do Cliente")
	private String nomeCliente;




	public VendaResponseDTO(Long codigo, LocalDate data, Boolean ativo,
			List<ItemVendaResponseDTO> itemVendaResponseDTO, String nomeVendedor,String nomeCliente) {
		this.codigo = codigo;
		this.data = data;
		this.ativo = ativo;
		ItemVendaResponseDTO = itemVendaResponseDTO;
		this.nomeVendedor = nomeVendedor;
		this.nomeCliente = nomeCliente;
	}
	

}
