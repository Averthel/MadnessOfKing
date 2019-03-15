package pl.ave.rpg.app;



import pl.ave.rpg.exception.DataExportException;
import pl.ave.rpg.exception.DataImportException;
import pl.ave.rpg.exception.NoSuchFileTypeException;
import pl.ave.rpg.exception.NoSuchOptionException;
import pl.ave.rpg.file.FileManager;
import pl.ave.rpg.file.FileManagerBuilder;
import pl.ave.rpg.model.Hero;
import pl.ave.rpg.model.Library;
import pl.ave.rpg.util.ConsolePrinter;
import pl.ave.rpg.util.DataReader;

import java.util.InputMismatchException;


public class GameControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader reader = new DataReader(printer);
    private FileManager fileManager;

    private Library library = new Library();

    GameControl() throws NoSuchFileTypeException {
        fileManager = new FileManagerBuilder(printer, reader).build();
        try{
            library = fileManager.importData();
            printer.printLine("Zaimportowane dane z pliku");
        }catch(DataImportException e){
            printer.printLine(e.getMessage());
            printer.printLine("Zainicjowano nową bazę.");
            library = new Library();
        }
    }


    public void controlLoop() {
        Option option;
        do {
            displayMenu();
            option = getOption();
            if (option == Option.NEW_GAME) {
                start();
                break;
            } else if (option == Option.ADD_HERO) {
                addHero();
            } else if (option == Option.SHOW_HERO) {
                showHero();
            }else if(option == Option.EXIT){
                exit();
            } else  {
                System.out.println("Ups! wygląda na to, że nie ma takiej opcji");
            }
        } while (option != Option.EXIT);
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
            printer.printLine("Nowy " + hero.toString());
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

    private void exit(){
        try{
            fileManager.exportData(library);
            printer.printLine("Export danych do pliku zakończony powodzeniem");
        }catch(DataExportException e){
            printer.printLine(e.getMessage());
        }
        reader.close();
        printer.printLine("Koniec programu, papa!");
    }

    private enum Option {
        EXIT(0, " - Exit game "),
        NEW_GAME(1, " - new game "),
        ADD_HERO(2, " - Create Hero "),
        SHOW_HERO(3, " - Show Hero!");


        private int value;
        private String description;

        Option(int value, String desc) {
            this.value = value;
            this.description = desc;
        }


        @Override
        public String toString() {
            return value + " - " + description;
        }

        public static Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("Nie ma opcji o numerze: " + option);
            }
        }
    }
}
