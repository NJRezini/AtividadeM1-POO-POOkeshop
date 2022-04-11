package entities;

import services.Purchase;

import java.util.ArrayList;

public class PurchaseCollection {
    private static final ArrayList<Purchase> registeredPurchases = new ArrayList<>();


    public ArrayList<Purchase> getRegisteredPurchases() {
        return this.registeredPurchases;
    }

    public void listPurchases() {
        System.out.println();
        this.getRegisteredPurchases().forEach(purchase -> {
            if (!purchase.isDeleted()) {
                System.out.println(purchase);
            }
        });
    }

    public void listPurchases(int trainerId) {
        System.out.println();
        this.getRegisteredPurchases().forEach(purchase -> {
            if (purchase.getTrainer().getId() == trainerId && !purchase.isDeleted()) {
                System.out.println(purchase);
            }
        });
    }

    public void registerPurchase(ArrayList<Product> purchasedProducts, Trainer trainer) {
        Purchase newPurchase = new Purchase(purchasedProducts, trainer);
        this.getRegisteredPurchases().add(newPurchase);
        trainer.getCompletedPurchases().add(newPurchase);
    }

    public void deletePurchase(Integer purchaseId) {
        this.getRegisteredPurchases().get(purchaseId - 1).deletePurchase();
    }
}
