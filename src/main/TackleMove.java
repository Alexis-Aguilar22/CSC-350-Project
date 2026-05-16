
package main;

import java.util.Random;

public class TackleMove implements MoveStrategy {

    private Random random;

    public TackleMove() {
        random = new Random();
    }

    @Override
    public int useMove() {
        return random.nextInt(10) + 5;
    }

    @Override
    public String getMoveName() {
        return "Tackle";
    }
}