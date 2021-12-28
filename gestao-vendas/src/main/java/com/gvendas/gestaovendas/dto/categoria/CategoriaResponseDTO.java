package com.gvendas.gestaovendas.dto.categoria;

import com.gvendas.gestaovendas.entidades.Categoria;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@ApiModel("Categoria retorno DTO")
@Setter
@Getter
public class CategoriaResponseDTO {
	
	@ApiModelProperty(value = "Código")
	private Long codigo;
	
	@ApiModelProperty(value = "Nome")
	private String nome;
	
	
	/*public CategoriaResponseDTO(Long codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	/*public static CategoriaResponseDTO converterParaCategoriaDTO(Categoria categoria) {
		return new CategoriaResponseDTO(categoria.getCodigo(), categoria.getNome());
	}
	 */
	public static CategoriaResponseDTO converterParaCategoriaDTO(Categoria categoria) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(categoria, CategoriaResponseDTO.class);
	}
}
