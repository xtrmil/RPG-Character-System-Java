package main.java.items.armor;

import main.java.items.Item;
import main.java.items.ITEMTYPE;
import main.java.items.SLOT;

public abstract class Armor implements Item{

    final private int baseBonusHealth,baseBonusStrength,baseBonusDexterity,baseBonusIntelligence;
    final private int levelBonusHealth,levelBonusStrength,levelBonusDexterity,levelBonusIntelligence;
    private int level;
    private SLOT slot;
    private String name;
    private ITEMTYPE itemType = ITEMTYPE.ARMOR;
    protected Armor(String name,int level,SLOT slot, int baseBonusHealth,int baseBonusStrength,int baseBonusDexterity,int baseBonusIntelligence,
                int levelBonusHealth,int levelBonusStrength,int levelBonusDexterity,int levelBonusIntelligence){

        this.name = name;
        this.level = level;
        this.slot = slot;
        this.baseBonusHealth = baseBonusHealth;
        this.baseBonusStrength = baseBonusStrength;
        this.baseBonusDexterity = baseBonusDexterity;
        this.baseBonusIntelligence = baseBonusIntelligence;

        this.levelBonusHealth = levelBonusHealth;
        this.levelBonusStrength = levelBonusStrength;
        this.levelBonusDexterity = levelBonusDexterity;
        this.levelBonusIntelligence = levelBonusIntelligence;
    }

    public int getItemHealthBonus(){ return baseBonusHealth + (levelBonusHealth * level); }
    public int getItemStrengthBonus(){ return baseBonusStrength + (levelBonusStrength * level); }
    public int getItemDexterityBonus(){ return baseBonusDexterity + (levelBonusDexterity * level); }
    public int getItemIntelligenceBonus(){ return baseBonusIntelligence + (levelBonusIntelligence * level); }
    public ITEMTYPE getItemType() {
        return itemType;
    }
    public SLOT getSlot(){ return slot; }

    @Override
    public int getLevel() { return level; }

    @Override
    public String toString(){

        String BonusStats ="";
        if(getItemHealthBonus() > 0){
            BonusStats += "Bonus HP: "+ getItemHealthBonus()+"\n";
        }
        if(getItemStrengthBonus() > 0){
            BonusStats+= "Bonus Str: "+getItemStrengthBonus()+"\n";
        }
        if(getItemDexterityBonus() > 0){
            BonusStats+= "Bonus Dex: "+getItemDexterityBonus()+"\n";
        }

        if(getItemIntelligenceBonus() > 0){
            BonusStats+= "Bonus Int: "+getItemIntelligenceBonus()+"\n";
        }

        return "Item stats for: "+ name+"\n"+
               "Weapon type: " + this.getClass().getSimpleName() +"\n"+
               "Slot: "+ slot.label+"\n"+
               "Armor level: "+ level+"\n"+
                BonusStats;
    }
}
