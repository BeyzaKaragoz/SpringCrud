package com.crud.dao;

import java.util.List;

import com.crud.dto.Animal;

public interface AnimalDao {
	public List<Animal> getlistOfAnimals();
	public void addAnimal(Animal a);
	public void updateAnimal(Animal a);
	public void deleteAnimal(String animalName);
	

	public Animal findAnimal(String animalName);
}