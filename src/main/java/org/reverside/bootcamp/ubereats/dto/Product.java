package org.reverside.bootcamp.ubereats.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	//private fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String name;
	@Column(name ="unit_price")
	private double unitPrice;
	@Column(name ="image_url")
	private String imageUrl;
	private String description;
	@Column(name = "is_active")
	private boolean active;
	private int purchases;
	private int views;
	@Column(name ="category_id")
	private int categoryId;
	@Column(name ="menu_id")
	private int menuId;
	
	//Constructors
	public Product() {
		
		this.code = "PRD" + UUID.randomUUID().toString().substring(26);
	}
	
	public Product(int id, String name, double unitPrice, String imageUrl, String description, boolean active,
			int purchases, int views, int categoryId, int menuId) {
		super();
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
		this.imageUrl = imageUrl;
		this.description = description;
		this.active = active;
		this.purchases = purchases;
		this.views = views;
		this.categoryId = categoryId;
		this.menuId = menuId;
	}
	
	//Getter Setter methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double d) {
		this.unitPrice = d;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getPurchases() {
		return purchases;
	}
	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	
	
	//To String method
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", unitPrice=" + unitPrice + ", imageUrl=" + imageUrl
				+ ", description=" + description + ", active=" + active + ", purchases=" + purchases + ", views="
				+ views + ", categoryId=" + categoryId + ", menuId=" + menuId + "]";
	}

	
	

}
