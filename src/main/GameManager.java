package main;

import java.util.Scanner;

public class GameManager {

    private static GameManager instance;

    private Player player;
    private Pokemon enemyPokemon;
    private Scanner scanner;
    private BattleState currentState;

    private GameManager() {
        scanner = new Scanner(System.in);
    }

    public static GameManager getInstance() {

        if (instance == null) {
            instance = new GameManager();
        }

        return instance;
    }

    public void startGame() {

        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        int starterChoice = chooseStarter();

        Pokemon starterPokemon =
                PokemonFactory.createStarterPokemon(starterChoice);

        player = new Player(playerName, starterPokemon);

        enemyPokemon =
                PokemonFactory.createWildPokemon();

        BattleObserver observer =
                new ConsoleBattleObserver();

        starterPokemon.addObserver(observer);
        enemyPokemon.addObserver(observer);

        System.out.println(
                "\nYou chose "
                        + starterPokemon.getName()
                        + "!"
        );

        System.out.println(
                "A wild "
                        + enemyPokemon.getName()
                        + " appeared!"
        );

        gameLoop();
    }

    private int chooseStarter() {

        System.out.println("Choose your starter Pokemon:");
        System.out.println("1. Charmander");
        System.out.println("2. Squirtle");
        System.out.println("3. Bulbasaur");

        String choice =
                scanner.nextLine().toLowerCase();

        switch (choice) {

            case "1":
            case "charmander":
                return 1;

            case "2":
            case "squirtle":
                return 2;

            case "3":
            case "bulbasaur":
                return 3;

            default:
                System.out.println(
                        "Invalid choice. Defaulting to Charmander."
                );
                return 1;
        }
    }

    private void gameLoop() {

        Pokemon playerPokemon =
                player.getPokemon();

        while (playerPokemon.isAlive()
                && enemyPokemon.isAlive()) {

            currentState =
                    new PlayerTurnState();

            System.out.println(
                    "\nState: "
                            + currentState.getStateName()
            );

            System.out.println("\n--- STATUS ---");

            System.out.println(
                    playerPokemon.getName()
                            + " HP: "
                            + playerPokemon.getHealth()
            );

            System.out.println(
                    enemyPokemon.getName()
                            + " HP: "
                            + enemyPokemon.getHealth()
            );

            System.out.println("\nChoose an action:");
            System.out.println("1. Attack");
            System.out.println(
                    "2. Use Potion (" +
                            player.getPotions() +
                            " left)"
            );

            int choice =
                    scanner.nextInt();

            BattleCommand command;

            if (choice == 1) {

                command =
                        new AttackCommand(
                                playerPokemon,
                                enemyPokemon
                        );

                command.execute();

            } else if (choice == 2) {

                if (player.usePotion()) {

                    command =
                            new HealCommand(
                                    playerPokemon
                            );

                    command.execute();

                } else {

                    System.out.println(
                            "You have no potions left!"
                    );

                    continue;
                }
            } else {

                System.out.println("Invalid choice.");
                continue;
            }

            currentState =
                    new EnemyTurnState();

            System.out.println(
                    "\nState: "
                            + currentState.getStateName()
            );

            if (enemyPokemon.isAlive()) {

                BattleCommand enemyAttack =
                        new AttackCommand(
                                enemyPokemon,
                                playerPokemon
                        );

                enemyAttack.execute();
            }
        }

        currentState =
                new GameOverState();

        System.out.println(
                "\nState: "
                        + currentState.getStateName()
        );

        if (playerPokemon.isAlive()) {

            System.out.println("\nYou win!");

            playerPokemon.gainExperience(20);

            postBattleMenu();

        } else {

            System.out.println("\nYou lost...");
        }
    }

    private void postBattleMenu() {

        scanner.nextLine();

        while (true) {

            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Continue Walking");
            System.out.println("2. Pokemon Center");
            System.out.println("3. Quit");

            int choice = scanner.nextInt();

            if (choice == 1) {

                enemyPokemon =
                        PokemonFactory.createWildPokemon();

                BattleObserver observer =
                        new ConsoleBattleObserver();

                enemyPokemon.addObserver(observer);

                System.out.println(
                        "\nA wild "
                                + enemyPokemon.getName()
                                + " appeared!"
                );

                gameLoop();
                return;

            } else if (choice == 2) {

                player.getPokemon().fullyHeal();

                System.out.println(
                        "\nYour Pokemon was healed at the Pokemon Center."
                );

            } else if (choice == 3) {

                Pokemon pokemon =
                        player.getPokemon();

                System.out.println("\n===== TRAINER STATS =====");

                System.out.println(
                        "Trainer: "
                                + player.getName());

                System.out.println(
                        "Pokemon: "
                                + pokemon.getName());

                System.out.println(
                        "Level: "
                                + pokemon.getLevel());

                System.out.println(
                        "Experience: "
                                + pokemon.getExperience());

                System.out.println(
                        "Potions Remaining: "
                                + player.getPotions());

                System.out.println(
                        "\nThanks for playing!"
                );

                System.exit(0);
            }
        }
    }
}