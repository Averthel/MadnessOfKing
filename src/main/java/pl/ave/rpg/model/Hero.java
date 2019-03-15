package pl.ave.rpg.model;


import java.io.Serializable;

public abstract class Hero  implements Serializable {
    private String name;
    private String className;
    private int level;
    private int experience;


    public Hero(String name, String className, int level, int exp) {
        this.name = name;
        this.className = className;
        this.level = level;
        this.experience = exp;

    }


    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }


    @Override
    public String toString() {
        return "Bohater: " + getName() +
                " " + " Klasa: " + getClassName() + "\n"+
                "Statystyki => ";
    }

    public String printEq() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero)) return false;

        Hero hero = (Hero) o;

        if (getLevel() != hero.getLevel()) return false;
        if (getExperience() != hero.getExperience()) return false;
        if (getName() != null ? !getName().equals(hero.getName()) : hero.getName() != null) return false;
        return getClassName() != null ? getClassName().equals(hero.getClassName()) : hero.getClassName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getClassName() != null ? getClassName().hashCode() : 0);
        result = 31 * result + getLevel();
        result = 31 * result + getExperience();
        return result;
    }
}

