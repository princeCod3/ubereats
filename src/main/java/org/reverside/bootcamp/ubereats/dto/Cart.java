package org.reverside.bootcamp.ubereats.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/*@Column(name="user_id")
	private String userId;*/
	
	@OneToOne
	private User user;
	
	private double total;
	
	@Column(name="cart_lines")
	private int cartLines;

	//Constructor
	public Cart() {}
	
	public Cart(int id, User user, double total, int cartLines) {
		this.id = id;
		this.user = user;
		this.total = total;
		this.cartLines = cartLines;
	}
	
	
	//Getter Setter Methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
/*	public String getUserId() {
		return userId;
	}
	public void setUserId(String string) {
		this.userId = string;
	}*/
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getCartLines() {
		return cartLines;
	}
	public void setCartLines(int cartLines) {
		this.cartLines = cartLines;
	}
}
