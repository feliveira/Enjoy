package br.com.oak.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_BEBIDA")
public class Bebida {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bebida")
    private Long id;
    
    @Column(name = "nm_bebida", nullable = false, length = 50)
    private String nome;
    
    @Column(name = "nr_quantidade", nullable = false)
    private Integer quantidade;
    
    @Column(name = "vl_litro", nullable = false)
    private Integer valorLitro;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "id_bebida"), inverseJoinColumns = @JoinColumn(name = "id_pedido"), name = "TB_BEBIDA_PEDIDO")
	private List<Pedido> pedidos;
    
    public Bebida() {
    	super();
    }

	public Bebida(Long id, String nome, Integer quantidade, Integer valorLitro, List<Pedido> pedidos) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valorLitro = valorLitro;
		this.pedidos = pedidos;
	}
	
	public double getValorBebida() {
		return quantidade * valorLitro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getValorLitro() {
		return valorLitro;
	}

	public void setValorLitro(Integer valorLitro) {
		this.valorLitro = valorLitro;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}