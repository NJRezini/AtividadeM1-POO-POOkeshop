package entities;

import java.util.ArrayList;

public class TrainerCollection {

    protected static int counter = 1;
    private static final ArrayList<Trainer> registeredTrainers = new ArrayList<>();

    public ArrayList<Trainer> getRegisteredTrainers() {
        return registeredTrainers;
    }

    public void registerTrainer(String name, int badges) {
        Trainer trainer = new Trainer(counter, name, badges);
        counter++;
        this.getRegisteredTrainers().add(trainer);
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
