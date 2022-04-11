package services;

import entities.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {

    private static final PokemonCollection pokemonCollection = new PokemonCollection();
    private static final SpeciesCollection speciesCollection = new SpeciesCollection();
    private static final ItemsCollection itemCollection = new ItemsCollection();
    private static final TrainerCollection trainerCollection = new TrainerCollection();
    private static final ServiceCollection serviceCollection = new ServiceCollection();
    private static final PurchaseCollection purchaseCollection = new PurchaseCollection();
    private static final Scanner sc = new Scanner(System.in);

    public static void mainMenu() {
        int menu = -1;
        do {
            clearScreen();
            System.out.println("""
                    MENU PRINCIPAL\s
                    Bem vindo à POOkeShop! O que você gostaria de fazer?\s

                    1. Fazer um pedido.
                    2. Cadastrar
                    3. Buscar
                    4. Deletar
                    0. Sair da POOkeShop.
                    """);

            menu = sc.nextInt();
            sc.nextLine();
            clearScreen();

            switch (menu) {
                case 1 -> purchaseMenu();
                case 2 -> registrationMenu();
                case 3 -> searchMenu();
                case 4 -> removalMenu();
                case 0 -> System.out.println("Até a próxima!");
            }
        } while (menu != 0);
        sc.close();
    }

    private static void purchaseMenu() {
        System.out.print("ID de treinador: ");
        int trainerId = sc.nextInt();
        sc.nextLine();
        clearScreen();
        ArrayList<Product> purchaseProducts = new ArrayList<>();
        int menu = -1;
        do {
            clearScreen();
            System.out.print("""
                    FAZER PEDIDO\s
                    O que você gostaria de adquirir?\s

                    1. Um item.
                    2. Um serviço para o meu pokémon.
                    """);
            if (purchaseProducts.size() == 0) {
                System.out.println("0. Voltar para o menu principal");
            } else {
                System.out.println("0. Fechar pedido.");
            }
            menu = sc.nextInt();
            sc.nextLine();
            clearScreen();

            switch (menu) {
                case 1 -> buyItem(purchaseProducts);
                case 2 -> buyService(trainerId, purchaseProducts);
            }

        } while (menu != 0);

        if (purchaseProducts.size() > 0) {
            Trainer trainer = trainerCollection.getRegisteredTrainers().get(trainerId - 1);
            purchaseCollection.registerPurchase(purchaseProducts, trainer);
        }
        clearScreen();
        purchaseCollection.listPurchases();
        pauseScreen();
    }

    private static void searchMenu() {
        int menu = -1;

        do {
            System.out.println("""
                    BUSCA\s
                    O que você gostaria de buscar?\s

                    1. Espécies registradas.
                    2. Pokémon registrados.
                    3. Pokémon de um treinador.
                    4. Treinadores registrados.
                    5. Itens registrados.
                    6. Serviços registrados.
                    7. Uma compra de um treinador.
                    8. Todas as compras.
                    0. Voltar para o Menu Principal.
                    """);
            menu = sc.nextInt();
            sc.nextLine();
            clearScreen();

            int trainerId;

            switch (menu) {
                case 1 -> speciesCollection.listSpecies();
                case 2 -> pokemonCollection.listPokemon();
                case 3 -> {
                    trainerId = getTrainerId();
                    trainerCollection.listPokemonOwnedByTrainer(trainerId);
                }
                case 4 -> trainerCollection.listTrainers();
                case 5 -> itemCollection.listItems();
                case 6 -> serviceCollection.listServices();
                case 7 -> {
                    trainerId = getTrainerId();
                    purchaseCollection.listPurchases(trainerId);
                }
                case 8 -> purchaseCollection.listPurchases();
            }
            pauseScreen();
            clearScreen();
        } while (menu != 0);
    }

    private static void removalMenu() {
        int menu = -1;
        do {
            System.out.println(
                    """
                            REMOVER\s
                            O que você gostaria de remover?\s

                            1. Um pokémon.
                            2. Um treinador.
                            3. Um item.
                            4. Um serviço.
                            0. Voltar para o Menu Principal.
                            """);
            menu = sc.nextInt();
            sc.nextLine();
            clearScreen();

            switch (menu) {
                case 1 -> deletePokemon();
                case 2 -> deleteTrainer();
                case 3 -> deleteItem();
                case 4 -> deleteService();
                case 5 -> deletePurchase();
            }
            clearScreen();
        } while (menu != 0);
    }

    private static void buyService(int trainerId, ArrayList<Product> purchaseProducts) {
        serviceCollection.listServices();
        System.out.print("ID do serviço para comprar: ");
        int serviceId = sc.nextInt() - 1;
        sc.nextLine();
        trainerCollection.listPokemonOwnedByTrainer(trainerId);
        System.out.print("ID do pokémon a utilizar " + serviceCollection.getRegisteredServices().get(serviceId).getName() + ": ");
        int pokemonId = sc.nextInt() - 1;
        sc.nextLine();
        System.out.print("");
        Purchase.purchaseService(purchaseProducts, serviceCollection.getRegisteredServices().get(serviceId),
                pokemonCollection.getRegisteredPokemon().get(pokemonId));
    }

    private static void buyItem(ArrayList<Product> purchaseProducts) {
        itemCollection.listItems();
        System.out.print("\nID do item para comprar: ");
        int itemId = sc.nextInt() - 1;
        sc.nextLine();
        System.out.print("Quantidade desejada de " + itemCollection.getRegisteredItems().get(itemId).getName() + ": ");
        int quantity = sc.nextInt() - 1;
        sc.nextLine();
        Purchase.purchaseItem(purchaseProducts, itemCollection.getRegisteredItems().get(itemId), quantity);
    }

    private static void registrationMenu() {
        int menu = -1;
        do {
            System.out.println("""
                    CADASTRO\s
                    O que você gostaria de cadastrar?\s

                    1. Uma espécie.
                    2. Um treinador.
                    3. Um pokémon.
                    4. Um item.
                    5. Um serviço.
                    0. Voltar para o Menu Principal.
                    """);
            menu = sc.nextInt();
            sc.nextLine();
            clearScreen();

            switch (menu) {
                case 1 -> {
                    speciesRegistration();
                    speciesCollection.listSpecies();
                }
                case 2 -> {
                    trainerRegistration();
                    trainerCollection.listTrainers();
                }
                case 3 -> {
                    pokemonRegistration();
                    pokemonCollection.listPokemon();
                }
                case 4 -> {
                    itemRegistration();
                    itemCollection.listItems();
                }
                case 5 -> {
                    serviceRegistration();
                    serviceCollection.listServices();
                }
            }
            pauseScreen();
            clearScreen();
        } while (menu != 0);
    }

    private static void speciesRegistration() {
        System.out.print("Número da Pokédex: ");
        int pokedex = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome da espécie: ");
        String name = sc.nextLine();
        System.out.print("Tipo 1: ");
        String type1 = sc.nextLine();
        System.out.print("Inserir segundo tipo? 1 - SIM || 2 - NÃO ");
        if (sc.nextInt() == 1) {
            System.out.print("Tipo 2: ");
            sc.nextLine();
            String type2 = sc.nextLine();
            speciesCollection.registerSpecies(pokedex, name, type1, type2);
        } else {
            sc.nextLine();
            speciesCollection.registerSpecies(pokedex, name, type1);
        }
    }

    private static void trainerRegistration() {
        System.out.print("Nome do treinador: ");
        String name = sc.nextLine();
        System.out.print("Número de insígnias: ");
        int badges = sc.nextInt();
        sc.nextLine();
        trainerCollection.registerTrainer(name, badges);
    }

    private static void pokemonRegistration() {
        trainerCollection.listTrainers();
        System.out.print("\nID de treinador: ");
        int trainerId = sc.nextInt() - 1;
        sc.nextLine();
        speciesCollection.listSpecies();
        System.out.print("\nID da espécie do pokemon: ");
        int speciesId = sc.nextInt() - 1;
        sc.nextLine();
        System.out.print("Apelido: ");
        String name = sc.nextLine();
        pokemonCollection.registerPokemon(trainerCollection.getRegisteredTrainers().get(trainerId), speciesCollection.getRegisteredSpecies().get(speciesId),
                name);
    }

    private static void itemRegistration() {
        System.out.print("Nome do item: ");
        String name = sc.nextLine();
        System.out.print("Preço: ");
        float price = sc.nextFloat();
        sc.nextLine();
        System.out.print("Estoque: ");
        int inventory = sc.nextInt();
        sc.nextLine();
        System.out.print("Raridade: ");
        int rarity = sc.nextInt();
        sc.nextLine();
        itemCollection.registerItem(name, price, rarity, inventory);
    }

    public static void serviceRegistration() {
        System.out.println("Nome do serviço: ");
        String name = sc.nextLine();
        System.out.println("Preço: ");
        float price = sc.nextFloat();
        sc.nextLine();
        System.out.println("Raridade: ");
        int rarity = sc.nextInt();
        sc.nextLine();
        serviceCollection.registerService(name, price, rarity);
    }

    private static int getTrainerId() {
        int trainerId;
        System.out.print("ID do Treinador: ");
        trainerId = sc.nextInt();
        sc.nextLine();
        return trainerId;
    }
    private static void deletePurchase() {
        purchaseCollection.listPurchases();
        System.out.print("ID do compra: ");
        int purchaseId = sc.nextInt();
        sc.nextLine();
        purchaseCollection.deletePurchase(purchaseId);
    }

    private static void deleteService() {
        serviceCollection.listServices();
        System.out.print("ID do serviço: ");
        int serviceId = sc.nextInt();
        sc.nextLine();
        serviceCollection.deleteService(serviceId);
    }

    private static void deleteItem() {
        itemCollection.listItems();
        System.out.print("ID do item: ");
        int itemId = sc.nextInt();
        sc.nextLine();
        itemCollection.deleteItem(itemId);
    }

    private static void deleteTrainer() {
        trainerCollection.listTrainers();
        System.out.print("ID do treinador: ");
        int trainerId = sc.nextInt();
        sc.nextLine();
        trainerCollection.deleteTrainer(trainerId, Shop.purchaseCollection, Shop.pokemonCollection);
    }

    private static void deletePokemon() {
        pokemonCollection.listPokemon();
        System.out.print("ID do pokémon: ");
        int pokemonId = sc.nextInt();
        sc.nextLine();
        pokemonCollection.deletePokemon(pokemonId);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pauseScreen() {
        System.out.println("\nPressione Enter para continuar...");
        sc.nextLine();
        clearScreen();
    }

}