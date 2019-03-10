package pl.ave.rpg.model.heroClass;

import pl.ave.rpg.model.Hero;

import java.util.Arrays;

public class Mag extends Hero {
    private int hp;
    private int str;
    private int mana;
    private String eq[];

    public Mag(String name, String className, int level, int exp){
        super(name, className, level, exp);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mag)) return false;
        if (!super.equals(o)) return false;

        Mag mag = (Mag) o;

        if (getHp() != mag.getHp()) return false;
        if (getStr() != mag.getStr()) return false;
        if (getMana() != mag.getMana()) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getEq(), mag.getEq());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getHp();
        result = 31 * result + getStr();
        result = 31 * result + getMana();
        result = 31 * result + Arrays.hashCode(getEq());
        return result;
    }
}
