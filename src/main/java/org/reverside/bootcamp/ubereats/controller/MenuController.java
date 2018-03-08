package org.reverside.bootcamp.ubereats.controller;

import java.util.List;

import org.reverside.bootcamp.ubereats.dto.FoodOutlet;
import org.reverside.bootcamp.ubereats.repository.FoodOutletDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/restaurants")
public class MenuController {

	@Autowired
	private FoodOutletDAO foodOutletDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<FoodOutlet> getAllFoodOutlets() {
		
		return foodOutletDAO.listActiveFoodOutlets();
	}
	
	@GetMapping("/menu/{cuisineType}")
	public List<FoodOutlet> getAllFoodOutletsByCategory(@PathVariable String cuisineType) {
		
		return foodOutletDAO.listActiveFoodOutletsByCategory(cuisineType);
	}
}
