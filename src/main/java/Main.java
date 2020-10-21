package main.java;

import main.java.heroes.*;

import main.java.items.Slot;
import main.java.items.armor.*;
import main.java.items.weapon.*;

public class Main {

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();

    System.out.println("-Creates one of each Hero classes-");
        System.out.println();
        Warrior warrior = new Warrior();
        Mage mage = new Mage();
        Ranger ranger = new Ranger();

        System.out.println(warrior.toString());
        System.out.println();
        System.out.println(mage.toString());
        System.out.println();
        System.out.println(ranger.toString());

        System.out.println();
        System.out.println("-Adding experience to the Warrior-");
        System.out.println();
        gameManager.addExperience(warrior,500);
        System.out.println();
        System.out.println("-Adding experience to the Mage-");
        System.out.println();
        gameManager.addExperience(mage, 350);
        System.out.println();
        System.out.println("-Adding experience to the Ranger-");
        System.out.println();
        gameManager.addExperience(ranger, 450);
        System.out.println();
        System.out.println("-Updated stats for the heroes-");
        System.out.println();
        System.out.println(warrior.toString());
        System.out.println();
        System.out.println(mage.toString());
        System.out.println();
        System.out.println(ranger.toString());
        System.out.println();

        System.out.println("-Creating one of each Item types-");
        System.out.println();
        Cloth clothHelmet = new Cloth("ClothHelmet from Hell",4, Slot.HEAD);
        System.out.println(clothHelmet.toString());
        Plate platePants = new Plate("PlatePants of Plates", 3, Slot.LEGS);
        System.out.println(platePants.toString());
        Leather leatherBody = new Leather("LeatherBody of Doom", 1, Slot.BODY);
        System.out.println(leatherBody.toString());
        Ranged ranged = new Ranged("Bow of Pain",1, Slot.MAINWEAPON);
        System.out.println("Multiplier " +ranged.getDamageMultiplier());
        System.out.println(ranged.toString());
        System.out.println();
        Melee melee = new Melee("Big Super Axe",2, Slot.MAINWEAPON);
        System.out.println("Multiplier " +melee.getDamageMultiplier());
        System.out.println(melee.toString());

        System.out.println("-Equipping the Helmet and Pants to the warrior-");
        gameManager.equipItem(warrior, platePants, Slot.LEGS);
        gameManager.equipItem(warrior, clothHelmet, Slot.HEAD);
        System.out.println();
        System.out.println("-Updated Stats-");
        System.out.println(warrior.toString());
        System.out.println();

        System.out.println("-Equipping the Bodyarmor to the Mage-");
        gameManager.equipItem(mage, leatherBody, Slot.BODY);
        System.out.println();
        System.out.println("-Updated Stats-");
        System.out.println(mage.toString());
        System.out.println();

        System.out.println("-Removing the armor items from the Warrior and the Mage-");
        System.out.println();
        gameManager.removeEquippedItem(warrior,clothHelmet, Slot.HEAD);
        gameManager.removeEquippedItem(warrior,platePants, Slot.LEGS);
        gameManager.removeEquippedItem(mage,leatherBody, Slot.BODY);

        System.out.println("-Updated Stats-");
        System.out.println();
        System.out.println(warrior.toString());
        System.out.println();
        System.out.println(mage.toString());
        System.out.println();

        System.out.println("-Equipping Weapon to Warrior and Ranger-");
        gameManager.equipItem(warrior,melee, Slot.MAINWEAPON);
        gameManager.equipItem(ranger,ranged, Slot.MAINWEAPON);
        System.out.println("-Warrior is Damaging something-");
        System.out.println();
        System.out.println("Damage: " +warrior.getDamage(Slot.MAINWEAPON));
        System.out.println();
        System.out.println("Remove weapon from Warrior");
        System.out.println();
        gameManager.removeEquippedItem(warrior,melee, Slot.MAINWEAPON);
        System.out.println();
        System.out.println("Damage: " +warrior.getDamage(Slot.MAINWEAPON));
        System.out.println();


        System.out.println("-Ranger is Damaging something-");
        System.out.println();
        System.out.println("Damage: " +ranger.getDamage(Slot.MAINWEAPON));
        System.out.println();
        System.out.println("Remove weapon");
        System.out.println();
        gameManager.removeEquippedItem(ranger,melee, Slot.MAINWEAPON);
        System.out.println("Damage: " +ranger.getDamage(Slot.MAINWEAPON));
    }
}
