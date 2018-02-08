
package com.my.demo.Pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="State")
public class State 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Expose
	public  int id;
	
	@NotNull
	@Size(min=3 , max=10 , message="Please enter at least 3 character name and less than 10 ")
	@Expose
	public String name;
	
	
	@OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
	
	private Set<City> cities = new HashSet<>();
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "countryId")
	
	private Country country;
	
	
	public State() 
	{	}
	
	public State(String name) 
	{	
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + "]";
	}
	
	public void addCity(City city) 
	{
		this.cities.add(city);
	}
	
}
