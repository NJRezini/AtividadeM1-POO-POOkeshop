package entities;

public abstract class Product {


    private Integer id;
    private String name;
    private float price;
    private int rarity = 0;
    private int quantity = 1;
    private boolean deleted = false;

    public Product(int id, String name, float price, int rarity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rarity = rarity;
    }

    public Product(String name, float price, int rarity) {
        this.name = name;
        this.price = price;
        this.rarity = rarity;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public boolean isDeleted() {
        return deleted;
    }

    private void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void deleteProduct() {
        setDeleted(true);
    }

    @Override
    public String toString() {
        return "Produto: ";
    }
}
