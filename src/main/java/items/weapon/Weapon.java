package main.java.items.weapon;

import main.java.items.Item;
import main.java.items.ITEMTYPE;
import main.java.items.SLOT;


public abstract class Weapon implements Item {

    private SLOT slot;
    private ITEMTYPE itemType = ITEMTYPE.WEAPON;
    private WEAPONTYPE weapontype;
    private String name;
    private int level;
    private double damageMultiplier;


    protected Weapon(String name,int level, SLOT slot, double damageMultiplier,WEAPONTYPE weapontype){
        this.name = name;
        this.level = level;
        this.slot = slot;
        this.damageMultiplier = damageMultiplier;
        this.weapontype = weapontype;
    }

    public abstract int getBaseDamage();
    public double getDamageMultiplier(){
        return damageMultiplier;
    }
    public SLOT getSlot(){ return slot; }
    public ITEMTYPE getItemType() { return itemType; }
    public WEAPONTYPE getWeapontype() { return weapontype; }
    public int getLevel(){ return level; }

    @Override
        public String toString(){

        return "Item stats for: "+ name+"\n"+
               "Weapon Type: "+this.getClass().getSimpleName()+"\n"+
               "Weapon level: " + level+"\n"+
                "Damage: "+ getBaseDamage();
    }

}
