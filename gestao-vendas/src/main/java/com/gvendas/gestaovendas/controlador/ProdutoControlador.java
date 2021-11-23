package com.gvendas.gestaovendas.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gvendas.gestaovendas.servico.ProdutoServico;
import com.gvendas.gestaovendas.entidades.Produto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Produto")
@RestController
@RequestMapping("/categoria{codigoCategoria}/produto")
public class ProdutoControlador {
	
	@Autowired
	private ProdutoServico produtoServico;

	@ApiOperation(value = "Listar")
	@GetMapping
	public List<Produto> ListarTodas(@PathVariable Long codigoCategoria){
		return produtoServico.listarTodos(codigoCategoria);
	}
	
	@ApiOperation(value = "Listar por Código")
	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Produto>> buscarPorCodigo(@PathVariable Long codigoCategoria, 
			@PathVariable Long codigo){
		Optional<Produto> produto = produtoServico.buscarPorCodigo(codigo, codigoCategoria);
		return produto.isPresent() ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
	}
	
}
