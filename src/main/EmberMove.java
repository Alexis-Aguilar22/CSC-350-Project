package main;

import java.util.Random;

public class EmberMove implements MoveStrategy {

    private Random random;

    public EmberMove() {
        random = new Random();
    }

    @Override
    public int useMove() {
        return random.nextInt(6) + 8;
    }

    @Override
    public String getMoveName() {
        return "Ember";
    }
}