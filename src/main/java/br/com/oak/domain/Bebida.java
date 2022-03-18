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
public class Bebida {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bebida")
    private Long id;
    
    @Column(name = "nm_bebida", nullable = false, length = 30)
    private String nome;
    
    @Column(name = "nr_quantidade", nullable = false)
    private Integer quantidade;
    
    @Column(name = "sm_valorLitro", nullable = false)
    private Integer valorLitro;
	
	@JoinColumn(name = "id_pedido")
	@ManyToOne
	private Pedido pedido;
    
    public Bebida() {
    	super();
    }

	public Bebida(Long id, String nome, Integer quantidade, Integer valorLitro) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valorLitro = valorLitro;
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

}
