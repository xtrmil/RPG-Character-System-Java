package main.java.items.weapon;

import main.java.items.Item;
import main.java.items.SLOT;

public class Melee extends Weapon implements Item {
    private static WEAPONTYPE weaponType = WEAPONTYPE.MELEE;
    private int baseDamage = 15;
    private static double damageMultiplier = 1.5;
    public Melee(String name, int level, SLOT slot) {
        super(name, level,slot,damageMultiplier,weaponType);
    }


    @Override
    public int getBaseDamage() {
        return baseDamage+(2*getLevel());
    }
}
