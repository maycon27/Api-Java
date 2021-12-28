package com.gvendas.gestaovendas.dto.cliente;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("Endereço retorno DTO")
@Data
public class EnderecoResponseDTO {

	@ApiModelProperty(value = "Logradouro")
	private String logradouro;

	@ApiModelProperty(value = "Número")
	private Integer numero;

	@ApiModelProperty(value = "Complemento")
	private String complemento;

	@ApiModelProperty(value = "Bairro")
	private String bairro;

	@ApiModelProperty(value = "CEP")
	private String cep;

	@ApiModelProperty(value = "Cidade")
	private String cidade;

	@ApiModelProperty(value = "Estado")
	private String estado;

    public EnderecoResponseDTO(String logradouro, Integer numero, String complemento, String bairro, String cep, String cidade, String estado) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
    }
}
