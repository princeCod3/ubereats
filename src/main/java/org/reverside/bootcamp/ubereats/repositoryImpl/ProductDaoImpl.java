package org.reverside.bootcamp.ubereats.repositoryImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.reverside.bootcamp.ubereats.dto.Product;
import org.reverside.bootcamp.ubereats.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("productDAO")
@Transactional
public class ProductDaoImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
   
	//get a sing product
	@Override
	public Product get(int productId) {
		
		try {
			
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
					
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return null;
	}
	
	//all products
	@Override
	public List<Product> list(){
	
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product",Product.class)
				.getResultList();	
	}
	
	//only active products
	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts =("FROM Product WHERE active = :active");

		return sessionFactory
				.getCurrentSession()
				.createQuery(selectActiveProducts,Product.class)
				.setParameter("active", true)
				.getResultList();
				
				
	}

	@Override
	public List<Product> listActiveProductsByCategory(int category_id) {
	
		String selectActiveProductsByCategory =("FROM Product WHERE active = :active AND categoryId = :categoryId");

		return sessionFactory
				.getCurrentSession()
				.createQuery(selectActiveProductsByCategory,Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", true)
				.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		
		 	return sessionFactory.getCurrentSession()
				.createQuery("FROM Product WHERE active = :active ORDER BY id",Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByMenu(int menu_id) {
		
		
		String selectActiveProductsByMenu =("FROM Product WHERE active = :active AND menuId = :menuId");
     
		return sessionFactory
				.getCurrentSession()
				.createQuery(selectActiveProductsByMenu,Product.class)
				.setParameter("active", true)
				.setParameter("menuId", true)
				.getResultList();
     
	}

	@Override
	public boolean add(Product product) {
		
      try {
			
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
			return false;
			
		}
		
		
	}

	@Override
	public boolean update(Product product) {
		
    try {
			
			sessionFactory.getCurrentSession().update(product);
			
			return true;
		}
		catch(Exception e){
			
			e.printStackTrace();
			
			return false;
		}	
		
	
	}

	// WARNING!! Deletes product  permanently!!!
	@Override
	public boolean delete(Product product) {
		
		  try {
				
				sessionFactory.getCurrentSession().delete(product);
				
				return true;
			}
			catch(Exception e){
				
				e.printStackTrace();
				
				return false;
			}	
			
	}
	@Override
	public boolean deactivate(Product product) {
		
		//deactivate product
		product.setActive(false);
		  
		try {
				
				sessionFactory.getCurrentSession().update(product);
				
				return true;
			}
			catch(Exception e){
				
				e.printStackTrace();
				
				return false;
			}
		

	}

}
