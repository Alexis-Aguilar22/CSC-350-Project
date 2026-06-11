package main;

public class AttackCommand implements BattleCommand {

    private Pokemon attacker;
    private Pokemon target;

    public AttackCommand(Pokemon attacker, Pokemon target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {

        int damage = attacker.attack();

        target.takeDamage(damage);

        System.out.println(
                attacker.getName()
                        + " used Tackle! It dealt "
                        + damage
                        + " damage!"
        );
    }
}