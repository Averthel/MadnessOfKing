package pl.ave.rpg.model;

public class Library {
    private static final int MAX_HERO = 10;
    private Hero[] heroes = new Hero[MAX_HERO];
    private int existedHero;


    public void addHero(Hero hero) {
        if (existedHero >= MAX_HERO) {
            throw new ArrayIndexOutOfBoundsException("Osiągnięto maxymalną liczbę bohaterów");
        }
        heroes[existedHero] = hero;
        existedHero++;

    }

    public Hero[] getAllHero(){
        Hero[] result = new Hero[existedHero];
        for (int i = 0; i <existedHero ; i++) {
            result[i] = heroes[i];
        }
        return result;
    }

    public Hero getHero(int index) {
        return heroes[index - 1];
    }


}
