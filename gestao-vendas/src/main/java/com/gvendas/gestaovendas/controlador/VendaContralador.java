package com.gvendas.gestaovendas.controlador;

import javax.validation.Valid;

import com.gvendas.gestaovendas.dto.venda.VendaResponseDTO;
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

import com.gvendas.gestaovendas.dto.venda.ClienteVendaResponseDTO;
import com.gvendas.gestaovendas.dto.venda.VendaRequestDTO;
import com.gvendas.gestaovendas.dto.venda.VendedorVendaResponseDTO;
import com.gvendas.gestaovendas.servico.VendaServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "Venda")
@RestController
@RequestMapping("/venda")
public class VendaContralador {

	@Autowired
	private VendaServico vendaServico;

	@ApiOperation(value = "Listar vendas", nickname = "ListarVendas")
	@GetMapping
	public List<VendaResponseDTO> listarTodos(){
		return vendaServico.listarTodos();
	}
	
	@ApiOperation(value = "Listar vendas por codigo", nickname = "ListarVendaspPorCodigo")
	@GetMapping("/{codigoVenda}") 
	public ResponseEntity<VendaResponseDTO> listarVendaPorCodigo(@PathVariable Long codigoVenda){
		return ResponseEntity.ok(vendaServico.listarVendaPorCodigo(codigoVenda));
	}
	
	@ApiOperation(value = "Registrar Venda", nickname = "salvar")
	@PostMapping
	public ResponseEntity<ClienteVendaResponseDTO> salvar(@Valid @RequestBody VendaRequestDTO vendaDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaServico.salvar(vendaDto));
	}
	
	@ApiOperation(value = "Atualizar Venda", nickname = "atualizar")
	@PutMapping("/{codigoVenda}")
	public ResponseEntity<ClienteVendaResponseDTO> atualizar(@PathVariable Long codigoVenda, @Valid @RequestBody VendaRequestDTO vendaDto){
		return ResponseEntity.ok(vendaServico.atualizar(codigoVenda, vendaDto));
	}
	
	@ApiOperation(value = "Deletar vendas por codigo", nickname = "DeletarVendaspPorCodigo")
	@DeleteMapping("/{codigoVenda}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long codigoVenda) {
		vendaServico.deletar(codigoVenda);
	}
}
