package com.gvendas.gestaovendas.controlador;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

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


import com.gvendas.gestaovendas.dto.vendedor.VendedorRequestDTO;
import com.gvendas.gestaovendas.dto.vendedor.VendedorResponseDTO;
import com.gvendas.gestaovendas.entidades.Vendedor;
import com.gvendas.gestaovendas.servico.VendedorServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Vendedor")
@RestController
@RequestMapping("/vendedor")
public class VendedorControlador {

	@Autowired
	private VendedorServico vendedorServico;
	
	@ApiOperation(value = "Listar",nickname = "listarTodas")
	@GetMapping
	public List<VendedorResponseDTO> listarTodos(){
		 return vendedorServico.listarTodos().stream().map(vendedor -> VendedorResponseDTO.converterParaVendedorDTO(vendedor))
				 .collect(Collectors.toList());
	}
	
	@ApiOperation(value = "Listar por código",nickname = "buscarPorId")
	@GetMapping("/{codigo}")
	public ResponseEntity<VendedorResponseDTO> buscarPorId(@PathVariable Long codigo){
		Optional<Vendedor> vendedor = vendedorServico.buscarPorCodigo(codigo);
		return vendedor.isPresent() ? ResponseEntity.ok(VendedorResponseDTO.converterParaVendedorDTO(vendedor.get())) : ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value = "Salvar",nickname = "salvarVendedor")
	@PostMapping
	public ResponseEntity<VendedorResponseDTO> salvar(@Valid @RequestBody VendedorRequestDTO vendedorDto){
		Vendedor vendedorSalvo = vendedorServico.salvar(vendedorDto.converterParaEntidade());
		return ResponseEntity.status(HttpStatus.CREATED).body(VendedorResponseDTO.converterParaVendedorDTO(vendedorSalvo));
	}
	
	@ApiOperation(value = "Atualizar",nickname = "atualizarVendedor")
	@PutMapping("/{codigo}")
	public ResponseEntity<VendedorResponseDTO> atualizar (@PathVariable Long codigo, @Valid @RequestBody VendedorRequestDTO vendedorDto){
		Vendedor vendedorAtualizado = vendedorServico.atualizar(codigo, vendedorDto.converterParaEntidade(codigo));
		return ResponseEntity.ok(VendedorResponseDTO.converterParaVendedorDTO(vendedorAtualizado));
	}
	
	@ApiOperation(value = "Deletar",nickname = "deleteVendedor")
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long codigo) {
		vendedorServico.deletar(codigo);
	}
}
