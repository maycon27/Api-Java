package com.gvendas.gestaovendas.controlador;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gvendas.gestaovendas.dto.produto.ProdutoRequestDTO;
import com.gvendas.gestaovendas.dto.produto.ProdutoResponseDTO;
import com.gvendas.gestaovendas.entidades.Produto;
import com.gvendas.gestaovendas.servico.ProdutoServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Produto")
@RestController
@RequestMapping("/produtos")
public class ProdutoControlador {
	
	@Autowired
	private ProdutoServico produtoServico;



	@ApiOperation(value = "Listar",nickname = "ListarTodas")
	@GetMapping
	//@CrossOrigin(origins = "http://localhost:4200")
	public List<ProdutoResponseDTO> ListarTodas(){
		return produtoServico.listarTodos().stream()
				.map(produto -> ProdutoResponseDTO.converterParaProdutoDTO(produto))
				.collect(Collectors.toList());
	}
	@ApiOperation(value = "Listar por Código",nickname = "buscarPorCodigo")
	@GetMapping("/{codigo}")
	//@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<ProdutoResponseDTO> buscarPorCodigo(
			@PathVariable Long codigo){
		Optional<Produto> produto = produtoServico.buscarPorCodigo(codigo);
		return produto.isPresent() ? ResponseEntity.ok(ProdutoResponseDTO.converterParaProdutoDTO(produto.get())) : ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value = "Salvar", nickname = "salvarProduto")
	@PostMapping
	//@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<ProdutoResponseDTO> salvar(@Valid @RequestBody ProdutoRequestDTO produto){
		Produto produtosalvo = produtoServico.salvar(produto.converterParaEntidade());
		return ResponseEntity.status(HttpStatus.CREATED).body(ProdutoResponseDTO.converterParaProdutoDTO(produtosalvo));
	}
	
	@ApiOperation(value = "Atualizar", nickname = "atualizarProduto")
	@PutMapping("/{codigoProduto}")
	//@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<ProdutoResponseDTO> atualizar( @PathVariable Long codigoProduto 
			,@Valid @RequestBody ProdutoRequestDTO produto){
		Produto produtoAtualizado = produtoServico.atualizar( codigoProduto, produto.converterParaEntidade(codigoProduto));
		return ResponseEntity.ok(ProdutoResponseDTO.converterParaProdutoDTO(produtoAtualizado));
	}
	
	@ApiOperation(value = "Deletar", nickname = "deletarProduto")
	@DeleteMapping("/{codigoProduto}")
	//@CrossOrigin(origins = "http://localhost:4200")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long codigoProduto ) {
		produtoServico.deletar(codigoProduto);
	}
}