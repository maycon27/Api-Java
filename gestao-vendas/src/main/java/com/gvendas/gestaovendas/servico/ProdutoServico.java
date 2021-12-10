package com.gvendas.gestaovendas.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gvendas.gestaovendas.repositorio.ProdutoRepositorio;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

import com.gvendas.gestaovendas.entidades.Produto;
import com.gvendas.gestaovendas.excecao.RegraNegocioException;
@Service
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	private CategoriaServico categoriaServico;
	
	public List<Produto> listarTodos(){
		return produtoRepositorio.findAll();
	}

	public Optional<Produto> buscarPorCodigo(Long codigo){
		return produtoRepositorio.findById(codigo);
	}
	
	public Produto salvar(Produto produto) {
		validarCategoriaDoProdutoExiste(produto.getCategoria().getCodigo());
		validarProdutoDuplicado(produto);
		return produtoRepositorio.save(produto);
	}
	
	public Produto atualizar(Long codigoProduto,Produto produto) {
		Produto produtoSalvar = validarProdutoExiste(codigoProduto);
		validarCategoriaDoProdutoExiste(produto.getCategoria().getCodigo());
		validarProdutoDuplicado(produto);
		BeanUtils.copyProperties(produto, produtoSalvar,"codigo");
		return produtoRepositorio.save(produtoSalvar);
	}
	
	public void deletar (Long codigoProduto) {
		Produto produto = validarProdutoExiste(codigoProduto);
		produtoRepositorio.delete(produto);
	}

	
	private Produto validarProdutoExiste(Long codigo) {
		Optional<Produto> produto = buscarPorCodigo(codigo);
		if(produto.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return produto.get();
	}
	
	
	private void validarProdutoDuplicado(Produto produto) {
		Optional<Produto> produtoPorDescricao = produtoRepositorio.findByCategoriaCodigoAndDescricao(produto.getCategoria().getCodigo(), produto.getDescricao());
		if(produtoPorDescricao.isPresent() && produtoPorDescricao.get().getCodigo() != produto.getCodigo()) {
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