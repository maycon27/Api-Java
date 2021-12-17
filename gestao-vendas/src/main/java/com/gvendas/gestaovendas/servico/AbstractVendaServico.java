package com.gvendas.gestaovendas.servico;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.gvendas.gestaovendas.dto.venda.ClienteVendaResponseDTO;
import com.gvendas.gestaovendas.dto.venda.ItemVendaRequestDTO;
import com.gvendas.gestaovendas.dto.venda.ItemVendaResponseDTO;
import com.gvendas.gestaovendas.dto.venda.VendaResponseDTO;
import com.gvendas.gestaovendas.entidades.ItemVenda;
import com.gvendas.gestaovendas.entidades.Produto;
import com.gvendas.gestaovendas.entidades.Venda;

public abstract class AbstractVendaServico {

	protected VendaResponseDTO criandoVendaResponseDTO(Venda venda, List<ItemVenda> itensVendaList) {
		List<ItemVendaResponseDTO> itensVendaResponseDTO = itensVendaList
				.stream().map(this::criandoItemVendaResponseDTO).collect(Collectors.toList());
		
		return new VendaResponseDTO(venda.getCodigo(), venda.getData(), itensVendaResponseDTO, venda.getVendedor().getNome());
		
	}
	protected VendaResponseDTO criandoVendaVendedorResponseDTO(Venda venda,  List<ItemVenda> itensVendaList) {
		List<ItemVendaResponseDTO> itensVendaResponseDTO = itensVendaList
				.stream().map(this::criandoItemVendaResponseDTO).collect(Collectors.toList());
		
		return new VendaResponseDTO(venda.getCodigo(), venda.getData(), itensVendaResponseDTO, venda.getCliente().getNome());
		
	}
	
	protected ItemVendaResponseDTO criandoItemVendaResponseDTO(ItemVenda itemVenda) {
		return new ItemVendaResponseDTO(itemVenda.getCodigo(), itemVenda.getQuantidade(), itemVenda.getPrecoVendido(),
				itemVenda.getPagamentoVista(), itemVenda.getPagamentoPrazo(), itemVenda.getProduto().getCodigo(),
				itemVenda.getProduto().getDescricao());
	}
	
	protected ClienteVendaResponseDTO retornandoClienteVendaResponseDTO(Venda venda, List<ItemVenda> itensVendaList) {
		return new ClienteVendaResponseDTO(venda.getCliente().getNome(),Arrays.asList(
				criandoVendaResponseDTO(venda,itensVendaList )));
	}
	
	protected ItemVenda criandoItemVenda(ItemVendaRequestDTO itemVendaDto, Venda venda) {
		return new ItemVenda(itemVendaDto.getQuantidade(),itemVendaDto.getPrecoVendido(),itemVendaDto.getPagamentoVista(),
				itemVendaDto.getPagamentoPrazo(),new Produto(itemVendaDto.getCodigoProduto()),venda);
	}
}
