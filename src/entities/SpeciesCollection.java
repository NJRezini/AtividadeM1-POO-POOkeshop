package entities;

import java.util.ArrayList;

public class SpeciesCollection {

    private static final ArrayList<Species> registeredSpecies = new ArrayList<>();

    public ArrayList<Species> getRegisteredSpecies() {
        return this.registeredSpecies;
    }

    public void listSpecies() {
        System.out.println();
        getRegisteredSpecies().forEach(specie -> {
            if (!specie.isDeleted()) {
                System.out.println(specie);
            }
        });
    }

    public void registerSpecies(int pokedexNumber, String name, String type1, String type2) {
        Species specie = new Species(pokedexNumber, name, type1, type2);
        getRegisteredSpecies().add(specie);
    }

    public void registerSpecies(int pokedexNumber, String name, String type1) {
        Species specie = new Species(pokedexNumber, name, type1);
        getRegisteredSpecies().add(specie);
    }
}
