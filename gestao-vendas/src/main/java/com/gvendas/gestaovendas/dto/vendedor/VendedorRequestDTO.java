package com.gvendas.gestaovendas.dto.vendedor;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import com.gvendas.gestaovendas.entidades.Vendedor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Vendedor requisição DTO")
@Data
public class VendedorRequestDTO {
	
	@ApiModelProperty(value = "Nome")
	@NotBlank(message = "Nome")
	@Length(min = 3 , max = 50, message = "Nome")
	private String nome;

	
	public Vendedor converterParaEntidade() {
		return new Vendedor(nome);
	}
	
	public Vendedor converterParaEntidade(Long codigo) {
		return new Vendedor(codigo,nome);
	}

}
