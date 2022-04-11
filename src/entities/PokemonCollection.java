package entities;

import java.util.ArrayList;

public class PokemonCollection {

    protected static int counter = 1;
    private static final ArrayList<Pokemon> registeredPokemon = new ArrayList<>();

    public ArrayList<Pokemon> getRegisteredPokemon() {
        return registeredPokemon;
    }

    public void listPokemon() {
        System.out.println();
        this.getRegisteredPokemon().forEach(pokemon -> {
            if (!pokemon.isDeleted()) {
                System.out.println(pokemon);
            }
        });
    }

    public void registerPokemon(Trainer trainer, Species specie, String nickname) {
        Pokemon newPokemon = new Pokemon(counter, specie, nickname, trainer);
        this.getRegisteredPokemon().add(newPokemon);
        trainer.getOwnedPokemon().add(newPokemon);
    }

    public void deletePokemon(Integer pokemonId) {
        this.getRegisteredPokemon().get(pokemonId - 1).deletePokemon();
    }

}
