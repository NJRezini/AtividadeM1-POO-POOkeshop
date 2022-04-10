package entities;

import java.util.ArrayList;
import services.*;

public class Trainer {

	private int id;
	private String name;
	private int badges;
	private ArrayList<Pokemon> ownedPokemon;
	private ArrayList<Purchase> completedPurchases;
	private boolean deleted = false;
	private static int idCounter = 1;
	
	public Trainer(String name, Integer badges) {
		this.id = idCounter;
		idCounter++;
		this.name = name;
		this.badges = badges;
		this.ownedPokemon = new ArrayList<>();
		this.completedPurchases = new ArrayList<>();
	}

	public Trainer(Integer id, String name) {
		this.id = id;
		this.name = name;
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

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void listOwnedPokemon() {
		this.ownedPokemon.forEach(pokemon -> {
			System.out.println(pokemon);
		});
	}
	
	public static void registerTrainer(String name, int badges) {
		Shop.getRegisteredTrainers().add(new Trainer(name, badges));
	}
	
	public void deleteTrainer() {
		this.deleted = true;
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
