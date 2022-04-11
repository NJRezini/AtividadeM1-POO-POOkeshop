package entities;

import org.jetbrains.annotations.NotNull;

public class Service extends Product {

    private static int counter = 1;
    private Pokemon pokemon = null;

    public Service(String name, float price, int rarity) {
        super(counter, name, price, rarity);
        counter++;
    }

    public Service(@NotNull Service service, Pokemon pokemon) {
        super(service.getName(), service.getPrice(), service.getRarity());
        this.pokemon = pokemon;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public String toString() {
        String client;
        if (this.pokemon != null) {
            client = this.pokemon.getNickname();
        } else {
            client = "seu Pokémon";
        }
        return "Serviço (" + this.getId() + ") [Serviço: " + this.getName() + ", Preço: P$ " + String.format("%.2f", this.getPrice()) + ", "
                + "Raridade: " + this.getRarity() + ", Cliente: " + client + "]";
    }

}
