package main;

public class Player {

    private String name;
    private Pokemon pokemon;
    private int potions;

    public Player(String name, Pokemon pokemon) {

        this.name = name;
        this.pokemon = pokemon;
        this.potions = 2;
    }

    public String getName() {
        return name;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public int getPotions() {
        return potions;
    }

    public boolean usePotion() {

        if (potions > 0) {
            potions--;
            return true;
        }

        return false;
    }
}