package main.java.items.armor;

import main.java.items.Item;
import main.java.items.SLOT;

public class Plate extends Armor implements Item {

    final private static int baseBonusHealth = 30;
    final private static int baseBonusStrength = 3;
    final private static int baseBonusDexterity = 1;
    final private static int baseBonusIntelligence = 0;

    final private static int levelBonusHealth = 12;
    final private static int levelBonusStrength = 2;
    final private static int levelBonusDexterity = 1;
    final private static int levelBonusIntelligence = 0;

    public Plate(String name , int level, SLOT slot){
        super(name,level,slot,baseBonusHealth,baseBonusStrength,baseBonusDexterity,baseBonusIntelligence,
                levelBonusHealth,levelBonusStrength,levelBonusDexterity,levelBonusIntelligence);

    }
}
