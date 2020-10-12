package main.java.heroes;

public class Warrior extends Hero {

    final private static int baseHealth = 150;
    final private static int baseStrength = 10;
    final private static int baseDexterity = 3;
    final private static int baseIntelligence = 1;

    final private static int expHealth = 30;
    final private static int expStrength = 5;
    final private static int expDexterity = 2;
    final private static int expIntelligence = 1;

    public Warrior(){
        super(baseHealth,baseStrength,baseDexterity,baseIntelligence,expHealth,expStrength,expDexterity,expIntelligence);
    }
}
