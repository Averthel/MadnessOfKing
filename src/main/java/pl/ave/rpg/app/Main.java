package pl.ave.rpg.app;

public class Main {

    final static String GAME_NAME = "Madness Of King v0.3";

    public static void main(String[] args)  {
        System.out.println("Hello in "+ GAME_NAME);
        System.out.println();
        GameControl control = new GameControl();
        control.controlLoop();



    }
}
