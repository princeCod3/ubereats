package org.reverside.bootcamp.ubereats.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.reverside.bootcamp.ubereats.dto.Product;
import org.reverside.bootcamp.ubereats.repository.ProductDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductTestCase {

	
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		
		context.scan("org.reverside.bootcamp.ubereats");
		context.refresh();
		// Typecasting is used here because method returns object
		
		productDAO = (ProductDAO)context.getBean("productDAO");
		
		
	}
	
	
	@Test
	public void TestCRUDProduct() {
		
		product = new Product();
		
		product.setName("JUNIT");
		product.setDescription("Test Case for Product add() method");
		product.setUnitPrice(358.00);
		
		assertEquals("ERROR while adding category inside table",true,productDAO.add(product));
	}
	
	
}
