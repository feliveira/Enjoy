package br.com.oak.dao;

import javax.persistence.EntityManager;

import br.com.oak.domain.Pedido;

public class PedidoDAO extends GenericDAO<Pedido, Long> {

	public PedidoDAO(EntityManager em) {
		super(em);
	}

	public Double ticketMedio(long ticketMedio) {
		return em.createQuery("select avg(valorTotal) from TB_PEDIDO where cliente.id = :idCliente", Double.class)
				.setParameter("idCliente", ticketMedio).getSingleResult();

	}
	
	public Long frequencia(Long id) {
		return em.createQuery("SELECT COUNT(DISTINCT(DT_PEDIDO)) "
				+ "FROM TB_PEDIDO WHERE DT_PEDIDO BETWEEN SYSDATE-30 AND SYSDATE "
				+ "AND ID_CLIENTE = :idCliente"
				, Long.class)
				.setParameter("idCliente", id).getSingleResult();
		
	}
}