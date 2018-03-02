package org.reverside.bootcamp.ubereats.dto;

import javax.persistence.Entity;



@Entity
public class Customer extends User {
	
	//private fields
	private int account_num;
    
	//constructors

	public Customer(int account_num,String email, int id_num, String name, String surname, String phone_num,
			String password, String recovery_question) {
		super(email, id_num, name, surname, phone_num, password, recovery_question);
		// TODO Auto-generated constructor stub
	}
	
	//Getter Setter Methods
	
	public int getAccount_num() {
		return account_num;
	}

	

	public void setAccount_num(int account_num) {
		this.account_num = account_num;
	}

	@Override
	public String toString() {
		return "Customer [account_num=" + account_num + ", toString()=" + super.toString() + "]";
	}
     
	
	
	
}
