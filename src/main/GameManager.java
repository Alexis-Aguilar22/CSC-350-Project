package main;

import java.util.Scanner;

public class GameManager {
    private Player player;
    private Pokemon enemyPokemon;
    private Move tackle;
    private Scanner scanner;

    public GameManager() {
        scanner = new Scanner(System.in);
        tackle = new Move("Tackle");
    }

    public void startGame() {
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        Pokemon starter = chooseStarter();

        player = new Player(playerName, starter);
        enemyPokemon = new Pokemon("Pidgey", 80);

        System.out.println("\nYou chose " + starter.getName() + "!");
        System.out.println("A wild " + enemyPokemon.getName() + " appeared!");

        gameLoop();
    }

    private Pokemon chooseStarter() {
        System.out.println("Choose your starter Pokemon:");
        System.out.println("1. Charmander");
        System.out.println("2. Squirtle");
        System.out.println("3. Bulbasaur");

        int choice = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        switch (choice) {
            case 1:
                return new Pokemon("Charmander", 100);
            case 2:
                return new Pokemon("Squirtle", 100);
            case 3:
                return new Pokemon("Bulbasaur", 100);
            default:
                System.out.println("Invalid choice, defaulting to Charmander.");
                return new Pokemon("Charmander", 100);
        }
    }

    private void gameLoop() {
        Pokemon playerPokemon = player.getPokemon();

        while (playerPokemon.isAlive() && enemyPokemon.isAlive()) {
            System.out.println("\n--- STATUS ---");
            System.out.println(playerPokemon.getName() + " HP: " + playerPokemon.getHealth());
            System.out.println(enemyPokemon.getName() + " HP: " + enemyPokemon.getHealth());

            System.out.println("\nChoose an action:");
            System.out.println("1. Use Tackle");
            System.out.println("2. Heal");

            int choice = scanner.nextInt();

            if (choice == 1) {
                int damage = tackle.useMove();
                enemyPokemon.takeDamage(damage);
                System.out.println(playerPokemon.getName() + " used Tackle! It dealt " + damage + " damage!");
            } else if (choice == 2) {
                playerPokemon.heal(10);
                System.out.println(playerPokemon.getName() + " healed 10 HP!");
            } else {
                System.out.println("Invalid choice.");
                continue;
            }

            if (enemyPokemon.isAlive()) {
                int enemyDamage = tackle.useMove();
                playerPokemon.takeDamage(enemyDamage);
                System.out.println(enemyPokemon.getName() + " used Tackle! It dealt " + enemyDamage + " damage!");
            }
        }

        if (playerPokemon.isAlive()) {
            System.out.println("\nYou win!");
        } else {
            System.out.println("\nYou lost...");
        }
    }
}
