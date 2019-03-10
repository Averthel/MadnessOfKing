package pl.ave.rpg.logic;

import pl.ave.rpg.model.Hero;
import pl.ave.rpg.model.heroClass.Lancer;
import pl.ave.rpg.model.heroClass.Mag;
import pl.ave.rpg.model.heroClass.Paladyn;

public class Experience {


    public void checkForLevelUp(Hero hero){
        setLevel(hero, hero.getExperience());
        setStats(hero);
    }


    private void setLevel(Hero hero, int experience) {
        if (experience >= 100 && experience <1000) {
            hero.setLevel(2);
        } else if (experience >= 1000 && experience <3000 ) {
            hero.setLevel(3);
        } else if (experience >= 3000 && experience <6000 ) {
            hero.setLevel(4);
        } else if (experience >= 6000 && experience <10000) {
            hero.setLevel(5);
        } else if (experience >= 10000 && experience <15000) {
            hero.setLevel(6);
        } else if (experience >= 15000 && experience <25000) {
            hero.setLevel(7);
        } else if (experience >= 25000 && experience <40000) {
            hero.setLevel(8);
        } else if (experience >= 40000 && experience <60000) {
            hero.setLevel(9);
        } else if (experience >= 60000) {
            hero.setLevel(10);
        }
    }

    private void setStats(Hero hero) {
        if (hero.getClassName().equals("Paladyn")) {
            setPaladynStats((Paladyn) hero);
        } else if (hero.getClassName().equals("Mag")) {
            setMagStats((Mag) hero);
        } else if (hero.getClassName().equals("Lancer")) {
            setLancerStats((Lancer) hero);
        }

    }

    private void setPaladynStats(Paladyn hero) {
        hero.setStr(hero.getStr() + (2 * hero.getLevel()));
        hero.setHp(hero.getHp() + (30 * (hero.getLevel())));
    }

    private void setMagStats(Mag hero) {
        hero.setStr(hero.getStr() + (1 * hero.getLevel()));
        hero.setHp(hero.getHp() + (10 * (hero.getLevel())));
        hero.setMana(hero.getMana() + (20 * hero.getLevel()));
    }

    private void setLancerStats(Lancer hero) {
        hero.setStr(hero.getStr() + (3 * hero.getLevel()));
        hero.setHp(hero.getHp() + (20 * (hero.getLevel())));
    }

}
