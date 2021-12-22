package com.gvendas.gestaovendas.servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gvendas.gestaovendas.dto.venda.ClienteVendaResponseDTO;
import com.gvendas.gestaovendas.dto.venda.ItemVendaRequestDTO;
import com.gvendas.gestaovendas.dto.venda.VendaRequestDTO;
import com.gvendas.gestaovendas.dto.venda.VendaResponseDTO;
import com.gvendas.gestaovendas.dto.venda.VendaVendedorResponseDTO;
import com.gvendas.gestaovendas.dto.venda.VendedorVendaResponseDTO;
import com.gvendas.gestaovendas.entidades.Cliente;
import com.gvendas.gestaovendas.entidades.ItemVenda;
import com.gvendas.gestaovendas.entidades.Produto;
import com.gvendas.gestaovendas.entidades.Venda;
import com.gvendas.gestaovendas.entidades.Vendedor;
import com.gvendas.gestaovendas.excecao.RegraNegocioException;
import com.gvendas.gestaovendas.repositorio.ItemVendaRepositorio;
import com.gvendas.gestaovendas.repositorio.VendaRepositorio;

@Service
public class VendaServico extends AbstractVendaServico {

	@Autowired
	private VendaRepositorio vendaRepositorio;
	@Autowired
	private ClienteServico clienteServico;
	@Autowired
	private VendedorServico vendedorServico;
	@Autowired
	private ItemVendaRepositorio itemVendaRepositorio;
	@Autowired
	private ProdutoServico produtoServico;


	public List<VendaResponseDTO> listarTodos(){
		return vendaRepositorio.findAll().stream().map(this::criandoVendaResponseDTO)
				.collect(Collectors.toList());
	}

