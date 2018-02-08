package com.my.demo.Dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import com.my.demo.Pojo.Country;

@Component
public class CountryDao 
{
	/*@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public Country find(int id)
	{
		System.out.println("inside dao");
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = null;
		Country country = new Country();
		try {
			transaction = session.beginTransaction();
		
			country = (Country) session.createQuery("from Country where id = :id").setInteger(id, id).uniqueResult();
			System.out.println("inside try" + country);
		} catch (Exception e) {
			if(transaction != null)
				transaction.rollback();
		}
		return country;
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Country> findAllCountries()
	{
		System.out.println("inside dao findAllCountries");
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = null;
		List<Country> countries = new ArrayList<>();
		try {
			transaction = session.beginTransaction();
		
			countries = session.createQuery("from Country ").list();
			System.out.println("inside try" + countries);
		} catch (Exception e) {
			if(transaction != null)
				transaction.rollback();
		}
		return countries;
	}*/
	
	@PersistenceContext
	EntityManager entitymanager;
	
	@Transactional
	public Country findAllStateWhereCountryId(int id)
	{
		System.out.println("inside dao");
		
		Country country = new Country();
		
		country = (Country) entitymanager.createQuery("from Country c where c.id = :id").setParameter("id", id).getSingleResult();	
		System.out.println("inside " + country);
		
		return country;
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Country> findAllCountries()
	{
		System.out.println("inside dao findAllCountries");
		
		List<Country> countries = new ArrayList<>();
		countries = entitymanager.createQuery("from Country ").getResultList();
		System.out.println("inside try" + countries);
		
		return countries;
	}
}
