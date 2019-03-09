package pl.ave.rpg.model;

public class Library {
    private static final int MAX_HERO = 10;
    private Hero[] heroes = new Hero[MAX_HERO];
    private int existedHero;


    public void addHero(Hero hero){
        if(existedHero < MAX_HERO){
            heroes[existedHero] = hero;
            existedHero++;
        }else{
            System.out.println("Osiągnięto maxymalną ilość bohaterów");
        }
    }

    public void printHero(){
        if(existedHero == 0){
            System.out.println("brak bohaterów");
        }
        for (int i = 0; i < existedHero ; i++) {
            System.out.println(heroes[i].toString());
        }
    }


}
