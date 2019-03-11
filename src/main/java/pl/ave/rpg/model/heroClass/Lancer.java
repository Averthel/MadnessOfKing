package pl.ave.rpg.model.heroClass;

import pl.ave.rpg.model.Hero;

import java.util.Arrays;

public class Lancer extends Hero {
    private int hp;
    private int str;
    private String[] eq;

    public Lancer(String name, String className, int level, int exp){
        super(name, className, level, exp);
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

    @Override
    public String printEq(){
        StringBuilder builder = new StringBuilder();
        int freeSpace = 0;
        for(int i=0; i<eq.length; i++){
            if(eq[i] == null){
                freeSpace++;
                continue;
            }
            builder.append(", ");
        }
        builder.append("\n");
        builder.append("Liczba wolnych miejsc w ekwpinku: "+freeSpace);
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lancer)) return false;
        if (!super.equals(o)) return false;

        Lancer lancer = (Lancer) o;

        if (getHp() != lancer.getHp()) return false;
        if (getStr() != lancer.getStr()) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getEq(), lancer.getEq());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getHp();
        result = 31 * result + getStr();
        result = 31 * result + Arrays.hashCode(getEq());
        return result;
    }
}
