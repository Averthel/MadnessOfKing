package pl.ave.rpg.app;


import pl.ave.rpg.Enum.Option;
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



    public void controlLoop()  {
        Option option;

        displayMenu();
        while ((option = Option.createFromInt(reader.getInt())) != Option.EXIT) {
            if (option == Option.NEW_GAME) {
                Test ts = new Test();
                ts.start(library);
                break;
            } else if (option == Option.ADD_HERO) {
                addHero();
            } else if (option == Option.SHOW_HERO) {
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
        for(Option option: Option.values()){
            System.out.println(option);
        }
    }

    private void addHero() {
        Hero hero = reader.createHero();
        library.addHero(hero);
    }
}
