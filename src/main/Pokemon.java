package main;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {

    private String name;
    private int health;
    private int maxHealth;
    private int level;
    private int experience;
    private int starterType;

    private MoveStrategy moveStrategy;

    private List<BattleObserver> observers;

    public Pokemon(String name,
                   int health,
                   MoveStrategy moveStrategy,
                   int starterType) {

        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.level = 5;
        this.experience = 0;
        this.starterType = starterType;

        this.moveStrategy = moveStrategy;

        observers = new ArrayList<>();
    }

    public void addObserver(BattleObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {

        for (BattleObserver observer : observers) {
            observer.update(message);
        }
    }

    public int attack() {
        return moveStrategy.useMove();
    }

    public void gainExperience(int amount) {

        experience += amount;

        notifyObservers(
                name + " gained "
                        + amount
                        + " experience."
        );

        while (experience >= 50) {

            experience -= 50;

            level++;

            maxHealth += 5;

            health = maxHealth;

            notifyObservers(
                    name + " leveled up to Level "
                            + level + "!"
            );

            if (level == 7) {

                switch (starterType) {

                    case 1:
                        moveStrategy = new EmberMove();

                        notifyObservers(
                                name + " learned Ember!"
                        );
                        break;

                    case 2:
                        moveStrategy = new WaterGunMove();

                        notifyObservers(
                                name + " learned Water Gun!"
                        );
                        break;

                    case 3:
                        moveStrategy = new VineWhipMove();

                        notifyObservers(
                                name + " learned Vine Whip!"
                        );
                        break;
                }
            }
        }
    }

    public void fullyHeal() {

        health = maxHealth;

        notifyObservers(
                name + " was fully healed!"
        );
    }

    public void takeDamage(int damage) {

        health -= damage;

        if (health < 0) {
            health = 0;
        }

        notifyObservers(
                name + " now has "
                        + health
                        + " HP."
        );
    }

    public void heal(int amount) {

        health += amount;

        if (health > maxHealth) {
            health = maxHealth;
        }

        notifyObservers(
                name + " healed and now has "
                        + health
                        + " HP."
        );
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getStarterType() {
        return starterType;
    }
}