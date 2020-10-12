package main.java.heroes;

import main.java.items.Item;
import main.java.items.ITEMTYPE;
import main.java.items.SLOT;
import main.java.items.armor.*;
import main.java.items.weapon.*;

import java.util.HashMap;
import java.util.Map;

public abstract class Hero {

    private int baseHealth,baseStrength,baseDexterity,baseIntelligence;
    protected int expHealth,expStrength,expDexterity,expIntelligence;
    protected int bonusHealth,bonusStrength,bonusDexterity,bonusIntelligence;
    private int level = 1;
    private int currentExperience = 0;
    private int nextLevelExpRequirement = 100;
    private int totalExpNeeded = 100;

    Map<SLOT, Armor> equippedArmor = new HashMap<>();
    Map<SLOT, Weapon> equippedWeapon = new HashMap<>();

    protected Hero(int baseHealth, int baseStrength,int baseDexterity, int baseIntelligence,
                    int expHealth,int expStrength,int expDexterity,int expIntelligence){

        this.baseHealth = baseHealth;
        this.baseStrength = baseStrength;
        this.baseDexterity = baseDexterity;
        this.baseIntelligence = baseIntelligence;

        this.expHealth = expHealth;
        this.expStrength = expStrength;
        this.expDexterity = expDexterity;
        this.expIntelligence = expIntelligence;
    }


    public void removeEquippedItem(SLOT slot){

        if(slot == SLOT.MAINWEAPON){
            equippedWeapon.remove(slot);
        }else{
            alterItemBonusStats(equippedArmor.get(slot),slot,false);
            equippedArmor.remove(slot);
        }
    }

    public int getDamage(SLOT slot){


        if (!equippedWeapon.containsKey(slot))
            return 0;
        Weapon currentWeapon = equippedWeapon.get(slot);

        int damage = 0;
        if(currentWeapon.getWeapontype() == WEAPONTYPE.MELEE){
            damage = currentWeapon.getBaseDamage()+(((int) (Math.floor(getStrength()*currentWeapon.getDamageMultiplier()))));
        }
        if(currentWeapon.getWeapontype() == WEAPONTYPE.RANGED){
            damage = currentWeapon.getBaseDamage()+(((int) (Math.floor(getDexterity()*currentWeapon.getDamageMultiplier()))));
        }
        return damage;
    }


    public void alterItemBonusStats(Armor armor , SLOT slot,boolean increaseStats){
        double slotMultiplier = 1.0;
        if(armor != null) {

            if(slot == SLOT.HEAD){
                slotMultiplier = 0.8;
            }else if(slot == SLOT.LEGS){
                slotMultiplier = 0.6;
            }
            if(increaseStats) {
                bonusHealth += Math.floor(armor.getItemHealthBonus() * slotMultiplier);
                bonusStrength += Math.floor(armor.getItemStrengthBonus() * slotMultiplier);
                bonusDexterity += Math.floor(armor.getItemDexterityBonus() * slotMultiplier);
                bonusIntelligence += Math.floor(armor.getItemIntelligenceBonus() * slotMultiplier);
            }else{
                bonusHealth -= Math.floor(armor.getItemHealthBonus() * slotMultiplier);
                bonusStrength -= Math.floor(armor.getItemStrengthBonus() * slotMultiplier);
                bonusDexterity -= Math.floor(armor.getItemDexterityBonus() * slotMultiplier);
                bonusIntelligence -= Math.floor(armor.getItemIntelligenceBonus() * slotMultiplier);
            }
        }
    }

    public void levelUp(){
        level++;
        setHealth(getHealth() + expHealth);
        setStrength(getStrength() + expStrength);
        setDexterity(getDexterity() + expDexterity);
        setIntelligence(getIntelligence() + expIntelligence);

    }
    public void putItemInSlot(Item item, SLOT slot,ITEMTYPE itemType){

        if(itemType == ITEMTYPE.WEAPON){
            equippedWeapon.put(slot, (Weapon) item);
        }else{
            equippedArmor.put(slot,(Armor) item);
        }
    }

    public int getLevel(){ return level; }

    public int getHealth() { return baseHealth + bonusHealth; }
    public int getStrength() { return baseStrength + bonusStrength; }
    public int getDexterity() { return baseDexterity + bonusDexterity; }
    public int getIntelligence() { return baseIntelligence + bonusIntelligence; }

    public void setHealth(int newBasehealth) { this.baseHealth = newBasehealth; }
    public void setStrength(int newBaseStrength) { this.baseStrength = newBaseStrength; }
    public void setDexterity(int newBaseDexterity) { this.baseDexterity = newBaseDexterity; }
    public void setIntelligence(int newBaseIntelligence) { this.baseIntelligence = newBaseIntelligence; }

    public int getCurrentExperience(){ return currentExperience; }
    public void addExpPoints(int expPoints){ currentExperience += expPoints; }

    public void setTotalExpNeeded(int nextLevelExpRequirement) {
        this.totalExpNeeded += nextLevelExpRequirement;
    }

    public int getNextLevelExpRequirement(){ return nextLevelExpRequirement; }
    public void setNextLevelExpRequirement(){ nextLevelExpRequirement = (int) Math.rint(nextLevelExpRequirement * 1.1); }
    public int getTotalExperienceNeeded(){ return totalExpNeeded; }
    public Map<SLOT,Armor> getArmorMap(){ return equippedArmor; }

    @Override
    public String toString(){
        return this.getClass().getSimpleName()+" details:"+"\n"+
            "HP: "+getHealth()+"\n"+
            "Str: "+getStrength()+"\n"+
            "Dex: "+getDexterity()+"\n"+
            "Int: "+getIntelligence()+"\n"+
            "Lvl: "+ level+"\n"+
            "XP to next "+(totalExpNeeded-currentExperience);
    }
}
