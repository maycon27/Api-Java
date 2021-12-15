package com.gvendas.gestaovendas.servico;

import java.util.List;
import java.util.stream.Collectors;

import com.gvendas.gestaovendas.dto.venda.ItemVendaResponseDTO;
import com.gvendas.gestaovendas.dto.venda.VendaResponseDTO;
import com.gvendas.gestaovendas.entidades.ItemVenda;
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
}
