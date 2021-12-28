package com.gvendas.gestaovendas.servico;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.gvendas.gestaovendas.dto.venda.ClienteVendaResponseDTO;
import com.gvendas.gestaovendas.dto.venda.ItemVendaRequestDTO;
import com.gvendas.gestaovendas.dto.venda.ItemVendaResponseDTO;
import com.gvendas.gestaovendas.dto.venda.VendaResponseDTO;
import com.gvendas.gestaovendas.dto.venda.VendaVendedorResponseDTO;
import com.gvendas.gestaovendas.entidades.ItemVenda;
import com.gvendas.gestaovendas.entidades.Produto;
import com.gvendas.gestaovendas.entidades.Venda;

public abstract class AbstractVendaServico {


	protected VendaResponseDTO criandoVendaResponseDTO(Venda venda) {
		List<ItemVendaResponseDTO> itensVendaResponseDTO = venda.getItens()
				.stream().map(this::criandoItemVendaResponseDTO).collect(Collectors.toList());

		return new VendaResponseDTO(venda.getCodigo(), venda.getData(),venda.getAtivo(),
				itensVendaResponseDTO, venda.getVendedor().getNome(), venda.getCliente().getNome());

	}
	
	protected ItemVendaResponseDTO criandoItemVendaResponseDTO(ItemVenda itemVenda) {
		return new ItemVendaResponseDTO(itemVenda.getCodigo(), itemVenda.getQuantidade(), itemVenda.getPrecoVendido(),
				itemVenda.getPagamentoVista(), itemVenda.getPagamentoPrazo(), itemVenda.getProduto().getCodigo(),
				itemVenda.getProduto().getDescricao());
	}
	
	protected ClienteVendaResponseDTO retornandoClienteVendaResponseDTO(Venda venda) {
		return new ClienteVendaResponseDTO(venda.getCliente().getNome(),List.of(
				criandoVendaResponseDTO(venda)));
	}
}
