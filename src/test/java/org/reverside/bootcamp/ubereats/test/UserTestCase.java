package org.reverside.bootcamp.ubereats.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.reverside.bootcamp.ubereats.dto.Cart;
import org.reverside.bootcamp.ubereats.dto.User;
import org.reverside.bootcamp.ubereats.repository.UserDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static UserDAO userDAO;
	
	private User user = null;
	private Cart cart = null;
	

	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		
		context.scan("org.reverside.bootcamp.ubereats");
		context.refresh();
		// Typecasting is used here because method returns object
		
		userDAO = (UserDAO)context.getBean("userDAO");
		
		
	}
	
	
	@Test
	public void testAdd() {
		
		//add a user
		user = new User();
		
		user.setName("Prince");
		user.setEmail("prince@gmail.com");
		user.setSurname("Mathebula");
		user.setPhoneNum("1234567890");
		user.setPassword("testcase123");
		user.setRecoveryQuestion("Test Case 123?");
		user.setAccount_id(1);
		user.setRole("CUSTOMER");
		
		assertEquals("Something went wrong while adding a new User",true, userDAO.addUser(user));
		
		//add a cart
		cart = new Cart();
		cart.setUserId("prince@gmail.com");
		
		assertEquals("Something went wrong while adding a new cart",true, userDAO.addCart(cart));
		
		
	}
}
