package org.reverside.bootcamp.ubereats.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Food_Outlet")
public class FoodOutlet {

	//Fields
	@Id
	private String email;

	private String name;
	
	private String surname;
	@Column(name="phone_num")
	private String phoneNum;
	@Column(name="business_name")
	private String businessName;
	@Column(name="business_address")
	private String businessAddress;
	@Column(name="apt_suit")
	private String aptSuit;
	@Column(name="number_of_locations")
	private int numberOfLocations;
	@Column(name="weekly_orders")
	private int weeklyOrders;
	@Column(name="cuisine_type")
	private String cuisineType;
	
	private String password;
	@Column(name="recovery_response")
	private String recoveryResponse;
	
	private boolean enabled;
	@Column(name="is_active")
	private boolean active;
	/*@Column(name="account_num")
	private String accountNum;*/
	
	
	@Column(name="account_num")
	private int accountId;


	@Column(name="role")
	private String role;
	
	//Bidirectional
	@OneToOne(mappedBy="foodOutlet",cascade = CascadeType.ALL) 
	private Menu menu;
	
	//Constructors
	public FoodOutlet() {
	}
	
	
	public FoodOutlet(String email, String name, String surname, String phoneNum, String businessName,
			String businessAddress, String aptSuit, int numberOfLocations, int weeklyOrders, String cuisineType,
			String password, String recoveryResponse, boolean enabled, boolean active, int accountId,
			String role) {
		super();
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.phoneNum = phoneNum;
		this.businessName = businessName;
		this.businessAddress = businessAddress;
		this.aptSuit = aptSuit;
		this.numberOfLocations = numberOfLocations;
		this.weeklyOrders = weeklyOrders;
		this.cuisineType = cuisineType;
		this.password = password;
		this.recoveryResponse = recoveryResponse;
		this.enabled = enabled;
		this.active = active;
		this.accountId = accountId;
		this.role = role;
	}
	

	//Getter Setter Methods
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

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}

	public String getAptSuit() {
		return aptSuit;
	}

	public void setAptSuit(String aptSuit) {
		this.aptSuit = aptSuit;
	}

	public int getNumberOfLocations() {
		return numberOfLocations;
	}

	public void setNumberOfLocations(int numberOfLocations) {
		this.numberOfLocations = numberOfLocations;
	}

	public int getWeeklyOrders() {
		return weeklyOrders;
	}

	public void setWeeklyOrders(int weeklyOrders) {
		this.weeklyOrders = weeklyOrders;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRecoveryResponse() {
		return recoveryResponse;
	}

	public void setRecoveryResponse(String recoveryResponse) {
		this.recoveryResponse = recoveryResponse;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/*public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}*/

	
	public int getAccountId() {
		return accountId;
	}


	public void setAccount(int accountId) {
		this.accountId = accountId;
	}

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public Menu getMenu() {
		return menu;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}


}
