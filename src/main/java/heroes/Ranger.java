package main.java.heroes;

public class Ranger extends Hero {

    final private static int baseHealth = 120;
    final private static int baseStrength = 5;
    final private static int baseDexterity = 10;
    final private static int baseIntelligence = 2;

    final private static int expHealth = 20;
    final private static int expStrength = 2;
    final private static int expDexterity = 5;
    final private static int expIntelligence = 1;

    public Ranger(){
        super(baseHealth,baseStrength,baseDexterity,baseIntelligence,expHealth,expStrength,expDexterity,expIntelligence);
    }
}
