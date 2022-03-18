package br.com.oak.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.oak.domain.Cliente;

public class EnjoyTests {

	public static void main(String[] args) {
		
		EntityManager em = Persistence.createEntityManagerFactory("onboarding").createEntityManager();
		String[] phones = {"3333333","4444444"};
//		String telefoneCliente = phones[(int)Math.random()* 2];
		String telefoneCliente = "4444444";
		System.out.println("==================== Enjoy ===================="
							+"\nBoas vindas ao nosso estabelecimento!"
							+"\nTelefone do cliente para Onboarding: " + telefoneCliente
							+"\n================= Informações =================");
		
		
//		em.getTransaction().begin();
//		em.persist(cliente);
//		em.persist(pedido);
//		em.getTransaction().commit();
		
		Cliente idCliente = new Cliente();
		
		idCliente = (Cliente) em.createQuery("FROM Cliente where telefone = :phone").setParameter("phone", telefoneCliente).getSingleResult();
		System.out.println("ID" + idCliente.getId());
		
		System.out.println("Cliente " + idCliente.getNome() );
		
		System.out.println("Data da última visita: " 
		+ em.createQuery("SELECT p.dataPedido FROM Pedido p INNER JOIN Cliente c ON c.id = :id  WHERE c.telefone = :phone ORDER BY p.dataPedido DESC")
		.setParameter("id",idCliente.getId()).setParameter("phone", telefoneCliente).setMaxResults(1).getSingleResult());
		
		System.out.println("Frequência de visitas: "); // Todo
		System.out.println("Ticket médio: R$45.72"); // Todo
		System.out.println("Bebidas e Estilos favoritos:\n[1] Cerveja Pilsen \n[2] Chopp Trigo \n[3] Vinho Tinto "); // Todo
	}
	

}
