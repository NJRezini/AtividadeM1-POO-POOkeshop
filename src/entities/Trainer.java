package entities;

import services.Purchase;
import services.Shop;

import java.util.ArrayList;

public class Trainer {

    private static int counter = 1;
    private int id;
    private String name;
    private Integer badges;
    private ArrayList<Pokemon> ownedPokemon;
    private ArrayList<Purchase> completedPurchases;
    private boolean deleted = false;

    public Trainer(String name, Integer badges) {
        this.id = counter;
        counter++;
        this.name = name;
        this.badges = badges;
        this.ownedPokemon = new ArrayList<>();
        this.completedPurchases = new ArrayList<>();
    }

    public static void registerTrainer(String name, int badges) {
        Shop.getRegisteredTrainers().add(new Trainer(name, badges));
    }

    public Integer getId() {
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

    public Integer getBadges() {
        return badges;
    }

    public void setBadges(Integer badges) {
        this.badges = badges;
    }

    public ArrayList<Pokemon> getOwnedPokemon() {
        return ownedPokemon;
    }

    public void setOwnedPokemon(ArrayList<Pokemon> ownedPokemon) {
        this.ownedPokemon = ownedPokemon;
    }

    public ArrayList<Purchase> getCompletedPurchases() {
        return completedPurchases;
    }

    public void setCompletedPurchases(ArrayList<Purchase> completedPurchases) {
        this.completedPurchases = completedPurchases;
    }

    public boolean isDeleted() {
        return deleted;
    }

    private void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void listOwnedPokemon() {
        this.ownedPokemon.forEach(pokemon -> {
            System.out.println(pokemon);
        });
    }

    public void deleteTrainer() {
        setDeleted(true);
        Shop.getRegisteredPokemon().forEach(pokemon -> {
            if (pokemon.getTrainer().getId() == this.id) {
                pokemon.deletePokemon();
            }
        });
        Shop.getRegisteredPurchases().forEach(purchase -> {
            if (purchase.getTrainer().getId() == this.id) {
                purchase.deletePurchase();
            }
        });
    }

    @Override
    public String toString() {
        return "Treinador (" + id + ") [Nome: " + name + ", Insígnias: " + badges + "]";
    }

}
