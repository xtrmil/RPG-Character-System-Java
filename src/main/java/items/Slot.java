package main.java.items;

public enum Slot {
    HEAD("Head"),
    BODY("Body"),
    LEGS("Legs"),
    MAINWEAPON("MainWeapon");

    public final String label;

    Slot(String label) {
        this.label = label;
    }
}
