package pl.ave.rpg.app;


import pl.ave.rpg.enums.Option;
import pl.ave.rpg.exception.NoSuchOptionException;
import pl.ave.rpg.model.Hero;
import pl.ave.rpg.model.Library;
import pl.ave.rpg.util.ConsolePrinter;
import pl.ave.rpg.util.DataReader;

import java.util.InputMismatchException;


public class GameControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader reader = new DataReader(printer);

    private Library library = new Library();


    public void controlLoop() {
        Option option;
        do {
            displayMenu();
            option = getOption();
            if (option == Option.NEW_GAME) {

                break;
            } else if (option == Option.ADD_HERO) {
                addHero();
            } else if (option == Option.SHOW_HERO) {
                showHero();
            } else {
                System.out.println("Ups! wygląda na to, że nie ma takiej opcji");
            }
        } while (option != Option.EXIT);
        System.out.println("Koniec gry, papa!");
        reader.close();

    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = Option.createFromInt(reader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage() + ", podaj ponownie:");
            } catch (InputMismatchException e) {
                printer.printLine("Wprowadzono wartość, która nie jest liczbą, podaj ponownie:");
            }
        }
        return option;
    }

    private void displayMenu() {
        for (Option option : Option.values()) {
            printer.printLine(option.toString());
        }
    }

    private void addHero() {
        try {
            Hero hero = reader.createHero();
            library.addHero(hero);
        } catch (InputMismatchException e) {
            printer.printLine("NIe udało się stworzyć bohatera, wprowadzono niepoprawne dane");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osiągnięto limit bohaterów");
        }
    }

    private void showHero() {
        Hero[] hero = library.getAllHero();
        printer.printHeroList(hero);
    }
}
