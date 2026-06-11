package main;

public class ConsoleBattleObserver implements BattleObserver {

    @Override
    public void update(String message) {
        System.out.println(message);
    }
}