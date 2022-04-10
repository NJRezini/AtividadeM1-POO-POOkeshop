package entities;

import java.util.ArrayList;
import services.*;

public class Species {
	private Integer id;
	private Integer pokedexNumber;
	private String name;
	private String type1;
	private String type2 = "";
	protected static int idCounter = 1;

	public Species(int pokedexNumber, String name, String type1, String type2) {
		this.id = idCounter;
		idCounter++;
		this.pokedexNumber = pokedexNumber;
		this.name = name;
		this.type1 = type1.toUpperCase();
		this.type2 = type2.toUpperCase();
	}
	
	public Species(int pokedexNumber, String name, String type1) {
		this.id = idCounter;
		idCounter++;
		this.pokedexNumber = pokedexNumber;
		this.name = name;
		this.type1 = type1.toUpperCase();
		this.type2 = "--";
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
	
	public static void registerSpecies(int pokedexNumber, String name, String type1, String type2) {
		Shop.getRegisteredSpecies().add(new Species(pokedexNumber, name, type1, type2));
	}
	
	public static void registerSpecies(int pokedexNumber, String name, String type1) {
		Shop.getRegisteredSpecies().add(new Species(pokedexNumber, name, type1));
	}
	
	@Override
	public String toString() {
		return "Espécie ("+ id +") [Nº Pokédex: " + pokedexNumber + ", Nome: " + name + ", Tipo 1: " + type1 + ", Tipo 2: " + type2 + "]";
	}
	
}
