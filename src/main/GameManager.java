
package main;

import java.util.Scanner;

public class GameManager {

    private Player player;
    private Pokemon enemyPokemon;
    private Scanner scanner;

    public GameManager() {
        scanner = new Scanner(System.in);
    }

    public void startGame() {

        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        int starterChoice = chooseStarter();

        Pokemon starterPokemon =
                PokemonFactory.createStarterPokemon(starterChoice);

        player = new Player(playerName, starterPokemon);

        enemyPokemon = PokemonFactory.createWildPokemon();

        System.out.println("\nYou chose "
                + starterPokemon.getName() + "!");

        System.out.println("A wild "
                + enemyPokemon.getName()
                + " appeared!");

        gameLoop();
    }

    private int chooseStarter() {

        System.out.println("Choose your starter Pokemon:");
        System.out.println("1. Charmander");
        System.out.println("2. Squirtle");
        System.out.println("3. Bulbasaur");

        return scanner.nextInt();
    }

    private void gameLoop() {

        Pokemon playerPokemon = player.getPokemon();

        while (playerPokemon.isAlive()
                && enemyPokemon.isAlive()) {

            System.out.println("\n--- STATUS ---");

            System.out.println(
                    playerPokemon.getName()
                            + " HP: "
                            + playerPokemon.getHealth());

            System.out.println(
                    enemyPokemon.getName()
                            + " HP: "
                            + enemyPokemon.getHealth());

            System.out.println("\nChoose an action:");
            System.out.println("1. Use Move");
            System.out.println("2. Heal");

            int choice = scanner.nextInt();

            if (choice == 1) {

                int damage = playerPokemon.attack();

                enemyPokemon.takeDamage(damage);

                System.out.println(
                        playerPokemon.getName()
                                + " used Tackle! It dealt "
                                + damage
                                + " damage!");

            } else if (choice == 2) {

                playerPokemon.heal(10);

                System.out.println(
                        playerPokemon.getName()
                                + " healed 10 HP!");

            } else {

                System.out.println("Invalid choice.");
                continue;
            }

            if (enemyPokemon.isAlive()) {

                int enemyDamage = enemyPokemon.attack();

                playerPokemon.takeDamage(enemyDamage);

                System.out.println(
                        enemyPokemon.getName()
                                + " used Tackle! It dealt "
                                + enemyDamage
                                + " damage!");
            }
        }

        if (playerPokemon.isAlive()) {

            System.out.println("\nYou win!");

        } else {

            System.out.println("\nYou lost...");
        }
    }
}