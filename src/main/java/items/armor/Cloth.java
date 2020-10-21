package main.java.items.armor;

import main.java.items.Item;
import main.java.items.Slot;

public class Cloth extends Armor implements Item {

    final private static int baseBonusHealth = 10;
    final private static int baseBonusStrength = 0;
    final private static int baseBonusDexterity = 1;
    final private static int baseBonusIntelligence = 3;

    final private static int levelBonusHealth = 5;
    final private static int levelBonusStrength = 0;
    final private static int levelBonusDexterity = 1;
    final private static int levelBonusIntelligence = 2;

    public Cloth(String name, int level, Slot slot) {
        super(name, level, slot, baseBonusHealth, baseBonusStrength, baseBonusDexterity, baseBonusIntelligence,
                levelBonusHealth, levelBonusStrength, levelBonusDexterity, levelBonusIntelligence);
    }
}
