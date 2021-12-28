package com.gvendas.gestaovendas.dto.cliente;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Endereço requisição DTO")
@Data
public class EnderecoRequestDTO {
	
	@NotBlank(message = "Logradouro")
	@Length(min = 3, max = 30, message = "Logradouro")
	@ApiModelProperty(value = "Logradouro")
	private String logradouro;

	
	@ApiModelProperty(value = "Número")
	@NotNull(message = "Número")
	private Integer numero;

	@ApiModelProperty(value = "Complemento")
	@Length(max = 30, message = "complemento")
	private String complemento;

	@NotBlank(message = "Bairro")
	@Length(min = 3, max = 30, message = "Bairro")
	@ApiModelProperty(value = "Bairro")
	private String bairro;

	@NotBlank(message = "CEP")
	@Pattern(regexp = "[\\d]{5}-[\\d]{3}", message = "CEP")
	@ApiModelProperty(value = "CEP")
	private String cep;

	@NotBlank(message = "Cidade")
	@Length(min = 3, max = 30, message = "Cidade")
	@ApiModelProperty(value = "Cidade")
	private String cidade;

	@NotBlank(message = "Estado")
	@Length(min = 3, max = 30, message = "Estado")
	@ApiModelProperty(value = "Estado")
	private String estado;


}
