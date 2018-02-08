package com.my.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.my.demo.Pojo.Country;


@Repository
public interface CountryRepository extends CrudRepository<Country	, Integer>
{

	
}
