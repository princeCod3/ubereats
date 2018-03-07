package org.reverside.bootcamp.ubereats.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToOne;
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
	
	@Column(name="account_num")
	private int accountId;
	
	@Column(name="phone_num")
	private String phoneNum;
	
	@Length(min = 5)
	@Transient
	private String password;
	
	@Column(name ="recovery_response")
	private String recoveryQuestion;
	
	@Column(name = "is_active")
	private boolean active = true;
	
	@Column(name = "enabled")
	private boolean enabled = true;
	
	private String role;
	

	/*@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "email"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;*/
	
	//Every user has a cart (OneToOne bi-directional mapping)
	//cascade type ensures a cart is added with each user
	@OneToOne(mappedBy="user",cascade = CascadeType.ALL)
	private Cart cart;
	
	//Constructors
		public User() {
			
		}
	
    public User(String email, int id_num, String name, String surname, int accountId, String phoneNum, String password,
			String recoveryQuestion, String role) {
		super();
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.accountId = accountId;
		this.phoneNum = phoneNum;
		this.password = password;
		this.recoveryQuestion = recoveryQuestion;
		this.role = role;
		
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


	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getPhoneNum() {
		return phoneNum;
	}


	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRecoveryQuestion() {
		return recoveryQuestion;
	}


	public void setRecoveryQuestion(String recoveryQuestion) {
		this.recoveryQuestion = recoveryQuestion;
		
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
	
	
    public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	//To String method
	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", surname=" + surname + ", accountId ="+ accountId + ", phoneNum=" + phoneNum
				+ ", password=" + password + ", recovery_question=" + recoveryQuestion + ", active=" + active
				+ ", role=" + role + "]";
	}
    
   

}
