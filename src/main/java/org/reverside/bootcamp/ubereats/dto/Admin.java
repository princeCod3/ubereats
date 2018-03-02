package org.reverside.bootcamp.ubereats.dto;

import javax.persistence.Entity;

@Entity
public class Admin extends User {
    //private fields
	
	private String region;
	
	//Constructors
	public Admin() {	
	}
	
	
	public Admin(String email, int id_num, String name, String surname,String region, String phone_num, String password,
			String recovery_question) {
		super(email, id_num, name, surname, phone_num, password, recovery_question);
		
	}


	//Getter Setter methods
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}


}
