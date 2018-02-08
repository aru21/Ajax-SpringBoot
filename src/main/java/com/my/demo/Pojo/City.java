package com.my.demo.Pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="City")
public class City 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Expose
	private int id;
	
	@NotNull
	@Size(min=3 , max=10 , message="Please enter at least 3 character name and less than 10 ")
	@Expose
	private String name;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "stateId")
	private State state;
	
	
	public City() 
	{	}
	
	public City(String name) 
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
	

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + "]";
	}
	
	
	
}