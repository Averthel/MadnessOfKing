package pl.ave.rpg.enums;

import pl.ave.rpg.exception.NoSuchOptionException;

public enum Option {
    EXIT(0, " - Exit game "),
    NEW_GAME(1, " - new game "),
    ADD_HERO(2, " - Create Hero "),
    SHOW_HERO(3, " - Show Hero!");


    private int value;
    private String description;

     Option(int value, String desc){
        this.value = value;
        this.description = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }

    public static Option createFromInt(int option) throws NoSuchOptionException {
        try {
            return Option.values()[option];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException("Nie ma opcji o numerze: " + option);
        }
    }
}
