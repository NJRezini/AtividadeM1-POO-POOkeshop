package entities;

import java.util.ArrayList;

public class SpeciesCollection {

    protected static int counter = 1;
    private static final ArrayList<Species> registeredSpecies = new ArrayList<>();

    public ArrayList<Species> getRegisteredSpecies() {
        return registeredSpecies;
    }

    public void registerSpecies(int pokedexNumber, String name, String type1) {
        Species specie = new Species(counter, pokedexNumber, name, type1);
        counter++;
        getRegisteredSpecies().add(specie);
    }

    public void registerSpecies(int pokedexNumber, String name, String type1, String type2) {
        Species specie = new Species(counter, pokedexNumber, name, type1, type2);
        counter++;
        getRegisteredSpecies().add(specie);
    }

    public void listSpecies() {
        System.out.println();
        getRegisteredSpecies().forEach(specie -> {
            if (!specie.isDeleted()) {
                System.out.println(specie);
            }
        });
    }
}
