package com.ar.com23315.Models;

public class ArticuloDTO {
	
	private int id;
	private String name;
	private String breed;
	
	
	public ArticuloDTO(int id, String name, String breed) {

		this.id = id;
		this.name = name;
		this.breed = breed;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBreed() {
		return breed;
	}


	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return this.name + "-" + this.breed;
	}
	
	
	
}
