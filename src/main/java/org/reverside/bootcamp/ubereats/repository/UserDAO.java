package org.reverside.bootcamp.ubereats.repository;

import java.util.List;

import org.reverside.bootcamp.ubereats.dto.Cart;
import org.reverside.bootcamp.ubereats.dto.User;

public interface UserDAO {
	
	User findByEmail(String email);
	
	//CRUD operations
	boolean addUser(User user);
	boolean updateUser(User user);
	boolean deleteUser(User user);
	boolean deactivateUser(User user);
	
	//Listing users for Admin activities
	User listUserByRole(String role);
	List<User> listAllActiveUsers();
	
	//Each User has One Cart
	boolean addCart(Cart cart);

	

}
