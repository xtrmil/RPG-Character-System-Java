package main.java.items;

public enum SLOT {
    HEAD("Head"),
    BODY("Body"),
    LEGS("Legs"),
    MAINWEAPON("MainWeapon");

    public final String label;

    SLOT(String label) {
        this.label = label;
    }
}
