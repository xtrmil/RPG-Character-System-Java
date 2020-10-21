package main.java.items.weapon;

import main.java.items.Item;
import main.java.items.ItemType;
import main.java.items.Slot;


public abstract class Weapon implements Item {

    private Slot slot;
    private ItemType itemType = ItemType.WEAPON;
    private WeaponType weapontype;
    private String name;
    private int level;
    private double damageMultiplier;


    protected Weapon(String name, int level, Slot slot, double damageMultiplier, WeaponType weapontype){
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
    public Slot getSlot(){ return slot; }
    public ItemType getItemType() { return itemType; }
    public WeaponType getWeapontype() { return weapontype; }
    public int getLevel(){ return level; }

    @Override
        public String toString(){

        return "Item stats for: "+ name+"\n"+
               "Weapon Type: "+this.getClass().getSimpleName()+"\n"+
               "Weapon level: " + level+"\n"+
                "Damage: "+ getBaseDamage();
    }

}
