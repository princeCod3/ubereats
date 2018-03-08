package org.reverside.bootcamp.ubereats.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//Menu converted to replace category
@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String description;
	
	private String image_url;
	
	@Column(name="is_active") //Ensures attribute is linked to relative column
	private boolean active = true;
	
/*	private int category_id;*/
	
	
	@OneToOne
	private FoodOutlet foodOutlet;
	
	//Constructor
	public Menu() {}
	
	
	
	public Menu(int id, String name, String description, FoodOutlet foodOutlet) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		/*this.category_id = category_id;*/
		this.foodOutlet = foodOutlet;
	}



	//Getter Setter Methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}



	/*public int getCategory_id() {
		return category_id;
	}



	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}*/
	public FoodOutlet getFoodOutlet() {
		return foodOutlet;
	}
	public void setFoodOutlet(FoodOutlet foodOutlet) {
		this.foodOutlet = foodOutlet;
	}
}
