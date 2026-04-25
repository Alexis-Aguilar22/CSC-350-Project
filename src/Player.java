//
package main;

public class Player {
    private String name;
    private Pokemon pokemon;

    public Player(String name, Pokemon pokemon) {
        this.name = name;
        this.pokemon = pokemon;
    }

    public String getName() {
        return name;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }
}
