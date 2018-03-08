package org.reverside.bootcamp.ubereats.repository;

import java.util.List;

import org.reverside.bootcamp.ubereats.dto.Product;

public interface ProductDAO {
	 
	Product get(int productId);
	
	List<Product> list();
	
	//CRUD
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	// temporal delete from display
	boolean deactivate(Product product);
	
	
	//Business Methods
	List<Product> listActiveProducts();
	/*List<Product> listActiveProductsByCategory(int category_id);*/
	List<Product> getLatestActiveProducts(int count);
	List<Product> listActiveProductsByMenu(int menu_id);

}
