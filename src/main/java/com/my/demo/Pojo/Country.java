package com.my.demo.Pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="Country")
public class Country 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Expose
	public  int id;
	
	@NotNull
	@Size(min=3 , max=10 , message="Please enter at least 3 character name and less than 10 ")
	@Expose
	private String name;
	
	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
	@Expose
	private Set<State> states = new HashSet<>();
	
	
	public Country() 
	{	}
	
	public Country(String name) 
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

	
	public Set<State> getStates() {
		return states;
	}

	public void setStates(Set<State> states) {
		this.states = states;
	}

	
	
	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", states=" + states + "]";
	}

	public void addState(State state)
	{
		this.states.add(state);
	}
	
}
