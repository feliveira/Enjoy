package br.com.oak.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long id;

	@Column(name = "dt_pedido")
	private LocalDate dataPedido;

	@JoinColumn(name = "id_cliente")
	@ManyToOne
	private Cliente cliente;

    @ManyToMany(mappedBy="pedidos")
	private List<Bebida> bebidas;

	@Column(name = "vl_total")
	private double valorTotal;

	public Pedido() {

	}

	public Pedido(Long id, LocalDate dataPedido, Cliente cliente, List<Bebida> bebidas, double valorTotal) {
		super();
		this.id = id;
		this.dataPedido = dataPedido;
		this.cliente = cliente;
		this.bebidas = bebidas;
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

	public List<Bebida> getBebidas() {
		return bebidas;
	}

	public void setBebidas(List<Bebida> bebidas) {
		this.bebidas = bebidas;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	

}