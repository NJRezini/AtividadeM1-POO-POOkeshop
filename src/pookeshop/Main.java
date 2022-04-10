package pookeshop;

import entities.*;
import services.*;


public class Main {

	public static void main(String[] args) {
		
		Shop.getRegisteredSpecies().add(new Species(448, "Lucario", "lutador", "Metálico"));
		Shop.getRegisteredSpecies().add(new Species(025, "Pikachu", "Elétrico"));
		Shop.getRegisteredSpecies().add(new Species(702, "Dedenne", "Elétrico", "Fada"));

		Shop.getRegisteredItems().add(new Item("Pokeball", 5, 1, 10));
		Shop.getRegisteredItems().add(new Item("Greatball", 20, 2, 10));
		Shop.getRegisteredItems().add(new Item("Ultraball", 50, 3, 10));
		
		Shop.getRegisteredServices().add(new Service("Creche Pokémon", 3, 10));
		Shop.getRegisteredTrainers().add(new Trainer("Thomas", 2));
		Shop.getRegisteredTrainers().add(new Trainer("Nathan", 8));
		
		Pokemon.registerPokemon(Shop.getRegisteredTrainers().get(0), Shop.getRegisteredSpecies().get(0), "Lucario");
		Pokemon.registerPokemon(Shop.getRegisteredTrainers().get(0), Shop.getRegisteredSpecies().get(2), "Dedenne");
		Pokemon.registerPokemon(Shop.getRegisteredTrainers().get(1), Shop.getRegisteredSpecies().get(1), "Pikachu");
		
		Shop.mainMenu();

	}
	
}
