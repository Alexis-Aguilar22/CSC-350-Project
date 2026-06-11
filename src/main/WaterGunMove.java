package main;

import java.util.Random;

public class WaterGunMove implements MoveStrategy {

    private Random random;

    public WaterGunMove() {
        random = new Random();
    }

    @Override
    public int useMove() {
        return random.nextInt(6) + 8;
    }

    @Override
    public String getMoveName() {
        return "Water Gun";
    }
}