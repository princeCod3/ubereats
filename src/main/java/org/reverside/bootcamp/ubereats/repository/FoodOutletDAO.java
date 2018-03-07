package org.reverside.bootcamp.ubereats.repository;

import java.util.List;

import org.reverside.bootcamp.ubereats.dto.Account;
import org.reverside.bootcamp.ubereats.dto.FoodOutlet;
import org.reverside.bootcamp.ubereats.dto.Menu;

public interface FoodOutletDAO {

	FoodOutlet findByEmail(String email);
	
	//CRUD Operations
	
	boolean addFoodOutlet(FoodOutlet foodOutlet);
	boolean updateFoodOutlet(FoodOutlet foodOutlet);
	boolean deleteFoodOutlet(FoodOutlet foodOutlet);
	boolean deactivateFoodOutlet(FoodOutlet foodOutlet);
	
	//Lists
	List<FoodOutlet> listActiveFoodOutlets();
	
	//Each FoodOutlet has a Menu
	boolean updateMenu(Menu menu);
	
	//Each FoodOulet has an account
	boolean createAccount(Account account);
	boolean updateAccount(Account account);

	

	
	
}