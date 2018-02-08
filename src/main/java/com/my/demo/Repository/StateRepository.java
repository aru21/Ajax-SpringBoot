package com.my.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.my.demo.Pojo.State;


@Repository
public interface StateRepository extends CrudRepository<State	, Integer>
{

	
}
