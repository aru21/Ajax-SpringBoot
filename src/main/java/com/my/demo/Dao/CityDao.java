package com.my.demo.Dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import com.my.demo.Pojo.City;
import com.my.demo.Pojo.Country;

@Component
	
public class CityDao {

		@PersistenceContext
		EntityManager entitymanager;
		
		@Transactional
		public Country find(int id)
		{
			System.out.println("inside dao");
			
			Country country = new Country();
			
			country = (Country) entitymanager.createQuery("from City c where c.id = :id").setParameter("id", id).getSingleResult();	
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
		
		@SuppressWarnings("unchecked")
		@Transactional
		public List<City> findAllCities(int id)
		{
			System.out.println("inside dao findAllCities");
			
			List<City> cities = new ArrayList<>();
			cities = entitymanager.createQuery("from City c where c.state_id = :id ").setParameter("id" ,  id).getResultList();
			System.out.println("inside try" + cities);
			return cities;
		}
	}

	
