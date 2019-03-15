package pl.ave.rpg.app;

import pl.ave.rpg.exception.NoSuchFileTypeException;

public class Main {

    final static String GAME_NAME = "Madness Of King v0.3";

    public static void main(String[] args) throws NoSuchFileTypeException {
        System.out.println("Hello in "+ GAME_NAME);
        System.out.println();
        GameControl control = new GameControl();
        control.controlLoop();



    }
}
