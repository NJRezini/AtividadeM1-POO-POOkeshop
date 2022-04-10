package entities;

import services.*;
import java.util.ArrayList;

public class Pokemon extends Species {
	
	private Integer id;
	private String nickname;
	private Trainer trainer;
	private boolean deleted = false;
	private static int idCounter = 1;
	
	public Pokemon(Species species, String nickname, Trainer trainer) {
		super(species.getPokedexNumber(), species.getName(), species.getType1(), species.getType2());
		this.id = idCounter;
		idCounter++;
		Species.idCounter--;
		this.nickname = nickname;
		this.trainer = trainer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public static void registerPokemon(Trainer trainer, Species species, String nickname) {
		Pokemon newPokemon = new Pokemon(species, nickname, trainer);
		Shop.getRegisteredPokemon().add(newPokemon);
		trainer.getOwnedPokemon().add(newPokemon);
	}
	
	public void deletePokemon() {
		this.deleted = true;
	}
	
	@Override
	public String toString() {
		return "Pokemon ("+ id +") [Apelido: " + nickname + ", Espécie: " + getName() + "(" + getType1() + "|" + getType2() + "), Treinador: " + trainer.getName() + "]";
	}
	
}
