package com.gvendas.gestaovendas.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gvendas.gestaovendas.entidades.Categoria;
import com.gvendas.gestaovendas.excecao.RegraNegocioException;
import com.gvendas.gestaovendas.repositorio.CategoriaRepositorio;

import ch.qos.logback.core.joran.util.beans.BeanUtil;import io.swagger.annotations.ApiOperation;
import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class CategoriaServico {

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	public List<Categoria> listarTodas(){
		return categoriaRepositorio.findAll();
	}
	
	public Optional<Categoria> buscarPorCodigo(Long codigo){
		return categoriaRepositorio.findById(codigo);
	}
	
	public Categoria salvar (Categoria categoria) {
		validarCategoriaDuplicada(categoria);
		return categoriaRepositorio.save(categoria);
	}
	
	public void deletar (Long codigo) {
		categoriaRepositorio.deleteById(codigo);
	}
	
	public Categoria atualizar (Long codigo, Categoria categoria) {
		Categoria categoriaSalvar = validarCategoriaExiste(codigo);
		validarCategoriaDuplicada(categoria);
		BeanUtils.copyProperties(categoria, categoriaSalvar,"codigo");
		return categoriaRepositorio.save(categoriaSalvar);
	}

	private Categoria validarCategoriaExiste(Long codigo) {
		Optional<Categoria> categoria = buscarPorCodigo(codigo);
		
		if(categoria.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return categoria.get();
	}
	
	private void validarCategoriaDuplicada(Categoria categoria) {
		Categoria categoriaEncontrada = categoriaRepositorio.findByNome(categoria.getNome());
		
		if(categoriaEncontrada != null && categoriaEncontrada.getCodigo() != categoria.getCodigo()) {
			throw new RegraNegocioException(String.format(" A categoria %s já está cadastrada", categoria.getNome().toUpperCase() ));
		}
	}
}
