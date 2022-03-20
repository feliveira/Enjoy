package br.com.oak.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.oak.domain.Cliente;

public class TesteConexao {

	public static void main(String[] args) {
		
		EntityManager em = Persistence.createEntityManagerFactory("onboarding").createEntityManager();
		String[] phones = {"19996548523","11996858532", "11997858523","11996898523","11996858523","11996548553","19996548594","11996542694","11996542704","19996542705"};
		String telefoneCliente = phones[(int)(Math.random() * 10 - 1 ) + 1];
		
		System.out.println("==================== Enjoy ===================="
							+"\nBoas vindas ao nosso estabelecimento!"
							+"\nTelefone do cliente para Onboarding: " + telefoneCliente
							+"\n================= Informações =================");
		
		Cliente idCliente = new Cliente();
		idCliente = (Cliente) em.createQuery("FROM Cliente where telefone = :phone").setParameter("phone", telefoneCliente).getSingleResult();
		
		System.out.println("Cliente: " + idCliente.getNome() );
		
		System.out.println("Data da última visita: " 
		+ em.createQuery("SELECT cm.dataComanda FROM Comanda cm INNER JOIN Cliente c ON c.id = cm.cliente WHERE c.telefone = :phone ORDER BY cm.dataComanda DESC")
		.setParameter("phone", idCliente.getTelefone()).setMaxResults(1).getSingleResult());
		
		System.out.println("Frequência de visitas: " +  em.createQuery("SELECT COUNT(DISTINCT(cm.dataComanda)) FROM Comanda cm WHERE cm.cliente = :idCliente").setParameter("idCliente", idCliente).getSingleResult()); 
		
		Double ticketMedio = em.createQuery("SELECT AVG(cm.valorTotal) FROM Comanda cm INNER JOIN Cliente c ON c.id = cm.cliente WHERE c.telefone = :phone", Double.class)
				.setParameter("phone", idCliente.getTelefone()).getSingleResult();
		
		System.out.printf("Ticket médio: R$%.2f\n", ticketMedio );
		
		System.out.println("Bebidas e Estilos favoritos:\n[1] Cerveja Pilsen \n[2] Chopp Trigo \n[3] Vinho Tinto "); // Todo

	}

}
