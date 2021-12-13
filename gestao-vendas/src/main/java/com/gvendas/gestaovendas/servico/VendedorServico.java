package com.gvendas.gestaovendas.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gvendas.gestaovendas.entidades.Vendedor;
import com.gvendas.gestaovendas.excecao.RegraNegocioException;
import com.gvendas.gestaovendas.repositorio.VendedorRepositorio;

@Service
public class VendedorServico {
	
	@Autowired
	private VendedorRepositorio vendedorRespositorio;
	
	public List<Vendedor>listarTodos(){
		return vendedorRespositorio.findAll();
	}
	
	public Optional<Vendedor> buscarPorCodigo(Long codigo){
		return vendedorRespositorio.findById(codigo);
	}
	
	public Vendedor salvar (Vendedor vendedor) {
		validarVendedorDuplicado(vendedor);
		return vendedorRespositorio.save(vendedor);
	}
	
	public void deletar (Long codigo) {
		vendedorRespositorio.deleteById(codigo);
	}
	
	public Vendedor atualizar (Long codigo, Vendedor vendedor) {
		Vendedor vendedorSalvar = validarVendedorExiste(codigo);
		validarVendedorDuplicado(vendedor);
		BeanUtils.copyProperties(vendedor, vendedorSalvar,"codigo");
		return vendedorRespositorio.save(vendedorSalvar);
	}
	
	private Vendedor validarVendedorExiste(Long codigo) {
		Optional<Vendedor> vendedor = buscarPorCodigo(codigo);
		
		if(vendedor.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return vendedor.get();
	}
	
	private void validarVendedorDuplicado(Vendedor vendedor) {
		Vendedor vendedorEncontrada = vendedorRespositorio.findByNome(vendedor.getNome());
		
		if(vendedorEncontrada != null && vendedorEncontrada.getCodigo() != vendedor.getCodigo()) {
			throw new RegraNegocioException(String.format(" A vendedor %s já está cadastrado", vendedor.getNome().toUpperCase() ));
		}
	}

}
