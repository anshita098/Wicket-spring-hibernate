package com.github.anirudhvarma12.whs;

import org.springframework.stereotype.Component;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;


/**
 * @author Anirudh Varma
 * @Date May 4, 2015
 */

@Component
public class SpringInterfaceImpl implements SpringInterface{

	
    @Override
    public String getString() {
        return "Hello";
    }
    
    public List<Bank> getlist(){
    	
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistence");
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	entityManager.getTransaction().begin();
    	String sql = "select u from Bank u";
		List<Bank> userDetails = entityManager.createQuery(sql, Bank.class).getResultList();
    	entityManager.getTransaction().commit();
    	entityManager.close();
    	return userDetails;
    }

    
}
