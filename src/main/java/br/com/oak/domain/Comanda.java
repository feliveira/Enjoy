package br.com.oak.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_COMANDA")
public class Comanda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comanda")
	private Long id;
	
	@Column(name = "dt_comanda", nullable = false)
	private LocalDate dataComanda;
	
	@Column(name = "vl_total", nullable = false)
	private double valorTotal = 0.0;
	
	@JoinColumn(name = "id_cliente")
	@ManyToOne
	private Cliente cliente;
	
	@OneToMany(mappedBy = "comanda")
	private List<Consumo> consumos;
	
	public Comanda() {
		super();
	}

	public Comanda(LocalDate dataComanda, Cliente cliente, List<Consumo> consumos) {
		super();
		this.dataComanda = dataComanda;
		this.cliente = cliente;
		this.consumos = consumos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataComanda() {
		return dataComanda;
	}

	public void setDataPedido(LocalDate dataComanda) {
		this.dataComanda = dataComanda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getValorTotal() {
		consumos.forEach(consumo -> valorTotal += consumo.getValorConsumo());
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public List<Consumo> getConsumos() {
		return consumos;
	}

	public void setConsumo(List<Consumo> consumos) {
		this.consumos = consumos;
	}
	
}