	public ClienteVendaResponseDTO listarVendaPorCodigo(Long codigoVenda) {
		Venda venda = validarVendaExiste(codigoVenda);
		return retornandoClienteVendaResponseDTO(venda);
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public ClienteVendaResponseDTO salvar(VendaRequestDTO vendaDto) {
		var cliente = validarClienteVendaExiste(vendaDto.getCodigoCliente());
		var vendedor = validarVendedorVendaExiste(vendaDto.getCodigoVendedor());
		validarProdutoExisteEAtualizarQuantidade(vendaDto.getItensVendaDto());
		var vendaSalva = salvarVenda(vendaDto, cliente, vendedor);
		
		return retornandoClienteVendaResponseDTO(vendaSalva);
		
	}
	
	public ClienteVendaResponseDTO atualizar(Long codigoVenda, VendaRequestDTO vendaDto) {
		 var vendaSalva = validarVendaExiste(codigoVenda);
		 Cliente cliente = validarClienteVendaExiste(vendaDto.getCodigoCliente());
		 Vendedor vendedor = validarVendedorVendaExiste(vendaDto.getCodigoVendedor());

		 devolverEstoque(vendaSalva.getItens());
		 validarProdutoExisteEAtualizarQuantidade(vendaDto.getItensVendaDto());
		 Venda vendaAtualizada = atualizarVenda(codigoVenda, vendaDto, cliente, vendedor);
		 return retornandoClienteVendaResponseDTO(vendaAtualizada);
		 
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public void deletar(Long codigoVenda) {
		validarVendaExiste(codigoVenda);
		List<ItemVenda> itensVenda = itemVendaRepositorio.findByVendaCodigo(codigoVenda);
		devolverEstoque(itensVenda);
		itemVendaRepositorio.deleteAll(itensVenda);
		vendaRepositorio.deleteById(codigoVenda);
	}
	
	
	private void devolverEstoque(List<ItemVenda> itensVenda) {
		itensVenda.forEach(item ->
		{
			Produto produto = produtoServico.validarProdutoExiste(item.getProduto().getCodigo());
			produto.setQuantidade(produto.getQuantidade() + item.getQuantidade());
			produtoServico.atualizarQuantidade(produto);
		});
	}
	

	
	public Venda salvarVenda(VendaRequestDTO vendaDto, Cliente cliente, Vendedor vendedor) {

		var novaVenda = new Venda();
		novaVenda.setVendedor(new Vendedor(vendedor.getCodigo()));
		novaVenda.setCliente(new Cliente(cliente.getCodigo()));
		novaVenda.setData(vendaDto.getData());
		novaVenda.setAtivo(vendaDto.getAtivo());
		novaVenda.setItens(new ArrayList<>());

		vendaDto.getItensVendaDto().forEach(item->{
			var novoItem = new ItemVenda();
			novoItem.setVenda(novaVenda);
			novoItem.setQuantidade(item.getQuantidade());
			novoItem.setPagamentoPrazo(item.getPagamentoPrazo());
			novoItem.setPagamentoVista(item.getPagamentoVista());
			novoItem.setPrecoVendido(item.getPrecoVendido());
			novoItem.setProduto(new Produto(item.getCodigoProduto()));
			novaVenda.getItens().add(novoItem);
		});


		vendaRepositorio.save(novaVenda);

		return novaVenda;
	}
	
	public Venda atualizarVenda(Long codigoVenda,VendaRequestDTO vendaDto, Cliente cliente, Vendedor vendedor) {
		var novaVenda = new Venda();
		novaVenda.setCodigo(codigoVenda);
		novaVenda.setVendedor(new Vendedor(vendedor.getCodigo()));
		novaVenda.setCliente(new Cliente(cliente.getCodigo()));
		novaVenda.setData(vendaDto.getData());
		novaVenda.setAtivo(vendaDto.getAtivo());
		novaVenda.setItens(new ArrayList<>());

		vendaDto.getItensVendaDto().forEach(item->{
			var novoItem = new ItemVenda();
			novoItem.setVenda(novaVenda);
			novoItem.setQuantidade(item.getQuantidade());
			novoItem.setPagamentoPrazo(item.getPagamentoPrazo());
			novoItem.setPagamentoVista(item.getPagamentoVista());
			novoItem.setPrecoVendido(item.getPrecoVendido());
			novoItem.setProduto(new Produto(item.getCodigoProduto()));
			novaVenda.getItens().add(novoItem);
		});

		vendaRepositorio.save(novaVenda);

		return novaVenda;
	}

	private void validarProdutoExisteEAtualizarQuantidade(List<ItemVendaRequestDTO> itensVendaDto) {
		itensVendaDto.forEach(item -> {
			Produto produto = produtoServico.validarProdutoExiste(item.getCodigoProduto());
			validarQuantidadeProdutoExiste(produto, item.getQuantidade());
			produto.setQuantidade(produto.getQuantidade() - item.getQuantidade());
			produtoServico.atualizarQuantidade(produto);
		});
		
	}
	
	private void validarQuantidadeProdutoExiste(Produto produto, Integer quantidade) {
		if(!(produto.getQuantidade() >= quantidade)){
			throw new RegraNegocioException(String.format("A quantidade %s informada do produto %s não está disponivel no estoque.",
					quantidade, produto.getDescricao()));
		}
		
	}

	private Venda validarVendaExiste(Long codigoVenda) {
		Optional<Venda> venda = vendaRepositorio.findById(codigoVenda);
		if (venda.isEmpty()) {
			throw new RegraNegocioException(String.format("A venda de codigo %s não existe", codigoVenda));
		}

		return venda.get();
	}

	private Vendedor validarVendedorVendaExiste(Long codigoVendedor) {
		Optional<Vendedor> vendedor = vendedorServico.buscarPorCodigo(codigoVendedor);

		if (vendedor.isEmpty()) {
			throw new RegraNegocioException(String.format("O vendedor de codigo %s não existe", codigoVendedor));
		}

		return vendedor.get();
	}

	private Cliente validarClienteVendaExiste(Long codigoCliente) {
		Optional<Cliente> cliente = clienteServico.buscarPorCodigo(codigoCliente);

		if (cliente.isEmpty()) {
			throw new RegraNegocioException(String.format("O cliente de codigo %s não existe", codigoCliente));
		}

		return cliente.get();
	}
	
	

}
