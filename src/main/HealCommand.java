package main;

public class HealCommand implements BattleCommand {

    private Pokemon pokemon;

    public HealCommand(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public void execute() {

        pokemon.heal(20);

        System.out.println(
                pokemon.getName()
                        + " healed 20 HP!"
        );
    }
}