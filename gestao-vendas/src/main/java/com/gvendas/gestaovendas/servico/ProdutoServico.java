package com.gvendas.gestaovendas.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gvendas.gestaovendas.repositorio.ProdutoRepositorio;
import com.gvendas.gestaovendas.entidades.Produto;
import com.gvendas.gestaovendas.excecao.RegraNegocioException;
@Service
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	private CategoriaServico categoriaServico;
	
	public List<Produto> listarTodos(Long codigoCategoria){
		return produtoRepositorio.findByCategoriaCodigo(codigoCategoria);
	}
	
	public Optional<Produto> buscarPorCodigo(Long codigo, Long codigoCategoria){
		return produtoRepositorio.buscarPorCodigo(codigo, codigoCategoria);
	}
	
	public Produto salvar(Produto produto) {
		validarCategoriaDoProdutoExiste(produto.getCategoria().getCodigo());
		validarProdutoDuplicado(produto);
		return produtoRepositorio.save(produto);
	}
	
	private void validarProdutoDuplicado(Produto produto) {
		if(produtoRepositorio.findByCategoriaCodigoAndDescricao(produto.getCategoria().getCodigo(), produto.getDescricao()).isPresent()) {
			throw new RegraNegocioException(String.format("o produto %s ja está cadastrado", produto.getDescricao()));
		}
	}
	
	public void validarCategoriaDoProdutoExiste(Long codigoCategoria) {
		if(codigoCategoria == null) {
			throw new RegraNegocioException("A categoria não pode ser nula");
		}
		
		if(categoriaServico.buscarPorCodigo(codigoCategoria).isEmpty()) {
			throw new RegraNegocioException(String.format("A categoria de codigo %s não existe no cadastro", codigoCategoria));
		}
	}
}
