package com.my.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.demo.Pojo.Country;
import com.my.demo.Repository.CountryRepository;

@Service
public class CountryService 
{
	@Autowired
	CountryRepository countryRepository;
	
	public List<Country> listAllCountry() 
	{
		return (List<Country>) countryRepository.findAll();
	}
}
