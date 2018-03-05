package org.reverside.bootcamp.ubereats.controller;

import org.reverside.bootcamp.ubereats.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	
	

}
