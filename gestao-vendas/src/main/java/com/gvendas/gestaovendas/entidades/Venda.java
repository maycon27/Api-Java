package com.gvendas.gestaovendas.entidades;

import com.gvendas.gestaovendas.dto.venda.ItemVendaRequestDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "venda")
@Data
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "codigo")
	private Long codigo;
	
	@Column (name = "data")
	private LocalDate data;

	@Column(name = "ativo")
	private Boolean ativo;

	@ManyToOne
	@JoinColumn(name = "codigo_cliente", referencedColumnName = "codigo")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "codigo_vendedor", referencedColumnName = "codigo")
	private Vendedor vendedor;


	@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<ItemVenda> itens;

	
	public Venda() {

	}
	
	public Venda(Long codigo,LocalDate data, Boolean ativo, Cliente cliente, Vendedor vendedor) {
		this.codigo = codigo;
		this.data = data;
		this.ativo = ativo;
		this.cliente = cliente;
		this.vendedor = vendedor;
		
	}
	public Venda(LocalDate data,  Boolean ativo, Cliente cliente, Vendedor vendedor) {
		this.data = data;
		this.ativo = ativo;
		this.cliente = cliente;
		this.vendedor = vendedor;
	}
	public Venda(LocalDate data,Boolean ativo, Cliente cliente, Vendedor vendedor,List<ItemVenda> itens ) {
		this.data = data;
		this.ativo = ativo;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.itens = itens;
	}

	public Venda(Long codigo,LocalDate data, Boolean ativo, Cliente cliente, Vendedor vendedor,List<ItemVenda> itens) {
		this.codigo = codigo;
		this.data = data;
		this.ativo = ativo;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.itens = itens;

	}

}
