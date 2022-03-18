package br.com.oak.dao;

import javax.persistence.EntityManager;

import br.com.oak.domain.Cliente;
import br.com.oak.domain.Pedido;

public class PedidoDAO extends GenericDAO<Cliente, Long>{

	public PedidoDAO(EntityManager em) {
		super(em);
	}
	
	public Cliente ticketMedio(String nome) {
		return em.createQuery("from Cliente p where p.nome = :i", Cliente.class)
				.setParameter("i", nome)
				.getSingleResult();
		
	}

}
