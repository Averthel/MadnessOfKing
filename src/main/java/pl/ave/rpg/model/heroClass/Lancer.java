package pl.ave.rpg.model.heroClass;

import pl.ave.rpg.model.Hero;

import java.util.Arrays;

public class Lancer extends Hero {
    private int hp;
    private int str;
    private String[] eq;

    public Lancer(String name, String className){
        super(name, className);
        hp = 120;
        str = 15;
        eq = new String[10];
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public String[] getEq() {
        return eq;
    }

    public void setEq(String[] eq) {
        this.eq = eq;
    }

    @Override
    public String toString() {
        return super.toString() + " {" +
                "hp=" + hp +
                ", str=" + str +
                ", eq=" + Arrays.toString(eq) +
                '}';
    }
}
