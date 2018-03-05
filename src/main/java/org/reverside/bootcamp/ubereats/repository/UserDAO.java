package org.reverside.bootcamp.ubereats.repository;

import java.util.List;
import java.util.Set;

import org.reverside.bootcamp.ubereats.dto.Role;
import org.reverside.bootcamp.ubereats.dto.User;

public interface UserDAO {
	
	User findByEmail(String email);
	
	//CRUD operations
	boolean addUser(User user);
	boolean updateUser(User user);
	boolean deleteUser(User user);
	boolean deactivateUser(User user);
	
	//Listing users for Admin activities
	List<User> listUserByRole(Set<Role> role);
	List<User> listAllActiveUsers();

}
