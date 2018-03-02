package org.reverside.bootcamp.ubereats.repositoryImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.reverside.bootcamp.ubereats.dto.Category;
import org.reverside.bootcamp.ubereats.repository.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("categoryDAO")
@Transactional
public class CategoryDaoImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
   /*******************************************	
    private static List<Category> categories = new ArrayList<>();
	
	//Category declarations 
	static {
		 Category category = new Category();
		 
		//first category definition
		category.setId(1);
		category.setName("TestName");
		category.setDescription("TestDescription // I am using JUNIT to test this");
		
		categories.add(category);
		
		
	}
	************************************************/

	@Override
	
	public boolean addCategory(Category category) {
	
		try {
			
			//add category to the database
			
			sessionFactory.getCurrentSession().persist(category);
			
			return true;
		}
		catch(Exception e){
			
			e.printStackTrace();
			
			return false;
		}
	
	}

	@Override
	public List<Category> list() {
		
		/*we are using HQL( Hibernate Query Language)
		 Category is NOT table name but Entity name!!
		 */
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		/*Query is from Hibernate Query Interface
		since we are choosing only those categories that are active 
		*/
		
		return   sessionFactory
				.getCurrentSession()
				.createQuery(selectActiveCategory,Category.class)
				.setParameter("active", true)
				.getResultList();
	
	
	}
     //getting a single category based on id
	@Override
	public Category get(int id) {
		// the id is a unique identifier of class, method requires reference type (not primitive) hence we use (Integer) not (int)
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}
    
	//updating a single category
	@Override
	public boolean updateCategory(Category category) {
		
		
	try {
			
			//update category from the database
			
			sessionFactory.getCurrentSession().update(category);
			
			return true;
		}
		catch(Exception e){
			
			e.printStackTrace();
			
			return false;
		}

	}
    //deleting a single category
	@Override
	public boolean deleteCategory(Category category) {
		 
		// NB, I am deactivating a category not removing it from database
		category.setActive(false);
		
		try {
				
				//We need to update the IS_ACTIVE column category to the database
				
				sessionFactory.getCurrentSession().update(category);
				
				return true;
			}
			catch(Exception e){
				
				e.printStackTrace();
				
				return false;
			}
	}

}
