package br.com.oak.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PEDIDO")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long id;
	
	@Column(name = "dt_pedido", nullable = false)
	private LocalDate dataPedido;
	
	@JoinColumn(name = "id_cliente")
	@ManyToOne
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido")
	private List<Bebida> bebida;
	
	@Column(name = "vl_total", nullable = false)
	private double valorTotal;
	
	public Pedido() {
		
	}

	public Pedido(LocalDate dataPedido, Cliente cliente, List<Bebida> bebida, double valorTotal) {
		this.dataPedido = dataPedido;
		this.cliente = cliente;
		this.bebida = bebida;
		this.valorTotal = valorTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Bebida> getBebida() {
		return bebida;
	}

	public void setBebida(List<Bebida> bebida) {
		this.bebida = bebida;
	}

	public double getValorTotal() {
		bebida.forEach(bebida -> valorTotal += bebida.getValorBebida());
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
