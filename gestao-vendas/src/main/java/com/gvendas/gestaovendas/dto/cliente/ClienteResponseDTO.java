package com.gvendas.gestaovendas.dto.cliente;


import com.gvendas.gestaovendas.entidades.Cliente;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@ApiModel("Cliente retorno DTO")
@Getter
@Setter
public class ClienteResponseDTO {

	@ApiModelProperty(value = "Código")
	private Long codigo;

	@ApiModelProperty(value = "Nome")
	private String nome;

	@ApiModelProperty(value = "Telefone")
	private String telefone;

	@ApiModelProperty(value = "Ativo")
	private Boolean ativo;

	private EnderecoResponseDTO endereco;

	public ClienteResponseDTO() {
	}

	public ClienteResponseDTO(Long codigo, String nome, String telefone, Boolean ativo,
							  EnderecoResponseDTO endereco) {
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.ativo = ativo;
		this.endereco = endereco;
	}

	/*public static ClienteResponseDTO converterParaClienteDTO(Cliente cliente) {
		EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO(cliente.getEndereco().getLogradouro(),
				cliente.getEndereco().getNumero(), cliente.getEndereco().getComplemento(),
				cliente.getEndereco().getBairro(), cliente.getEndereco().getCep(), cliente.getEndereco().getCidade(),
				cliente.getEndereco().getEstado());
		return new ClienteResponseDTO(cliente.getCodigo(), cliente.getNome(), cliente.getTelefone(), cliente.getAtivo(),
				enderecoResponseDTO);
	}
*/
	public static ClienteResponseDTO converterParaClienteDTO(Cliente cliente) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(cliente, ClienteResponseDTO.class);
	}
}
