package com.gvendas.gestaovendas.servico;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gvendas.gestaovendas.dto.venda.ClienteVendaResponseDTO;
import com.gvendas.gestaovendas.dto.venda.ItemVendaResponseDTO;
import com.gvendas.gestaovendas.dto.venda.VendaResponseDTO;
import com.gvendas.gestaovendas.dto.venda.VendedorVendaResponseDTO;
import com.gvendas.gestaovendas.entidades.Cliente;
import com.gvendas.gestaovendas.entidades.ItemVenda;
import com.gvendas.gestaovendas.entidades.Venda;
import com.gvendas.gestaovendas.entidades.Vendedor;
import com.gvendas.gestaovendas.excecao.RegraNegocioException;
import com.gvendas.gestaovendas.repositorio.ItemVendaRepositorio;
import com.gvendas.gestaovendas.repositorio.VendaRepositorio;

@Service
public class VendaServico {

	private VendaRepositorio vendaRepositorio;
	private ClienteServico clienteServico;
	private VendedorServico vendedorServico;
	private ItemVendaRepositorio itemVendaRepositorio;
	
	@Autowired
	public VendaServico(VendaRepositorio vendaRepositorio, ClienteServico clienteServico,
			VendedorServico vendedorServico, ItemVendaRepositorio itemVendaRepositorio) {
		this.vendaRepositorio = vendaRepositorio;
		this.clienteServico = clienteServico;
		this.vendedorServico = vendedorServico;
		this.itemVendaRepositorio = itemVendaRepositorio;
	}

	public ClienteVendaResponseDTO listarVendaPorCliente(Long codigoCliente) {
		Cliente cliente = validarClienteVendaExiste(codigoCliente);
		List<VendaResponseDTO> vendaResponseDtoList = vendaRepositorio.findByClienteCodigo(codigoCliente).stream().
		map(this::criandoVendaResponseDTO).collect(Collectors.toList());
		
		return new ClienteVendaResponseDTO(cliente.getNome(), vendaResponseDtoList);
	}
	
	public VendedorVendaResponseDTO listarVendaPorVendedor(Long codigoVendedor) {
		Vendedor vendedor = validarVendedorVendaExiste(codigoVendedor);
		List<VendaResponseDTO> vendaVendedorResponseDtoList = vendaRepositorio.findByVendedorCodigo(codigoVendedor).stream()
				.map(this::criandoVendaVendedorResponseDTO).collect(Collectors.toList());
		
		return new VendedorVendaResponseDTO(vendedor.getNome(), vendaVendedorResponseDtoList);
	}

	private Vendedor validarVendedorVendaExiste(Long codigoVendedor) {
		Optional<Vendedor> vendedor = vendedorServico.buscarPorCodigo(codigoVendedor);
		
		if(vendedor.isEmpty()) {
			throw new RegraNegocioException(String.format("O vendedor de codigo %s não existe", codigoVendedor));
		}
		
		return vendedor.get();
	}

	private Cliente validarClienteVendaExiste(Long codigoCliente) {
		Optional<Cliente> cliente = clienteServico.buscarPorCodigo(codigoCliente);
		
		if(cliente.isEmpty()) {
			throw new RegraNegocioException(String.format("O cliente de codigo %s não existe", codigoCliente));
		}
		
		return cliente.get();
	}
	
	private VendaResponseDTO criandoVendaResponseDTO(Venda venda) {
		List<ItemVendaResponseDTO> itensVendaResponseDTO = itemVendaRepositorio.findByVendaCodigo(venda.getCodigo())
				.stream().map(this::criandoItemVendaResponseDTO).collect(Collectors.toList());
		
		return new VendaResponseDTO(venda.getCodigo(), venda.getData(), itensVendaResponseDTO, venda.getVendedor().getNome());
		
	}
	
	private VendaResponseDTO criandoVendaVendedorResponseDTO(Venda venda) {
		List<ItemVendaResponseDTO> itensVendaResponseDTO = itemVendaRepositorio.findByVendaCodigo(venda.getCodigo())
				.stream().map(this::criandoItemVendaResponseDTO).collect(Collectors.toList());
		
		return new VendaResponseDTO(venda.getCodigo(), venda.getData(), itensVendaResponseDTO, venda.getCliente().getNome());
		
	}
	
	private ItemVendaResponseDTO criandoItemVendaResponseDTO(ItemVenda itemVenda) {
		return new ItemVendaResponseDTO(itemVenda.getCodigo(), itemVenda.getQuantidade(), itemVenda.getPrecoVendido(),
				itemVenda.getPagamentoVista(), itemVenda.getPagamentoPrazo(), itemVenda.getProduto().getCodigo(),
				itemVenda.getProduto().getDescricao());
	}
}
