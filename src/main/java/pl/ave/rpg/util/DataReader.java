package pl.ave.rpg.util;

import pl.ave.rpg.model.Hero;
import pl.ave.rpg.model.heroClass.Lancer;
import pl.ave.rpg.model.heroClass.Mag;
import pl.ave.rpg.model.heroClass.Paladyn;

import java.util.Locale;
import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);
    private ConsolePrinter printer;


    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    public int getInt() {
        try{
            return sc.nextInt();
        }finally {
            sc.nextLine();
        }
    }

    public void close() {
        sc.close();
    }

    public Hero createHero() {
        printer.printLine("Podaj imię: ");
        String name = sc.nextLine();
        printer.printLine("Wybierz klase: ");
        displayClass();
        String className = sc.nextLine();
        String heroClassName = setHeroParameters(className);
        int level =1;
        int exp = 0;
        if(heroClassName.equals("Paladyn")){
            return new Paladyn(name, heroClassName, level, exp);
        }else if(heroClassName.equals("Mag")){
            return new Mag(name, heroClassName, level, exp);
        }else if (heroClassName.equals("Lancer")){
            return new Lancer(name, heroClassName, level, exp);
        }else
        return new Hero(name, heroClassName, level, exp);
    }

    private void displayClass() {
        printer.printLine(1 + " - Paladyn ");
        printer.printLine(2 + " - Mag ");
        printer.printLine(3 + " - Lancer");
    }

    private String setHeroParameters(String className) {
        if (className.equals("1") || className.equalsIgnoreCase("Paladyn")) {
            return "Paladyn";
        } else if (className.equals("2") || className.equalsIgnoreCase("Mag")) {
            return "Mag";
        } else if (className.equals("3") || className.equalsIgnoreCase("Lancer")) {
            return "Lancer";
        } else {
            return "Chytra baba z Radomia";
        }
    }
}
