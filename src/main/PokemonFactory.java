package main;

import java.util.Random;

public class PokemonFactory {

    public static Pokemon createStarterPokemon(int choice) {

        switch (choice) {

            case 1:
                return new Pokemon(
                        "Charmander",
                        40,
                        new TackleMove(),
                        1
                );

            case 2:
                return new Pokemon(
                        "Squirtle",
                        40,
                        new TackleMove(),
                        2
                );

            case 3:
                return new Pokemon(
                        "Bulbasaur",
                        40,
                        new TackleMove(),
                        3
                );

            default:
                return new Pokemon(
                        "Charmander",
                        40,
                        new TackleMove(),
                        1
                );
        }
    }

    public static Pokemon createWildPokemon() {

        Random random = new Random();

        MoveStrategy tackle = new TackleMove();

        int choice = random.nextInt(4);

        switch (choice) {

            case 0:
                return new Pokemon(
                        "Pidgey",
                        25,
                        tackle,
                        0
                );

            case 1:
                return new Pokemon(
                        "Rattata",
                        25,
                        tackle,
                        0
                );

            case 2:
                return new Pokemon(
                        "Caterpie",
                        20,
                        tackle,
                        0
                );

            default:
                return new Pokemon(
                        "Weedle",
                        20,
                        tackle,
                        0
                );
        }
    }
}