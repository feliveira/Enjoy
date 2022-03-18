package br.com.oak.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.oak.dao.PedidoDAO;
import br.com.oak.domain.Cliente;
import br.com.oak.domain.Pedido;


public class TesteConexao {
	
	public static void main(String[] args) {
		
		
		EntityManagerFactory teste =  Persistence.createEntityManagerFactory("onboarding");
		
		EntityManager em = teste.createEntityManager();
		
		PedidoDAO dao = new PedidoDAO(em);
		
		Cliente pedidos =  dao.ticketMedio("Dani");
		
		System.out.println(pedidos.getNome() + pedidos.getEmail());

		em.close();
		teste.close();
	}
		

}
