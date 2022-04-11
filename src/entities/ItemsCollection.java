package entities;

import java.util.ArrayList;

public class ItemsCollection {
    private static final ArrayList<Item> registeredItems = new ArrayList<>();

    public ArrayList<Item> getRegisteredItems() {
        return registeredItems;
    }

    public void listItems() {
        System.out.println();
        this.getRegisteredItems().forEach(item -> {
            if (item.isDeleted()) {
                System.out.println(item);
            }
        });
    }

    public void registerItem(String name, float price, int rarity, int inventory) {
        Item item = new Item(name, price, rarity, inventory);
        this.getRegisteredItems().add(item);
    }

    public void deleteItem(Integer pokemonId) {
        this.getRegisteredItems().get(pokemonId - 1).deleteProduct();
    }
}
