package pl.ave.rpg.model;

import java.util.Arrays;

public class Hero {
    private String name;
    private String className;


    public Hero(String name, String className) {
        this.name = name;
        this.className = className;

    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
