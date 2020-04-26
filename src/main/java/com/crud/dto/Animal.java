package com.crud.dto;

public class Animal {
	private String type,name,color;
	private int animalid;

	public Animal() {
		super();
	}

	public Animal(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAnimalid() {
		return animalid;
	}

	public void setAnimalid(int animalid) {
		this.animalid = animalid;
	}

}