package org.reverside.bootcamp.ubereats.controller;

import java.util.List;

import org.reverside.bootcamp.ubereats.dto.User;
import org.reverside.bootcamp.ubereats.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/users")
	public List<User> listAllActiveUsers(){
		return userDAO.listAllActiveUsers();
	}
	
	
	

}
