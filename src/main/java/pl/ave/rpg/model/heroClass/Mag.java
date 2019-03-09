package pl.ave.rpg.model.heroClass;

import pl.ave.rpg.model.Hero;

import java.util.Arrays;

public class Mag extends Hero {
    private int hp;
    private int str;
    private int mana;
    String eq[];

    public Mag(String name, String className){
        super(name, className);
        hp = 100;
        str = 8;
        mana = 200;
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

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
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
                ", mana=" + mana +
                ", eq=" + Arrays.toString(eq) +
                '}';
    }
}