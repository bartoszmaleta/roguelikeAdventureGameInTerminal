package app.structures;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import app.Coordinates;
import app.Inventory;
import app.items.Helmet;
import app.items.Item;
import app.items.Sword;
import app.services.DataHandler;

public class Chest extends Sprite {
    private Inventory chestInventory;

    public Chest(List<Coordinates> coordinatesList) {
        super("+", coordinatesList);
        chestInventory = new Inventory();
        fillChest();
    }

    private void fillChest() {
        Item sword = new Sword("One-handed sword", 10, 5);
        Item sword2 = new Sword("Two-handed sword", 12, 7);
        Item helmet = new Helmet("Hat", 50, 70);

        chestInventory.addToInventory(sword);
        chestInventory.addToInventory(sword2);
        chestInventory.addToInventory(helmet);
    }

    public Inventory getChestInventory() {
        return chestInventory;
    }

    public void printChest() {

    }

}
