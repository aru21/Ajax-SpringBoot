package com.my.demo.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import com.my.demo.Pojo.State;

@Component

public class StateDao {
	
		@PersistenceContext
		EntityManager entitymanager;
		
		@Transactional
		public State find(int id)
		{
			System.out.println("inside state dao");
			
			
			
			State state = (State) entitymanager.createQuery("from State c where c.id = :id").setParameter("id", id).getSingleResult();
			System.out.println("inside try" + state);
			
			return state;
		}
		
		
		@Transactional
		public State findAllStateWhereStateId(int id)
		{
			System.out.println("inside dao findAllCountries");
			State state = (State) entitymanager.createQuery("from State s where s.id = :id ").setParameter("id", id).getSingleResult();
			System.out.println("inside try" + state);
			
			return state;
		}
	}

	

