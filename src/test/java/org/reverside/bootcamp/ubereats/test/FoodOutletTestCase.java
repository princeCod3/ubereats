/*package org.reverside.bootcamp.ubereats.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.reverside.bootcamp.ubereats.dto.Account;
import org.reverside.bootcamp.ubereats.dto.FoodOutlet;
import org.reverside.bootcamp.ubereats.dto.Menu;
import org.reverside.bootcamp.ubereats.repository.FoodOutletDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FoodOutletTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static FoodOutletDAO foodOutletDAO;
	
	private FoodOutlet foodOutlet = null;
	private Menu menu = null;
	private Account account = null;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		
		context.scan("org.reverside.bootcamp.ubereats");
		context.refresh();
		// Typecasting is used here because method returns object
		
		foodOutletDAO = (FoodOutletDAO)context.getBean("foodOutletDAO");
		
		
	}
	
	@Test
	public void testAdd() {
		
		foodOutlet = new FoodOutlet();
		
		foodOutlet.setName("Mr Adam");
		foodOutlet.setEmail("roccomama@gmail.com");
		foodOutlet.setBusinessName("Rocco Mama's");
		foodOutlet.setBusinessAddress("42 Jan Smuts Dr, Parktown, 1090");
		foodOutlet.setCuisineType("American");
		foodOutlet.setNumberOfLocations(3);
		foodOutlet.setAptSuit("B42");
		
		
		//Each Restaurant has a menu
		
		menu = new Menu();
		
		menu.setName(foodOutlet.getCuisineType());
	    menu.setFoodOutlet(foodOutlet);
	    foodOutlet.setMenu(menu);
	    
	    assertEquals("Failed to add new FoodOutlet!",true,foodOutletDAO.addFoodOutlet(foodOutlet));
		
	}
	
	
	@Test
	public void TestUpdateMenu() {
		
		foodOutlet = foodOutletDAO.findByEmail("roccomama@gmail.com");
		
		menu = foodOutlet.getMenu();
		
		menu.setImage_url("/img/american.jpg");
		
		menu.setDescription("Get the best of American food");
		
		assertEquals("failed to update menu",true,foodOutletDAO.updateMenu(menu));
	}

	@Test
	public void TestCreateAccount() {
		
		foodOutlet = foodOutletDAO.findByEmail("roccomama@gmail.com");
		
		account = new Account();
		
		account.setAccount_id(foodOutlet.getEmail());
		account.setAccountHolder("Mr Adam");
		account.setAccountNum(123456);
		account.setCardNumber(1005678);
		account.setCvc(879);
		account.setExpDate("09/19");
		account.setPaymentMethod("Paypal");
		
		assertEquals("failed to create account",true,foodOutletDAO.createAccount(account));
        
		
	}
	
}
*/