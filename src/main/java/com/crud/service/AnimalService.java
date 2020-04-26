package com.crud.service;

import java.util.List;

import com.crud.dto.Animal;

public interface AnimalService {
	public List<Animal> getlistOfAnimals();

	public void addAnimal(Animal a);

	public void updateAnimal(Animal a);

	public void deleteAnimal(String animalName);

	public Animal findAnimal(String animalName);
}