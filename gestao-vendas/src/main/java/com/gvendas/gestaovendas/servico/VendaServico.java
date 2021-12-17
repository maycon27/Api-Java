package com.gvendas.gestaovendas.servico;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gvendas.gestaovendas.dto.venda.ClienteVendaResponseDTO;
import com.gvendas.gestaovendas.dto.venda.ItemVendaRequestDTO;
import com.gvendas.gestaovendas.dto.venda.VendaRequestDTO;
import com.gvendas.gestaovendas.dto.venda.VendaResponseDTO;
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

	private VendaRepositorio vendaRepositorio;
	private ClienteServico clienteServico;
	private VendedorServico vendedorServico;
	private ItemVendaRepositorio itemVendaRepositorio;
	private ProdutoServico produtoServico;

	@Autowired
	public VendaServico(VendaRepositorio vendaRepositorio, ClienteServico clienteServico,
			VendedorServico vendedorServico, ItemVendaRepositorio itemVendaRepositorio, ProdutoServico produtoServico) {
		this.vendaRepositorio = vendaRepositorio;
		this.clienteServico = clienteServico;
		this.vendedorServico = vendedorServico;
		this.itemVendaRepositorio = itemVendaRepositorio;
		this.produtoServico = produtoServico;
	}

	public ClienteVendaResponseDTO listarVendaPorCliente(Long codigoCliente) {
		Cliente cliente = validarClienteVendaExiste(codigoCliente);
		List<VendaResponseDTO> vendaResponseDtoList = vendaRepositorio.findByClienteCodigo(codigoCliente).stream()
				.map(venda -> criandoVendaResponseDTO(venda, itemVendaRepositorio.findByVendaCodigo(venda.getCodigo())))
				.collect(Collectors.toList());

		return new ClienteVendaResponseDTO(cliente.getNome(), vendaResponseDtoList);
	}

	public VendedorVendaResponseDTO listarVendaPorVendedor(Long codigoVendedor) {
		Vendedor vendedor = validarVendedorVendaExiste(codigoVendedor);
		List<VendaResponseDTO> vendaVendedorResponseDtoList = vendaRepositorio.findByVendedorCodigo(codigoVendedor)
				.stream().map(venda -> criandoVendaVendedorResponseDTO(venda, itemVendaRepositorio.findByVendaCodigo(venda.getCodigo()))).collect(Collectors.toList());

		return new VendedorVendaResponseDTO(vendedor.getNome(), vendaVendedorResponseDtoList);
	}

	public ClienteVendaResponseDTO listarVendaPorCodigo(Long codigoVenda) {
		Venda venda = validarVendaExiste(codigoVenda);
		List<ItemVenda> itensVendaList = itemVendaRepositorio.findByVendaCodigo(venda.getCodigo());
		return retornandoClienteVendaResponseDTO(venda, itensVendaList);
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public ClienteVendaResponseDTO salvar(VendaRequestDTO vendaDto) {
		Cliente cliente = validarClienteVendaExiste(vendaDto.getCodigoCliente());
		Vendedor vendedor = validarVendedorVendaExiste(vendaDto.getCodigoVendedor());
		validarProdutoExisteEAtualizarQuantidade(vendaDto.getItensVendaDto());
		Venda vendaSalva = salvarVenda(vendaDto, cliente, vendedor);
		
		return retornandoClienteVendaResponseDTO(vendaSalva, itemVendaRepositorio.findByVendaCodigo(vendaSalva.getCodigo()));
		
	}
	
	public ClienteVendaResponseDTO atualizar(Long codigoVenda, VendaRequestDTO vendaDto) {
		 validarVendaExiste(codigoVenda);
		 Cliente cliente = validarClienteVendaExiste(vendaDto.getCodigoCliente());
		 Vendedor vendedor = validarVendedorVendaExiste(vendaDto.getCodigoVendedor());
		 List<ItemVenda> itemVendaList = itemVendaRepositorio.findByVendaCodigo(codigoVenda);
		 devolverEstoque(itemVendaList);
		 validarProdutoExisteEAtualizarQuantidade(vendaDto.getItensVendaDto());
		 itemVendaRepositorio.deleteAll(itemVendaList);
		 Venda vendaAtualizada = atualizarVenda(codigoVenda, vendaDto, cliente, vendedor);
		 return retornandoClienteVendaResponseDTO(vendaAtualizada, itemVendaRepositorio.findByVendaCodigo(vendaAtualizada.getCodigo()));
		 
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
		Venda vendaSalva = vendaRepositorio.save(new Venda(vendaDto.getData(), cliente, vendedor));
		vendaDto.getItensVendaDto().stream().map(itemVendaDto -> criandoItemVenda(itemVendaDto, vendaSalva))
		.forEach(itemVendaRepositorio::save);
		
		return vendaSalva;
	}
	
	public Venda atualizarVenda(Long codigoVenda,VendaRequestDTO vendaDto, Cliente cliente, Vendedor vendedor) {
		Venda vendaSalva = vendaRepositorio.save(new Venda(codigoVenda,vendaDto.getData(), cliente, vendedor));
		vendaDto.getItensVendaDto().stream().map(itemVendaDto -> criandoItemVenda(itemVendaDto, vendaSalva))
		.forEach(itemVendaRepositorio::save);
		
		return vendaSalva;
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
