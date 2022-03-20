package br.com.oak.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
    
    @Column(name = "vl_litro", nullable = false)
    private Integer valorLitro;
    
    public Bebida() {
    	super();
    }

	public Bebida(Long id, String nome, Integer valorLitro) {
		super();
		this.id = id;
		this.nome = nome;
		this.valorLitro = valorLitro;
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

	public Integer getValorLitro() {
		return valorLitro;
	}

	public void setValorLitro(Integer valorLitro) {
		this.valorLitro = valorLitro;
	}
	
	
//	public List<Pedido> getPedidos() {
//		return pedidos;
//	}
//
//	public void setPedidos(List<Pedido> pedidos) {
//		this.pedidos = pedidos;
//	}

}