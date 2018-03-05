package org.reverside.bootcamp.ubereats.repositoryImpl;

import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.reverside.bootcamp.ubereats.dto.Role;
import org.reverside.bootcamp.ubereats.dto.User;
import org.reverside.bootcamp.ubereats.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDAO")
@Transactional
public class UserDaoImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//find User by email
	@Override
	public User findByEmail(String email) {
		
		String findByEmail = ("FROM User WHERE email = :email");
		
		return sessionFactory
				.getCurrentSession()
				.createQuery(findByEmail,User.class)
				.setParameter("email", true)
				.getSingleResult();
			
	}
	
	//listing users

	@Override
	public List<User> listUserByRole(Set<Role> role) {
		
		return null;
	}
	
	@Override
	public List<User> listAllActiveUsers() {
		String listAllActiveUsers = ("FROM User WHERE active = :active");
		
		return sessionFactory
				.getCurrentSession()
				.createQuery(listAllActiveUsers, User.class)
				.setParameter("active", true)
				.getResultList();
	}
	
    //add user
	@Override
	public boolean addUser(User user) {
		try {
			
			sessionFactory.getCurrentSession().persist(user);
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;	
		}
		
	}
     
	//Update a user
	@Override
	public boolean updateUser(User user) {
		try {
			
			sessionFactory.getCurrentSession().update(user);
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;	
		}
		
		
	}

	//Delete a User
	@Override
	public boolean deleteUser(User user) {
	try {
			
			sessionFactory.getCurrentSession().delete(user);
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;	
		}
	}

	//deactivate a user
	@Override
	public boolean deactivateUser(User user) {
		
		user.setActive(false);
		
	try {
			
			sessionFactory.getCurrentSession().update(user);
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;	
		}
	}

	


}
