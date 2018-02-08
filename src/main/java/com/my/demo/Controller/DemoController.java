package com.my.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.GsonBuilder;
import com.my.demo.Dao.CityDao;
import com.my.demo.Dao.CountryDao;
import com.my.demo.Dao.StateDao;
import com.my.demo.Pojo.Country;
import com.my.demo.Pojo.State;
import com.my.demo.Service.CountryService;
import com.my.demo.Service.StateService;

@Controller
public class DemoController 
{
	@Autowired
	CountryService service;
	@Autowired
	StateService stateService;
	@Autowired
	CountryDao countryDao;
	@Autowired
	StateDao statedao;
	@Autowired
	CityDao citydao;
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public String index(Model map )
	{
		map.addAttribute("listAllCountry",countryDao.findAllCountries());
		return "index";
	}
	
	@RequestMapping(value="listAllCountry" , method=RequestMethod.GET)
	public void listAllCountry()
	{
		System.out.println(service.listAllCountry());
	}
	
	@RequestMapping("listAllState")
	public void listAllState()
	{
		List<State> list = new ArrayList<State>();
		list = stateService.listAllState();
		System.out.println(list);
		System.out.println(service.listAllCountry());
	}
	
	@RequestMapping(value="loadState/{id}" , method= RequestMethod.GET)
	@ResponseBody
	public String loadState(@PathVariable("id") int id)
	{
		Country country = new Country();
		country = (Country) countryDao.findAllStateWhereCountryId(id);
		return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create().toJson(country.getStates());
		
	}
	

	@RequestMapping(value="loadCities/{id}" , method= RequestMethod.GET  )
	@ResponseBody
	public String loadCities(@PathVariable("id") int id)
	{
		return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create().toJson(statedao.findAllStateWhereStateId(id).getCities());
		
	}
	
}
