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
//		System.out.println("A média do cliente é: " + pedidos);
		
//		ClienteDAO clienteDAO = new ClienteDAO(em);
//		Long idCliente = clienteDAO.findClienteByTelefone("991548795");
//		System.out.println("O id é: " + idCliente);
		
		Long frequencia = pedidoDao.frequencia(1L);
		System.out.println("A frequência dos últimos 30 dias é: " + frequencia);
		
		em.close();
		teste.close();
        
	}
		

}
