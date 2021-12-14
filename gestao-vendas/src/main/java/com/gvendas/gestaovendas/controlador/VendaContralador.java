package com.gvendas.gestaovendas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gvendas.gestaovendas.dto.venda.ClienteVendaResponseDTO;
import com.gvendas.gestaovendas.dto.venda.VendedorVendaResponseDTO;
import com.gvendas.gestaovendas.servico.VendaServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Venda")
@RestController
@RequestMapping("/venda")
public class VendaContralador {

	@Autowired
	private VendaServico vendaServico;
	
	@ApiOperation(value = "Listar vendas por cliente", nickname = "ListarVendaspPorCliente")
	@GetMapping("/cliente/{codigoCliente}") 
	public ResponseEntity<ClienteVendaResponseDTO> listarVendaPorCliente(@PathVariable Long codigoCliente){
		return ResponseEntity.ok(vendaServico.listarVendaPorCliente(codigoCliente));
	}
	
	@ApiOperation(value = "Listar vendas por vendedor", nickname = "ListarVendaspPorVendedor")
	@GetMapping("/vendedor/{codigoVendedor}") 
	public ResponseEntity<VendedorVendaResponseDTO> listarVendaPorVendedor(@PathVariable Long codigoVendedor){
		return ResponseEntity.ok(vendaServico.listarVendaPorVendedor(codigoVendedor));
	}
}
