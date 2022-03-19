package br.com.oak.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;

@Entity
@Table(name = "TB_CLIENTE")
public class Cliente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;
	
    @Column(name = "nm_cliente", nullable = false, length = 50)
    private String nome;
    
    @Column(name="nr_telefone", nullable = false, unique = true, length = 11)
    private String telefone;
    
    @Column(name= "cpf_cliente", unique = true, length = 11)
    private String cpf;
    
    @Column(name="ds_email", unique = true, length = 50)
    private String email;
    
    @Column(name = "dt_nascimento")
    private LocalDate dtNasc;
    
    @Column(name="ds_genero", length = 15)
    private String genero;
    
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;
    
    
    public Cliente() {
		super();
    }
    
	public Cliente(String nome, String telefone, String email, String cpf, LocalDate dtNasc, String genero,
			List<Pedido> pedidos) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.email = email;
		this.dtNasc = dtNasc;
		this.genero = genero;
		this.pedidos = pedidos;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(LocalDate dtNasc) {
		this.dtNasc = dtNasc;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<Pedido> getPedido() {
		return pedidos;
	}

	public void setPedido(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}