package entities;

import java.util.ArrayList;

public class TrainerCollection {

    private static final ArrayList<Trainer> registeredTrainers = new ArrayList<>();

    public ArrayList<Trainer> getRegisteredTrainers() {
        return this.registeredTrainers;
    }

    public void registerTrainer(String name, int badges) {
        this.getRegisteredTrainers().add(new Trainer(name, badges));
    }

    public void listTrainers() {
        System.out.println();
        this.getRegisteredTrainers().forEach(trainer -> {
            if (!trainer.isDeleted()) {
                System.out.println(trainer);
            }
        });
    }

    public void listPokemonOwnedByTrainer(int trainerId) {
        System.out.println();
        this.getRegisteredTrainers().forEach(trainer -> {
            if (trainer.getId() == trainerId && !trainer.isDeleted()) {
                System.out.println(trainer.getOwnedPokemon());
            }
        });
    }

    public void deleteTrainer(Integer trainerId, PurchaseCollection purchaseCollection, PokemonCollection pokemonCollection) {
        this.getRegisteredTrainers().get(trainerId - 1).deleteTrainer(pokemonCollection, purchaseCollection);
    }
}
