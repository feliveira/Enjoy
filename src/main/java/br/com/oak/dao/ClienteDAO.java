package br.com.oak.dao;

import javax.persistence.EntityManager;

import br.com.oak.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Long> {
	
	public ClienteDAO(EntityManager em) {
		super(em);
	}

	public Long findClienteByTelefone(String telefone) {
		return em.createQuery("select id from TB_CLIENTE where telefone = :nrtelefone", Long.class)
				.setParameter("nrtelefone", telefone).getSingleResult();

	}

}
