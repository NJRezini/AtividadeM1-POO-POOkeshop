package services;

import java.util.ArrayList;
import java.util.Scanner;
import entities.*;

public class Shop {

	private static ArrayList<Trainer> registeredTrainers = new ArrayList<>();
	private static ArrayList<Pokemon> registeredPokemon = new ArrayList<>();
	private static ArrayList<Species> registeredSpecies = new ArrayList<>();
	private static ArrayList<Item> registeredItems = new ArrayList<>();
	private static ArrayList<Service> registeredServices = new ArrayList<>();
	private static ArrayList<Purchase> registeredPurchases = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);

	public static ArrayList<Trainer> getRegisteredTrainers() {
		return registeredTrainers;
	}

	public static ArrayList<Pokemon> getRegisteredPokemon() {
		return registeredPokemon;
	}

	public static ArrayList<Species> getRegisteredSpecies() {
		return registeredSpecies;
	}

	public static ArrayList<Item> getRegisteredItems() {
		return registeredItems;
	}

	public static ArrayList<Service> getRegisteredServices() {
		return registeredServices;
	}

	public static ArrayList<Purchase> getRegisteredPurchases() {
		return registeredPurchases;
	}

	public static void listSpecies() {
		System.out.println();
		registeredSpecies.forEach(species -> {
			System.out.println(species);
		});
	}

	public static void listTrainers() {
		System.out.println();
		registeredTrainers.forEach(trainer -> {
			if (!trainer.isDeleted()) {
				System.out.println(trainer);
			}
		});
	}

	public static void listPokemon() {
		System.out.println();
		registeredPokemon.forEach(pokemon -> {
			if (!pokemon.isDeleted()) {
				System.out.println(pokemon);
			}
		});
	}

	public static void listPokemon(int trainerId) {
		System.out.println();
		registeredPokemon.forEach(pokemon -> {
			if (pokemon.getTrainer().getId() == trainerId && !pokemon.isDeleted()) {
				System.out.println(pokemon);
			}
		});
	}

	public static void listItems() {
		System.out.println();
		registeredItems.forEach(item -> {
			if (!item.isDeleted()) {
				System.out.println(item);
			}
		});
	}

	public static void listServices() {
		System.out.println();
		registeredServices.forEach(service -> {
			if (!service.isDeleted()) {
				System.out.println(service);
			}
		});
	}

	public static void listPurchases() {
		System.out.println();
		registeredPurchases.forEach(purchase -> {
			if (!purchase.isDeleted()) {
				System.out.println(purchase);
			}
		});
	}

	public static void listPurchases(int trainerId) {
		System.out.println();
		registeredPurchases.forEach(purchase -> {
			if (purchase.getTrainer().getId() == trainerId && !purchase.isDeleted()) {
				System.out.println(purchase);
			}
		});
	}

	public static void mainMenu() {
		int menu = -1;
		do {
			clearScreen();
			System.out.println("MENU PRINCIPAL \n" + "Bem vindo à POOkeShop! O que você gostaria de fazer? \n\n"
					+ "1. Fazer um pedido.\n" + "2. Cadastrar\n" + "3. Buscar\n" + "4. Deletar\n"
					+ "0. Sair da POOkeShop.\n");

			menu = sc.nextInt();
			sc.nextLine();
			clearScreen();

			switch (menu) {
			case 1:
				purchaseMenu();
				break;
			case 2:
				registrationMenu();
				break;
			case 3:
				searchMenu();
				break;
			case 4:
				removalMenu();
				break;
			case 0:
				System.out.println("Até a próxima!");
				break;
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
			System.out.print("FAZER PEDIDO \n" + "O que você gostaria de adquirir? \n\n" + "1. Um item.\n"
					+ "2. Um serviço para o meu pokémon.\n");
			if (purchaseProducts.size() == 0) {
				System.out.println("0. Voltar para o menu principal");
			} else {
				System.out.println("0. Fechar pedido.");
			}
			menu = sc.nextInt();
			sc.nextLine();
			clearScreen();

			switch (menu) {
			case 1:
				listItems();
				System.out.print("\nID do item para comprar: ");
				int itemId = sc.nextInt();
				sc.nextLine();
				System.out.print("Quantidade desejada de " + registeredItems.get(itemId - 1).getName() + ": ");
				int quantity = sc.nextInt();
				sc.nextLine();
				Purchase.purchaseItem(purchaseProducts, registeredItems.get(itemId - 1), quantity);
				break;
			case 2:
				listServices();
				System.out.print("ID do serviço para comprar: ");
				int serviceId = sc.nextInt();
				sc.nextLine();
				listPokemon(trainerId);
				System.out.print("ID do pokémon a utilizar " + registeredServices.get(serviceId - 1).getName() + ": ");
				int pokemonId = sc.nextInt();
				sc.nextLine();
				System.out.print("");
				Purchase.purchaseService(purchaseProducts, registeredServices.get(serviceId - 1),
						registeredPokemon.get(pokemonId - 1));
				break;
			}
		} while (menu != 0);

		if (purchaseProducts.size() > 0) {
			Purchase.registerPurchase(purchaseProducts, registeredTrainers.get(trainerId - 1));
		}
		clearScreen();
		listPurchases();
		pauseScreen();
	}

	private static void registrationMenu() {
		int menu = -1;
		do {
			System.out.println("CADASTRO \n" + "O que você gostaria de cadastrar? \n\n" + "1. Uma espécie.\n"
					+ "2. Um treinador.\n" + "3. Um pokémon.\n" + "4. Um item.\n" + "5. Um serviço.\n"
					+ "0. Voltar para o Menu Principal.\n");
			menu = sc.nextInt();
			sc.nextLine();
			clearScreen();

			switch (menu) {
			case 1:
				speciesRegistration();
				listSpecies();
				break;
			case 2:
				trainerRegistration();
				listTrainers();
				break;
			case 3:
				pokemonRegistration();
				listPokemon();
				break;
			case 4:
				itemRegistration();
				listItems();
				break;
			case 5:
				serviceRegistration();
				listServices();
				break;
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
			Species.registerSpecies(pokedex, name, type1, type2);
		} else {
			sc.nextLine();
			Species.registerSpecies(pokedex, name, type1);
		}
	}

	private static void trainerRegistration() {
		System.out.print("Nome do treinador: ");
		String name = sc.nextLine();
		System.out.print("Número de insígnias: ");
		int badges = sc.nextInt();
		sc.nextLine();
		Trainer.registerTrainer(name, badges);
	}

	private static void pokemonRegistration() {
		listTrainers();
		System.out.print("\nID de treinador: ");
		int trainerId = sc.nextInt();
		sc.nextLine();
		listSpecies();
		System.out.print("\nID da espécie do pokemon: ");
		int speciesId = sc.nextInt();
		sc.nextLine();
		System.out.print("Apelido: ");
		String name = sc.nextLine();
		Pokemon.registerPokemon(getRegisteredTrainers().get(trainerId - 1), getRegisteredSpecies().get(speciesId - 1),
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
		Item.registerItem(name, price, rarity, inventory);
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
		Service.registerService(name, price, rarity);
	}

	private static void searchMenu() {
		int menu = -1;

		do {
			System.out.println("BUSCA \n" + "O que você gostaria de buscar? \n\n" + "1. Espécies registradas.\n"
					+ "2. Pokémon registrados.\n" + "3. Pokémon de um treinador.\n" + "4. Treinadores registrados.\n"
					+ "5. Itens registrados.\n" + "6. Serviços registrados.\n" + "7. Uma compra de um treinador.\n"
					+ "8. Todas as compras.\n" + "0. Voltar para o Menu Principal.\n");
			menu = sc.nextInt();
			sc.nextLine();
			clearScreen();

			int trainerId;

			switch (menu) {
			case 1:
				listSpecies();
				break;
			case 2:
				listPokemon();
				break;
			case 3:
				System.out.print("ID do Treinador: ");
				trainerId = sc.nextInt();
				sc.nextLine();
				listPokemon(trainerId);
				break;
			case 4:
				listTrainers();
				break;
			case 5:
				listItems();
				break;
			case 6:
				listServices();
				break;
			case 7:
				System.out.print("ID do Treinador: ");
				trainerId = sc.nextInt();
				sc.nextLine();
				listPurchases(trainerId);
				break;
			case 8:
				listPurchases();
				break;
			}
			pauseScreen();
			clearScreen();
		} while (menu != 0);
	}

	private static void removalMenu() {
		int menu = -1;
		do {
			System.out.println(
					"REMOVER \n" + "O que você gostaria de remover? \n\n" + "1. Um pokémon.\n" + "2. Um treinador.\n"
							+ "3. Um item.\n" + "4. Um serviço.\n" + "0. Voltar para o Menu Principal.\n");
			menu = sc.nextInt();
			sc.nextLine();
			clearScreen();

			switch (menu) {
			case 1:
				listPokemon();
				System.out.print("ID do pokémon: ");
				int pokemonId = sc.nextInt();
				sc.nextLine();
				registeredPokemon.get(pokemonId - 1).deletePokemon();
				break;
			case 2:
				listTrainers();
				System.out.print("ID do treinador: ");
				int trainerId = sc.nextInt();
				sc.nextLine();
				registeredTrainers.get(trainerId - 1).deleteTrainer();
				break;
			case 3:
				listItems();
				System.out.print("ID do item: ");
				int itemId = sc.nextInt();
				sc.nextLine();
				registeredItems.get(itemId - 1).deleteItem();
				break;
			case 4:
				listServices();
				System.out.print("ID do serviço: ");
				int serviceId = sc.nextInt();
				sc.nextLine();
				registeredServices.get(serviceId - 1).deleteService();
				break;
			case 5:
				listPurchases();
				System.out.print("ID do compra: ");
				int purchaseId = sc.nextInt();
				sc.nextLine();
				registeredPurchases.get(purchaseId - 1).deletePurchase();
				break;
			}
			clearScreen();
		} while (menu != 0);
	}

	public static void clearScreen() {
		for (int i = 0; i < 30; i++) {
			System.out.println("\n");
		}
	}

	public static void pauseScreen() {
		System.out.println("\nPressione Enter para continuar...");
		sc.nextLine();
		clearScreen();
	}

}
