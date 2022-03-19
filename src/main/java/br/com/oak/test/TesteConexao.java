package br.com.oak.test;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.oak.dao.ClienteDAO;
import br.com.oak.dao.PedidoDAO;


public class TesteConexao {
	
	public static void main(String[] args) {
		

		
		EntityManagerFactory teste =  Persistence.createEntityManagerFactory("onboarding");
		
		EntityManager em = teste.createEntityManager();
		
		PedidoDAO pedidoDao = new PedidoDAO(em);
//		Double pedidos =  dao.ticketMedio(1l);
//		System.out.println("A m�dia do cliente �: " + pedidos);
		
//		ClienteDAO clienteDAO = new ClienteDAO(em);
//		Long idCliente = clienteDAO.findClienteByTelefone("991548795");
//		System.out.println("O id �: " + idCliente);
		
		Long frequencia = pedidoDao.frequencia(1L);
		System.out.println("A frequ�ncia dos �ltimos 30 dias �: " + frequencia);
		
		em.close();
		teste.close();
        
	}
		

}
