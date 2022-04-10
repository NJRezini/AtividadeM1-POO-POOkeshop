package entities;

import services.Shop;

public class Service extends Product{

	private Integer id;
	private Pokemon pokemon = null;
	private boolean deleted = false;
	private static int idCounter = 1;
	
	public Service(String name, float price, int rarity) {
		super(name, price, rarity);
		this.id = idCounter;
		idCounter++;
	}
	
	public Service(Service service, Pokemon pokemon) {
		super(service.getName(), service.getPrice(), service.getRarity());
		this.pokemon = pokemon;
	}
	
	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	public static void registerService(String name, float price, int rarity) {
		Shop.getRegisteredServices().add(new Service(name, price, rarity));
	}
	
	public void deleteService() {
		this.deleted = true;
	}

	@Override
	public String toString() {
		String client = null;
		if (this.pokemon != null) {
			client = this.pokemon.getNickname();
		} else {
			client = "seu Pokémon";
		}
		return "Serviço (" + id + ") [Serviço: " + getName() + ", Preço: P$ " + String.format("%.2f", getPrice()) + ", "
				+ "Raridade: " + getRarity() + ", Cliente: " + client +"]";
	}

}
