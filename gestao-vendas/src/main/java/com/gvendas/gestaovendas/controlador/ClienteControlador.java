package com.gvendas.gestaovendas.controlador;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;


import com.gvendas.gestaovendas.assembler.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gvendas.gestaovendas.dto.cliente.ClienteRequestDTO;
import com.gvendas.gestaovendas.dto.cliente.ClienteResponseDTO;
import com.gvendas.gestaovendas.entidades.Cliente;
import com.gvendas.gestaovendas.servico.ClienteServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Cliente")
@RestController
@RequestMapping("/cliente")
public class ClienteControlador {

	@Autowired
	private ClienteServico clienteServico;

	@Autowired
	private ClienteMapper mapper;

	@ApiOperation(value = "Listar", nickname = "listarTodosClientes")
	@GetMapping
	//@CrossOrigin(origins = "http://localhost:4200")
	public List<ClienteResponseDTO> listarTodos() {
		return clienteServico.listarTodos().stream().map(cliente -> mapper.toModel(cliente))
				.collect(Collectors.toList());
	}

	@ApiOperation(value = "Listar por código", nickname = "buscarClientePorId")
	@GetMapping("/{codigo}")
	//@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable Long codigo) {
		Optional<Cliente> cliente = clienteServico.buscarPorCodigo(codigo);
		return cliente.map(value -> ResponseEntity.ok(ClienteResponseDTO.converterParaClienteDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@ApiOperation(value = "Salvar", nickname = "salvarCliente")
	@PostMapping
	//@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<ClienteResponseDTO> salvar(@Valid @RequestBody ClienteRequestDTO clienteDto) {
		Cliente clienteSalvo = clienteServico.salvar(clienteDto.converterParaEntidade());
		return ResponseEntity.status(HttpStatus.CREATED).body(ClienteResponseDTO.converterParaClienteDTO(clienteSalvo));
	}
	
	@ApiOperation(value = "Atualizar", nickname = "atualizarCliente")
	@PutMapping("/{codigo}")
	//@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable Long codigo,@Valid @RequestBody ClienteRequestDTO clienteDto){
		Cliente clienteAtualizado = clienteServico.atualizar(codigo, clienteDto.converterParaEntidade(codigo));
		return ResponseEntity.ok(ClienteResponseDTO.converterParaClienteDTO(clienteAtualizado));
	}
	
	@ApiOperation(value = "Deletar", nickname = "deletarCliente")
	@DeleteMapping("/{codigo}")
	//@CrossOrigin(origins = "http://localhost:4200")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long codigo) {
		clienteServico.deletar(codigo);
	}

}
