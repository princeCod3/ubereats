package org.reverside.bootcamp.ubereats.controller;

import java.util.List;

import org.reverside.bootcamp.ubereats.dto.Product;
import org.reverside.bootcamp.ubereats.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * This controller returns data in the form of JSON 
 * Use POSTMAN for testing
 * */

@Controller
@RequestMapping ("/json/data")
public class JsonDataController {
	
	//This is where we get the data
	@Autowired
	private ProductDAO productDAO;

	
	
	// Fetches all products from database and returns a JSON List
	@RequestMapping("/active/products")
	@ResponseBody //we just need JSON not ModelAndView
	public List<Product> getAllProducts(){
		
		return productDAO.listActiveProducts();
	
	}
	
	// Fetches all products from database and returns a JSON List
	@RequestMapping("/category/{id}/products")
	@ResponseBody //we just need JSON not ModelAndView
	public List<Product> getProductsByCategory(@PathVariable int category_id){
		
		return productDAO.listActiveProductsByCategory(category_id);
	
	}
}
