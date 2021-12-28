package com.gvendas.gestaovendas.dto.cliente;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import com.gvendas.gestaovendas.entidades.Cliente;
import com.gvendas.gestaovendas.entidades.Endereco;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Cliente requisição DTO")
@Data
public class ClienteRequestDTO {

	@NotBlank(message = "Nome")
	@ApiModelProperty(value = "Nome")
	@Length(min = 3, max = 50, message = "Nome")
	private String nome;

	@NotBlank(message = "Telefone")
	@ApiModelProperty(value = "Telefone")
	@Pattern(regexp = "\\([\\d]{2}\\)[\\d]{5}[- .][\\d]{4}", message = "Telefone")
	private String telefone;

	@NotNull(message = "Ativo")
	@ApiModelProperty(value = "Ativo")
	private Boolean ativo;

	@ApiModelProperty(value = "Endereço")
	@NotNull(message = "Endereço")
	@Valid
	private EnderecoRequestDTO enderecoDto;
	
	public Cliente converterParaEntidade(Long codigo) {
		Endereco endereco = new Endereco(enderecoDto.getLogradouro(), enderecoDto.getNumero(),
				enderecoDto.getComplemento(), enderecoDto.getBairro(), enderecoDto.getCep(), enderecoDto.getCidade(),
				enderecoDto.getEstado());
		return new Cliente(codigo,nome, telefone, ativo, endereco);
	}

	public Cliente converterParaEntidade() {
		Endereco endereco = new Endereco(enderecoDto.getLogradouro(), enderecoDto.getNumero(),
				enderecoDto.getComplemento(), enderecoDto.getBairro(), enderecoDto.getCep(), enderecoDto.getCidade(),
				enderecoDto.getEstado());
		return new Cliente(nome, telefone, ativo, endereco);
	}

}
