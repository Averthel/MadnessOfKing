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
            System.out.println("Brak bohaterów");
        }
        for (int i = 0; i < existedHero ; i++) {
            System.out.println((i+1)+" -> "+heroes[i].getName()+" "+heroes[i].getClassName()
                    +", level "+ heroes[i].getLevel());
        }
        System.out.println();
    }

    public Hero getHero(int index){
        return heroes[index-1];
    }




}
