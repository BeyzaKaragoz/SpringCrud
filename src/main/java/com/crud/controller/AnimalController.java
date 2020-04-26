package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.crud.dto.Animal;
import com.crud.service.AnimalService;

@Controller
@RequestMapping(value = "/animals")
public class AnimalController {
	@Autowired
	AnimalService aService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAnimal() {
		ModelAndView mvc = new ModelAndView("pages/aniPage");
		List<Animal> list = aService.getlistOfAnimals();
		mvc.addObject("listAnimals", list);
		return mvc;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("pages/animal_form");
		Animal a = new Animal();
		model.addObject("animalForm",a);
		return model;
	}

	@RequestMapping(value = "/update/{animalname}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("animalname") String animalname) {
		ModelAndView model = new ModelAndView("pages/animal_form");
		Animal a = aService.findAnimal(animalname);
		model.addObject("animalForm", a);
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("animalForm") Animal a) {
		if (a != null && a.getAnimalid() == 0) {
			aService.addAnimal(a);
		} else {
			aService.updateAnimal(a);
		}
		return new ModelAndView("redirect:/animals/list");
	}

	@RequestMapping(value = "/delete/{animalname}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("animalname") String a) {
		aService.deleteAnimal(a);
		return new ModelAndView("redirect:/animals/list");
	}
}