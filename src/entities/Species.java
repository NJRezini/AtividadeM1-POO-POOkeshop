package entities;

import services.Shop;

public class Species {
    protected static int counter = 1;
    private Integer id;
    private Integer pokedexNumber;
    private String name;
    private String type1;
    private String type2;

    public Species(int pokedexNumber, String name, String type1, String type2) {
        this.id = counter;
        counter++;
        this.pokedexNumber = pokedexNumber;
        this.name = name;
        this.type1 = type1.toUpperCase();
        this.type2 = type2.toUpperCase();
    }

    public Species(int pokedexNumber, String name, String type1) {
        this.id = counter;
        counter++;
        this.pokedexNumber = pokedexNumber;
        this.name = name;
        this.type1 = type1.toUpperCase();
        this.type2 = "--";
    }

    public static void registerSpecies(int pokedexNumber, String name, String type1, String type2) {
        Species specie = new Species(pokedexNumber, name, type1, type2);
        Shop.getRegisteredSpecies().add(specie);
    }

    public static void registerSpecies(int pokedexNumber, String name, String type1) {
        Species specie = new Species(pokedexNumber, name, type1);
        Shop.getRegisteredSpecies().add(specie);
    }

    public int getPokedexNumber() {
        return pokedexNumber;
    }

    public void setPokedexNumber(int pokedexNumber) {
        this.pokedexNumber = pokedexNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    @Override
    public String toString() {
        return "Espécie (" + this.id + ") [Nº Pokédex: " + this.pokedexNumber + ", Nome: " + this.name + ", Tipo 1: " + this.type1 + ", Tipo 2: " + this.type2 + "]";
    }

}
