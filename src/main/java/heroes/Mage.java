package main.java.heroes;

public class Mage extends Hero {

    final private static int baseHealth = 100;
    final private static int baseStrength = 2;
    final private static int baseDexterity = 3;
    final private static int baseIntelligence = 10;

    final private static int expHealth = 15;
    final private static int expStrength = 1;
    final private static int expDexterity = 2;
    final private static int expIntelligence = 5;

    public Mage(){
        super(baseHealth,baseStrength,baseDexterity,baseIntelligence,expHealth,expStrength,expDexterity,expIntelligence);
    }
}
