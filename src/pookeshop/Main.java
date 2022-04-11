package pookeshop;

import entities.*;
import services.Shop;


public class Main {

    public static void main(String[] args) {

        PokemonCollection pokemonCollection = new PokemonCollection();
        SpeciesCollection speciesCollection = new SpeciesCollection();
        ItemsCollection itemCollection = new ItemsCollection();
        ServiceCollection serviceCollection = new ServiceCollection();
        TrainerCollection trainerCollection = new TrainerCollection();

        speciesCollection.getRegisteredSpecies().add(new Species(448, "Lucario", "lutador", "Metálico"));
        speciesCollection.getRegisteredSpecies().add(new Species(25, "Pikachu", "Elétrico"));
        speciesCollection.getRegisteredSpecies().add(new Species(702, "Dedenne", "Elétrico", "Fada"));

        itemCollection.getRegisteredItems().add(new Item("Pokeball", 5, 1, 10));
        itemCollection.getRegisteredItems().add(new Item("Greatball", 20, 2, 10));
        itemCollection.getRegisteredItems().add(new Item("Ultraball", 50, 3, 10));

        serviceCollection.getRegisteredServices().add(new Service("Creche Pokémon", 3, 10));
        trainerCollection.getRegisteredTrainers().add(new Trainer("Thomas", 2));
        trainerCollection.getRegisteredTrainers().add(new Trainer("Nathan", 8));

        pokemonCollection.registerPokemon(trainerCollection.getRegisteredTrainers().get(0), speciesCollection.getRegisteredSpecies().get(0), "Lucario");
        pokemonCollection.registerPokemon(trainerCollection.getRegisteredTrainers().get(0), speciesCollection.getRegisteredSpecies().get(2), "Dedenne");
        pokemonCollection.registerPokemon(trainerCollection.getRegisteredTrainers().get(1), speciesCollection.getRegisteredSpecies().get(1), "Pikachu");

        Shop.mainMenu();

    }

}
