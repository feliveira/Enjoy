package br.com.oak.dao;

import javax.persistence.EntityManager;

import br.com.oak.domain.Cliente;
import br.com.oak.domain.Pedido;

public class PedidoDAO extends GenericDAO<Pedido, Long>{

	public PedidoDAO(EntityManager em) {
		super(em);
	}
	
	public Double ticketMedio(long ticketMedio) {
		return  em.createQuery("select avg(valorTotal) from Pedido where cliente.id = :idCliente", Double.class)
				.setParameter("idCliente", ticketMedio)
				.getSingleResult();


}
}