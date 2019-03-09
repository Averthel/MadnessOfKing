package pl.ave.rpg.util;

import pl.ave.rpg.model.Hero;
import pl.ave.rpg.model.heroClass.Lancer;
import pl.ave.rpg.model.heroClass.Mag;
import pl.ave.rpg.model.heroClass.Paladyn;

import java.util.Locale;
import java.util.Scanner;

public class DataReader {

    private Scanner sc;


    public DataReader() {
        sc = new Scanner(System.in);
        sc.useLocale(Locale.GERMANY);
    }

    public int getint() {
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    }

    public void close() {
        sc.close();
    }

    public Hero createHero() {
        System.out.println("Podaj imię: ");
        String name = sc.nextLine();
        System.out.println("Wybierz klase: ");
        displayClass();
        String className = sc.nextLine();
        String heroClassName = setHeroParameters(className);
        if(heroClassName.equals("Paladyn")){
            return new Paladyn(name, heroClassName);
        }else if(heroClassName.equals("Mag")){
            return new Mag(name, heroClassName);
        }else if (heroClassName.equals("Lancer")){
            return new Lancer(name, heroClassName);
        }else
        return new Hero(name, heroClassName);
    }

    private void displayClass() {
        System.out.println(1 + " - Paladyn ");
        System.out.println(2 + " - Mag ");
        System.out.println(3 + " - Lancer");
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
