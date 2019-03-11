package pl.ave.rpg.util;

import pl.ave.rpg.model.Hero;


public class ConsolePrinter {

    public void printHeroList(Hero[] heroes){
        int count = 0;
        for(Hero hero: heroes){
            printLine(hero.getName()+" "+hero.getClassName()+" "+", level: "+hero.getLevel());
            count++;
        }if(count == 0){
            printLine("Brak bohaterów");
        }
    }


    public void printLine(String text){
        System.out.println(text);
    }
}
