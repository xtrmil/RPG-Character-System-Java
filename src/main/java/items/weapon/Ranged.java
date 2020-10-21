package main.java.items.weapon;

import main.java.items.Item;
import main.java.items.Slot;

public class Ranged extends Weapon implements Item {
    private static WeaponType weaponType = WeaponType.RANGED;
    private int baseDamage = 5;
    private static  double damageMultiplier = 2.0;

    public Ranged(String name, int level, Slot slot) {
        super(name, level,slot,damageMultiplier,weaponType);
    }


    @Override
    public int getBaseDamage() {
        return baseDamage+(3*getLevel());
    }

}
