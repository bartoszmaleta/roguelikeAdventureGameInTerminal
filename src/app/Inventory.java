package app;

import java.util.ArrayList;

import app.items.Item;

public class Inventory {
    private ArrayList<Item> inventoryList;

    public Inventory() {
        inventoryList = new ArrayList<>();
    }

    public ArrayList<Item> getInventoryList() {
        return inventoryList;
    }

    public void setInventory(ArrayList<Item> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public void addToInventory(Item item) {
        this.inventoryList.add(item);
    }


}
