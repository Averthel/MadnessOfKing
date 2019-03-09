package pl.ave.rpg.app;

import pl.ave.rpg.model.Hero;
import pl.ave.rpg.model.Library;
import pl.ave.rpg.util.DataReader;


public class GameControl {
    private static final int EXIT = 0;
    private static final int NEW_GAME = 1;
    private static final int ADD_HERO = 2;
    private static final int SHOW_HERO = 3;

    DataReader reader = new DataReader();
    private Library library = new Library();

    int option;
    public void controlLoop() {
        displayMenu();
        while ((option = reader.getint()) != EXIT) {
            if (option == NEW_GAME) {

            } else if (option == ADD_HERO) {
                addHero();
            } else if (option == SHOW_HERO) {
                library.printHero();
            } else {
                System.out.println("Ups! wygląda na to, że nie ma takiej opcji");
            }
            displayMenu();
        }
        System.out.println("Koniec gry, papa!");
        reader.close();

    }

    private void displayMenu() {
        System.out.println(NEW_GAME + " - new game ");
        System.out.println(ADD_HERO + " - Create Hero ");
        System.out.println(SHOW_HERO + " - Show Hero!");
        System.out.println(EXIT + " - Exit game ");
    }

    private void addHero() {
        Hero hero = reader.createHero();
        library.addHero(hero);
    }
}
