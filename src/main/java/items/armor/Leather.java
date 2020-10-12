package main.java.items.armor;

import main.java.items.Item;
import main.java.items.SLOT;

public class Leather extends Armor implements Item {

    final private static int baseBonusHealth = 20;
    final  private static int baseBonusStrength = 1;
    final private static int baseBonusDexterity = 3;
    final private static int baseBonusIntelligence = 0;

    final  private static int levelBonusHealth = 8;
    final private static int levelBonusStrength = 1;
    final private static int levelBonusDexterity = 2;
    final private static int levelBonusIntelligence = 0;

    public Leather(String name , int level, SLOT slot){
        super(name,level,slot,baseBonusHealth,baseBonusStrength,baseBonusDexterity,baseBonusIntelligence,
                levelBonusHealth,levelBonusStrength,levelBonusDexterity,levelBonusIntelligence);
    }
}
