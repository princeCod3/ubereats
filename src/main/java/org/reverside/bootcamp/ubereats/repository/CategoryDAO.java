package org.reverside.bootcamp.ubereats.repository;

import java.util.List;

import org.reverside.bootcamp.ubereats.dto.Category;

public interface CategoryDAO {

	
	Category get(int id);
	
	List<Category> list();
	
	//CRUD operations
	 boolean addCategory(Category category);
	 boolean updateCategory(Category category);
	 boolean deleteCategory(Category category);
}
