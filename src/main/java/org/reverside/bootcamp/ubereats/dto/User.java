package org.reverside.bootcamp.ubereats.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;



import org.hibernate.validator.constraints.Length;


@Entity
@Inheritance
public class User {
	
	//private fields
	@Id

	private String email;
	
	private String name;

	private String surname;
	
	@Column(name="phone_number")
	private String phone_num;
	
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	
	@Transient
	private String password;
	
	private String recovery_question;
	
	@Column(name = "is_active")
	private boolean active;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "email"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	//Constructors
	public User() {
		
	}
    public User(String email, int id_num, String name, String surname, String phone_num, String password,
			String recovery_question) {
		super();
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.phone_num = phone_num;
		this.password = password;
		this.recovery_question = recovery_question;
	}

    //Getter Setter methods

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getPhone_num() {
		return phone_num;
	}


	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRecovery_question() {
		return recovery_question;
	}


	public void setRecovery_question(String recovery_question) {
		this.recovery_question = recovery_question;
		
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	

	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	//To String method
	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", surname=" + surname + ", phone_num=" + phone_num
				+ ", password=" + password + ", recovery_question=" + recovery_question + ", active=" + active
				+ ", roles=" + roles + "]";
	}
    
   

}
