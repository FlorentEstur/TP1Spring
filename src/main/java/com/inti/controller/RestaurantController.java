package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Restaurant;
import com.inti.services.IRestaurantRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("restaurant")
@Slf4j
public class RestaurantController {

	@Autowired
	IRestaurantRepository irr;
	
	@GetMapping("allRestaurants")
	public List<Restaurant> getAllRestaurants()
	{
		log.info("Liste des restaurants");
		return irr.findAll();
	}
	
	@GetMapping("getRestaurant/{numero}")
	public Restaurant getRestaurant(@PathVariable int numero)
	{
		int numMax = irr.findMaxId();
		if (numero > 0 && numero <= numMax)
		{
			log.info("Le restaurant "+numero);
			return irr.findById(numero).get();
		}
		log.error("aucune resturant trouvé");
		return null;
	}
	
	@PostMapping("saveRestaurant")
	public boolean saveRestaurant(@RequestBody Restaurant restaurant)
	{
		if (restaurant!=null)
		{
			log.info("le restaurant a bien été sauvegardé");
			irr.save(restaurant);
			return true;
		}
		log.error("le restaurant n'a pas pu être sauvegardé");
		return false;
	}
	
	@DeleteMapping("deleteRestaurant/{numero}")
	public boolean deleteRestaurant(@PathVariable int numero)
	{
		int idMax = irr.findMaxId();
		if (numero > 0 && numero<=idMax)
		{
			log.info("Le restaurant a bien été supprimé");
			irr.deleteById(numero);
			return true;
		}
		log.error("Le Restaurant n'a pas pu être supprimé");
		return false;
	}
	
	@PutMapping("updateEtu/{id}")
	public Restaurant updateRestaurant(@RequestBody Restaurant newRestaurant, @PathVariable int numero)
	{
		return irr.findById(numero).map(restaurant ->{
			restaurant.setTelephone(newRestaurant.getTelephone());
			return irr.save(restaurant);
		}).orElseGet(() ->{
			return irr.save(newRestaurant);
		});
	}
}
