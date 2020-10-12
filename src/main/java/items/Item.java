package main.java.items;

public interface Item {
    public ITEMTYPE getItemType();
    public int getLevel();
    public SLOT getSlot();
}
