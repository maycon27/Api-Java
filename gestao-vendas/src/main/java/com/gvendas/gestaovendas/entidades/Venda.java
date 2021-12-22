package com.gvendas.gestaovendas.entidades;

import com.gvendas.gestaovendas.dto.venda.ItemVendaRequestDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "venda")
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

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public List<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, codigo, data, vendedor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Venda)) {
			return false;
		}
		Venda other = (Venda) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(data, other.data) && Objects.equals(vendedor, other.vendedor);
	}
	
	
}
