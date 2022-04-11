package entities;

import org.jetbrains.annotations.NotNull;
import services.Purchase;

import java.util.ArrayList;

public class Trainer {

    private int id;
    private String name;
    private Integer badges;
    private ArrayList<Pokemon> ownedPokemon;
    private ArrayList<Purchase> completedPurchases;
    private boolean deleted = false;

    public Trainer(int counter, String name, Integer badges) {
        this.id = counter;
        this.name = name;
        this.badges = badges;
        this.ownedPokemon = new ArrayList<>();
        this.completedPurchases = new ArrayList<>();
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

    public void deleteTrainer(@NotNull PokemonCollection pokemonCollection, PurchaseCollection purchaseCollection) {
        setDeleted(true);
        pokemonCollection.getRegisteredPokemon().forEach(pokemon -> {
            if (pokemon.getTrainer().getId() == this.id) {
                pokemon.deletePokemon();
            }
        });
        purchaseCollection.getRegisteredPurchases().forEach(purchase -> {
            if (purchase.getTrainer().getId() == this.id) {
                purchase.deletePurchase();
            }
        });
    }

    @Override
    public String toString() {
        return "Treinador (" + this.id + ") [Nome: " + this.name + ", Insígnias: " + this.badges + "]";
    }
}
