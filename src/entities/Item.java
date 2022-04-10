package entities;

import services.Shop;

public class Item extends Product {

	private Integer id;
	private int inventory;
	private boolean deleted = false;
	private static int idCounter = 1;
	
	public Item(String name, float price, int rarity, int inventory) {
		super(name, price, rarity);
		this.id = idCounter;
		idCounter++;
		this.inventory = inventory;
	}
	
	public Item(Item item, int quantity) {
		super(item.getName(), item.getPrice(), item.getRarity());
		this.setQuantity(quantity);
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getInventory() {
		return inventory;
	}
	
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public static void registerItem(String name, float price, int rarity, int inventory) {
		Shop.getRegisteredItems().add(new Item(name, price, rarity, inventory));
	}
	
	public void deleteItem() {
		this.deleted = true;
	}
	
	@Override
	public String toString() {
		return "Item ("+ id + ") [Item: " + getName() + ", Preço: P$ " + String.format("%.2f", getPrice()) + ", Estoque: " + inventory + ", Raridade: " + getRarity() + "]";
	}
	
}
