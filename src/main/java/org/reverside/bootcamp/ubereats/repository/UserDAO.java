package org.reverside.bootcamp.ubereats.repository;

import org.reverside.bootcamp.ubereats.dto.User;

public interface UserDAO {
	
	
	Boolean addUser(User user);
	User findByEmail(String email);
	boolean updateUser(User user);
	boolean deleteUser(User user);
	boolean deactivateUser(User user);

}
