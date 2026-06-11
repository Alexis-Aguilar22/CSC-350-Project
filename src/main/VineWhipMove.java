package main;

import java.util.Random;

public class VineWhipMove implements MoveStrategy {

    private Random random;

    public VineWhipMove() {
        random = new Random();
    }

    @Override
    public int useMove() {
        return random.nextInt(6) + 8;
    }

    @Override
    public String getMoveName() {
        return "Vine Whip";
    }
}