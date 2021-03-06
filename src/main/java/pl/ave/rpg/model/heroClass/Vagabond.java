package pl.ave.rpg.model.heroClass;

import pl.ave.rpg.model.Hero;

import java.util.Arrays;

public class Vagabond extends Hero {
    private int hp;
    private int str;
    private String[] eq;


    public Vagabond(String name, String className, int level, int exp) {
        super(name, className, level, exp);
        hp = 80;
        str = 10;
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
        return "Vagabond{" +
                "hp=" + hp +
                ", str=" + str +
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
        if (!(o instanceof Vagabond)) return false;
        if (!super.equals(o)) return false;

        Vagabond vagabond = (Vagabond) o;

        if (getHp() != vagabond.getHp()) return false;
        if (getStr() != vagabond.getStr()) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getEq(), vagabond.getEq());
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
