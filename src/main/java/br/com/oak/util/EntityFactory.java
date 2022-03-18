package br.com.oak.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityFactory {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("onboarding");

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

}