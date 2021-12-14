package com.gvendas.gestaovendas.entidades;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "codigo")
	private Long codigo;
	
	@Column (name = "data")
	private LocalDate data;

	@ManyToOne
	@JoinColumn(name = "codigo_cliente", referencedColumnName = "codigo")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "codigo_vendedor", referencedColumnName = "codigo")
	private Vendedor vendedor;

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
