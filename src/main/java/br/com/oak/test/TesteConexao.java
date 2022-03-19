package br.com.oak.test;

import javax.persistence.Persistence;

public class TesteConexao {
	
	public static void main(String[] args) {
		
        Persistence.createEntityManagerFactory("onboarding").createEntityManager();
        
	}

}
