package services;

import entities.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Purchase {

    private static int counter = 1;
    private Integer id;
    private ArrayList<Product> purchaseProducts;
    private float purchaseTotal;
    private Trainer trainer;
    private boolean deleted;

    public Purchase(@NotNull ArrayList<Product> purchaseProducts, Trainer trainer) {
        this.id = counter;
        counter++;
        this.purchaseProducts = purchaseProducts;
        this.purchaseTotal = 0;
        purchaseProducts.forEach(product -> {
            purchaseTotal += product.getPrice() * product.getQuantity();
        });
        this.trainer = trainer;
    }

    public static void purchaseItem(ArrayList<Product> purchasedProducts, @NotNull Item item, int quantity) {
        if (quantity <= item.getInventory()) {
            Item purchasedItem = new Item(item, quantity);
            purchasedProducts.add(purchasedItem);
            item.setInventory(item.getInventory() - quantity);
        } else {
            System.out.println("Quantidade inválida!");
        }
    }

    public static void purchaseService(@NotNull ArrayList<Product> purchasedProducts, Service service, Pokemon pokemon) {
        Service purchasedService = new Service(service, pokemon);
        purchasedProducts.add(purchasedService);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Product> getPurchaseProducts() {
        return purchaseProducts;
    }

    public void setPurchaseProducts(ArrayList<Product> purchaseProducts) {
        this.purchaseProducts = purchaseProducts;
    }

    public float getPurchaseTotal() {
        return purchaseTotal;
    }

    public void setPurchaseTotal(float purchaseTotal) {
        this.purchaseTotal = purchaseTotal;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void deletePurchase() {
        setDeleted(true);
    }

    @Override
    public String toString() {
        StringBuilder productDetails = new StringBuilder();
        purchaseProducts.forEach(product -> {
            if (product instanceof Item) {
                productDetails.append("[Item: ").append(product.getName()).append(" x ").append(product.getQuantity())
                        .append(" = P$ ").append(String.format("%.2f", (product.getPrice() * product.getQuantity())))
                        .append("]\n");
            } else if (product instanceof Service) {
                productDetails.append("[Serviço: ").append(product.getName()).append(" para ")
                        .append(((Service) product).getPokemon().getNickname()).append(" = P$ ")
                        .append(String.format("%.2f", (product.getPrice() * product.getQuantity()))).append("]\n");
            }
        });
        return "\nCompra (" + id + ") " + "Treinador: " + trainer.getName() + "\n" + productDetails + "Total: P$ "
                + String.format("%.2f", purchaseTotal);
    }

}
