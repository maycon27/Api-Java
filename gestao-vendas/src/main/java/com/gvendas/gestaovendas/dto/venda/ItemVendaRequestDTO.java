package com.gvendas.gestaovendas.dto.venda;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("Itens da venda requisição DTO")
@Data
public class ItemVendaRequestDTO {

	@ApiModelProperty(value = "Codigo Produto")
	@NotNull(message = "Codigo Produto")
	private Long codigoProduto;
	
	@ApiModelProperty(value = "Quantidade")
	@NotNull(message = "Quantidade")
	@Min(value = 1, message = "Quantidade")
	private Integer quantidade;
	
	@ApiModelProperty(value = "Preco Vendido")
	@NotNull(message = "Preco vendido")
	private BigDecimal precoVendido;
	
	@ApiModelProperty(value = "Pagamento a Vista")
	@NotNull(message = "Pagamento a vista")
	private BigDecimal pagamentoVista;
	
	@ApiModelProperty(value = "Pagamento a Prazo")
	@NotNull(message = "Pagamento a prazo")
	private BigDecimal pagamentoPrazo;

}
