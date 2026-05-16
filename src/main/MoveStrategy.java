package main;

import java.util.Random;

public class MoveStrategy {
    private String name;
    private Random random;

    public MoveStrategy(String name) {
        this.name = name;
        this.random = new Random();
    }

    public int useMove() {
        return random.nextInt(10) + 5; // 5–14 damage
    }

    public String getName() {
        return name;
    }
}
