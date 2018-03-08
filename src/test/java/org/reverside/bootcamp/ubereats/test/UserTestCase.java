/*package org.reverside.bootcamp.ubereats.test;

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
		user.setRole("USER");
		
		
		
		if (user.getRole().equals("USER") ) {
		//add a cart
		cart = new Cart();
		cart.setUserId(user.getEmail());
		cart.setUser(user);
		// attach cart to a user
		user.setCart(cart);
		}
		assertEquals("Something went wrong while adding a new User",true, userDAO.addUser(user));
		
		
	}
	
	@Test
	public void testUpdateCart() {
		//fetch user by its email
		user = userDAO.findByEmail("prince@gmail.com");
		//fetch user's cart
		cart = user.getCart();
		
		cart.setTotal(789.00);
		
		cart.setCartLines(2);
		
		assertEquals("Failed to update cart",true,userDAO.updateCart(cart));
	}
}
*/