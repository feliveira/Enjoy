package br.com.oak.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EnjoyTests {

	public static void main(String[] args) {
		
//		EntityManager em = Persistence.createEntityManagerFactory("onboarding").createEntityManager();
		String[] phones = {"11999999999","11888888888","11777777777"};
		
		String[] names = {"Jorge","Tatiana","Dagoberto","Priscila"}; // Provisorio
		
		System.out.println("==================== Enjoy ===================="
							+"\nBoas vindas ao nosso estabelecimento!"
							+"\nTelefone do cliente para Onboarding: " + phones[(int)(Math.random() * 3)]
							+"\n================= Informações =================");
		
		System.out.println("Cliente " + names[(int)(Math.random() * 4)] );
		System.out.println("Data da última visita: dd/mm/yyyy "); // Todo
		System.out.println("Frequência de visitas: X visitas no último mês "); // Todo
		System.out.println("Ticket médio: R$45.72"); // Todo
		System.out.println("Bebidas e Estilos favoritos:\n[1] Cerveja Pilsen \n[2] Chopp Trigo \n[3] Vinho Tinto "); // Todo
	}

}
