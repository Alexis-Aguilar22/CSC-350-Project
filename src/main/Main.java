package main;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the Pokemon Battle Game!");

        GameManager gameManager =
                GameManager.getInstance();

        gameManager.startGame();
    }
}