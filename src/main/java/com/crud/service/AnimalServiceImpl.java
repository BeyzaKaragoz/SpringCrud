package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dao.AnimalDao;
import com.crud.dto.Animal;



@Service
public class AnimalServiceImpl implements AnimalService {

	AnimalDao animalDao;

	@Autowired
	public void setAnimalDao(AnimalDao animalDao) {
		this.animalDao = animalDao;
	}

	public List<Animal> getlistOfAnimals() {
		return animalDao.getlistOfAnimals();
	}

	public void addAnimal(Animal a) {
		animalDao.addAnimal(a);
	}

	public void updateAnimal(Animal a) {
		animalDao.updateAnimal(a);
	}

	public void deleteAnimal(String animalName) {
		animalDao.deleteAnimal(animalName);
	}
	public Animal findAnimal(String animalName) {
		
		return animalDao.findAnimal(animalName);
	}

	
}