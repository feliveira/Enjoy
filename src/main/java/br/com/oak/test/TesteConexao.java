package br.com.oak.test;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.oak.dao.PedidoDAO;


public class TesteConexao {
	
	public static void main(String[] args) {
		

		
		EntityManagerFactory teste =  Persistence.createEntityManagerFactory("onboarding");
		
		EntityManager em = teste.createEntityManager();
		
		PedidoDAO dao = new PedidoDAO(em);
		
		Double pedidos =  dao.ticketMedio(1l);
		
		System.out.println("A m�dia do cliente �: " + pedidos);

		em.close();
		teste.close();
        
	}
		

}
