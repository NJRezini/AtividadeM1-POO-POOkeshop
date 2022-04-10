package entities;

import services.*;

public abstract class Product {

	private String name;
	private float price;
	private int rarity = 0;
	private int quantity = 1;
	
	public Product(String name, float price, int rarity) {
		this.name = name;
		this.price = price;
		this.rarity = rarity;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getRarity() {
		return rarity;
	}
	
	public void setRarity(int rarity) {
		this.rarity = rarity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Produto: ";
	}
	
	
	

	
}
