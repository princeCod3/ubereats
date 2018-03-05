package org.reverside.bootcamp.ubereats.dto;

import javax.persistence.Entity;

@Entity
public class Admin extends User {
    //private fields
	
	private String region;
	
	//Constructors
	public Admin() {	
	}
	
	
	public Admin(String email, int id_num, String name, String surname,int accountId ,String region, String phoneNum, String password,
			String recovery_question) {
		super(email, id_num, name, surname, accountId ,phoneNum, password, recovery_question);
		
	}


	//Getter Setter methods
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}


}
