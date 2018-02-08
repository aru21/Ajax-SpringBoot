package com.my.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.demo.Pojo.State;
import com.my.demo.Repository.StateRepository;

@Service
public class StateService 
{
	@Autowired
	StateRepository stateRepository;
	
	public List<State> listAllState() 
	{
		return (List<State>) stateRepository.findAll();
	}
}
