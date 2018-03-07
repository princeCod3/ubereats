package org.reverside.bootcamp.ubereats.repositoryImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.reverside.bootcamp.ubereats.dto.Account;
import org.reverside.bootcamp.ubereats.dto.FoodOutlet;
import org.reverside.bootcamp.ubereats.dto.Menu;
import org.reverside.bootcamp.ubereats.repository.FoodOutletDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("foodOutletDAO")
@Transactional
public class FoodOutletDaoImpl implements FoodOutletDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public FoodOutlet findByEmail(String email) {
	
	String findByEmail = ("FROM FoodOutlet WHERE email = :email");
		try {
		return sessionFactory
				.getCurrentSession()
				.createQuery(findByEmail,FoodOutlet.class)
				.setParameter("email", email)
				.getSingleResult();
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addFoodOutlet(FoodOutlet foodOutlet) {
		
	try {
			
			sessionFactory.getCurrentSession().persist(foodOutlet);
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;	
		}
	}

	@Override
	public boolean updateFoodOutlet(FoodOutlet foodOutlet) {
		
	try {
			
			sessionFactory.getCurrentSession().update(foodOutlet);
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;	
		}
	}

	@Override
	public boolean deleteFoodOutlet(FoodOutlet foodOutlet) {
		
try {
			
			sessionFactory.getCurrentSession().delete(foodOutlet);
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;	
		}
	}

	@Override
	public boolean deactivateFoodOutlet(FoodOutlet foodOutlet) {
		
		foodOutlet.setActive(false);
		
try {
			
			sessionFactory.getCurrentSession().update(foodOutlet);
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;	
		}
	}

	@Override
	public List<FoodOutlet> listActiveFoodOutlets() {
	
	String listAllActiveFoodOutlets = ("FROM FoodOutlet WHERE active = :active");
		
		return sessionFactory
				.getCurrentSession()
				.createQuery(listAllActiveFoodOutlets, FoodOutlet.class)
				.setParameter("active", true)
				.getResultList();
	}

	@Override
	public boolean updateMenu(Menu menu) {
		
	try {
			
			sessionFactory.getCurrentSession().update(menu);
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;	
		}
	}

	@Override
	public boolean updateAccount(Account account) {
		
	try {
			
			sessionFactory.getCurrentSession().update(account);
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;	
		}
	}

	@Override
	public boolean createAccount(Account account) {
	
       try {
			
			sessionFactory.getCurrentSession().persist(account);
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;	
		}
	}
	
	

}
