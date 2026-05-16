package main;

public class Pokemon {
    private String name;
    private int health;
    private MoveStrategy moveStrategy;

    public Pokemon(String name, int health, MoveStrategy moveStrategy) {
        this.name = name;
        this.health = health;
        this.moveStrategy = moveStrategy;
    }

    public int attack() {
        return moveStrategy.useMove();
    }

    public void takeDamage(int damage) {
        health -= damage;

        if (health < 0) {
            health = 0;
        }
    }

    public void heal(int amount) {
        health += amount;
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
}