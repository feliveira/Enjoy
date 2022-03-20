package br.com.oak.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CONSUMO")
public class Consumo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consumo")
    private Long id;
	
	@Column(name = "qtd_bebida", nullable = false)
	private Integer quantidade;
	
	@Column(name = "vl_consumo", nullable = false)
	private double valorConsumo;
	
	@ManyToOne
	@JoinColumn(name = "id_comanda", nullable = false)
	private Comanda comanda;

	@ManyToOne
	@JoinColumn(name = "id_bebida", nullable = false)
	private Bebida bebida;

	public Consumo() {
		super();
	}

	public Consumo(Long id, Integer quantidade, Comanda comanda, Bebida bebida) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.comanda = comanda;
		this.bebida = bebida;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorConsumo() {
		valorConsumo += (bebida.getValorLitro() * quantidade)/1000;
		return valorConsumo;
	}

	public void setValorConsumo(double valorConsumo) {
		this.valorConsumo = valorConsumo;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public Bebida getBebida() {
		return bebida;
	}

	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}
	
	

}



