package main.java;

import main.java.heroes.Hero;
import main.java.items.ItemType;
import main.java.items.Item;
import main.java.items.Slot;
import main.java.items.armor.Armor;
import java.util.Map;

public class GameManager {

    public void addExperience(Hero hero, int expPointsAdded){                                                                           // This method adds the required experience needed for nextlevel and decreses expPointsAdded
        while((hero.getCurrentExperience() + expPointsAdded)>=(hero.getCurrentExperience() + hero.getNextLevelExpRequirement())){       // with the same amount each run in the while loop. this is done until expPointsadded is
                                                                                                                                        // less than the experience needed for next level, and then the rest is added to
            hero.addExpPoints(hero.getNextLevelExpRequirement());                                                                       // currentExperience.
            expPointsAdded-=hero.getNextLevelExpRequirement();
            hero.setNextLevelExpRequirement();      //increasing nextLevelrequirement with 10% each iteration.
            hero.setTotalExpNeeded(hero.getNextLevelExpRequirement());
            hero.levelUp();     // increasing stats each iteration
            System.out.println("Level up!"+"\n"+"Now level " + hero.getLevel());

        }
        hero.addExpPoints(expPointsAdded);

        System.out.println(hero.getTotalExperienceNeeded()-hero.getCurrentExperience() + " more needed to level up");
    }

    public void equipItem(Hero hero, Item item, Slot slot){
        Map<Slot, Armor> equippedArmor = hero.getArmorMap();
        if(item.getLevel()<hero.getLevel()){   // checks if hero has high enough level to equip the item

            if (item.getItemType().equals(ItemType.WEAPON)) {  // weapons can be overwritten without first removing bonus stats as current weapons only affect damage
                hero.putItemInSlot(item,slot,item.getItemType());
            } else {
                if (equippedArmor.containsKey(slot)) {  // if the slot is not empty, bonusstats should be removed before the item is overwritten in the Hashmap
                    hero.alterItemBonusStats((Armor) item , item.getSlot(),false);
                }
                hero.putItemInSlot(item,slot,item.getItemType());
                hero.alterItemBonusStats((Armor) item, item.getSlot(),true);
            }
        }else{
            System.out.println("You cannot equip this item, your level is too low");
        }
    }
    public void removeEquippedItem(Hero hero, Item item, Slot slot){

        if(slot != Slot.MAINWEAPON){
            hero.alterItemBonusStats((Armor) item,slot,false);
        }else{
            hero.removeEquippedItem(slot);
        }
    }
}
