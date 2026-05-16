
package main;

public class PokemonFactory {

    public static Pokemon createStarterPokemon(int choice) {

        MoveStrategy tackle = new TackleMove();

        switch (choice) {
            case 1:
                return new Pokemon("Charmander", 100, tackle);

            case 2:
                return new Pokemon("Squirtle", 100, tackle);

            case 3:
                return new Pokemon("Bulbasaur", 100, tackle);

            default:
                System.out.println("Invalid choice. Defaulting to Charmander.");
                return new Pokemon("Charmander", 100, tackle);
        }
    }

    public static Pokemon createWildPokemon() {

        MoveStrategy tackle = new TackleMove();

        return new Pokemon("Pidgey", 80, tackle);
    }
}