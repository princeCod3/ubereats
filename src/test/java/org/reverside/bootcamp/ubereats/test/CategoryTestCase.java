package org.reverside.bootcamp.ubereats.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.reverside.bootcamp.ubereats.dto.Category;
import org.reverside.bootcamp.ubereats.repository.CategoryDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		
		context.scan("org.reverside.bootcamp.ubereats");
		context.refresh();
		// Typecasting is used here because method returns object
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
		
	}
  
	
/*	@Test 
    public void TestAddCategory( ) {
		
     	category = new Category();
		//testing a static input
		category.setName("TestName");
		category.setDescription("TestDescription // I am using JUNIT to test this");
		
		assertEquals("Successfully added category inside table",true,categoryDAO.addCategory(category));
		
	
	}*/ 

	
/*  @Test
	public void TestGetCategory() {
		
		category = categoryDAO.get(2);
		assertEquals("Successfully fetched a single category based on id","Test2",category.getName());
		
	}
	*/
	/*@Test
	public void TestUpdateCategory() {
		
		category = categoryDAO.get(2);
		//updates
		category.setName("UpdatedTest");
		category.setDescription("JUnit update test completed!!");
		
		assertEquals("Successfully updated a single category based on id",true,categoryDAO.updateCategory(category));
		
	}*/
	
	/*@Test
	public void TestDeleteCategory() {
		//Deleting a single category
		category = categoryDAO.get(3);
		assertEquals("Successfully deleted a single category based on id",true,categoryDAO.deleteCategory(category));	
	}*/
	
	/*@Test
	public void TestListCategories() {
		
		//fetches a list of active categories, I only have 2 thus far hence we compare against 2
		assertEquals("Successfully fetched a list of active categories",2,categoryDAO.list().size());
		
	}*/
	
	@Test
	public void TestCRUDCategory() {
		
		//add new category
		category = new Category();
				
		category.setName("CRUD");
		category.setDescription("JUnit CRUD test");
		assertEquals("ERROR while adding category inside table",true,categoryDAO.addCategory(category));
		
		//update a category
		category = categoryDAO.get(2);
		category.setName("UpdatedTestCRUD");
		category.setDescription("JUnit CRUD update test completed!!");
		assertEquals("ERROR while updating a single category based on id",true,categoryDAO.updateCategory(category));
		
		//delete category
		category = categoryDAO.get(2);
		
		assertEquals("ERROR while deleting a single  category",true,categoryDAO.deleteCategory(category));
		
		//get list
		assertEquals("ERROR while fetching a list of active categories",2,categoryDAO.list().size());
	}
}
