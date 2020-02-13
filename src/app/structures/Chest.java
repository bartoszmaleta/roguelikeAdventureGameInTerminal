package app.structures;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import app.Coordinates;
import app.Inventory;
import app.items.Armor;
import app.items.Helmet;
import app.items.Item;
import app.items.Sword;
import app.services.DataHandler;

public class Chest extends Sprite {
    private Inventory chestInventory;

    public Chest(List<Coordinates> coordinatesList) {
        // super("\uD83C\uDF81", coordinatesList);
        super("+", coordinatesList);
        chestInventory = new Inventory();
        fillChest();
    }

    private void fillChest() {
        Sword sword = new Sword("One-handed sword", 10, 5);
        Sword sword2 = new Sword("Two-handed sword", 12, 7);
        Armor helmet = new Helmet("Hat", 50, 70);

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
