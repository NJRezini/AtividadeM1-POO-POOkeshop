package entities;

import org.jetbrains.annotations.NotNull;

public class Item extends Product {

    private static int counter = 1;
    private int inventory;

    public Item(String name, float price, int rarity, int inventory) {
        super(counter, name, price, rarity);
        counter++;
        this.inventory = inventory;
    }

    public Item(@NotNull Item item, int quantity) {
        super(item.getName(), item.getPrice(), item.getRarity());
        this.setQuantity(quantity);
    }

    public int getInventory() {
        return this.inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Item (" + this.getId() + ") [Item: " + this.getName() + ", Preço: P$ " + String.format("%.2f", this.getPrice())
                + ", Estoque: " + this.inventory + ", Raridade: " + this.getRarity() + "]";
    }
}
