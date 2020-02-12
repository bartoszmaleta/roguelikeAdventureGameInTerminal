package app.structures;

import java.util.ArrayList;
import java.util.List;

import app.Coordinates;
import app.Inventory;
import app.items.Helmet;
import app.items.Item;
import app.items.Sword;

public class Chest extends Sprite {
    private Inventory chestInventory;

    public Chest(List<Coordinates> coordinatesList) {
        super("\uD83C\uDF81", coordinatesList);
        chestInventory = new Inventory();
        fillChest();
    }

    private void fillChest() {
        Item sword = new Sword("Two-handed sword", 10, 5);
        Item sword2 = new Sword("Two-handed sword3", 12, 7);
        Item helmet = new Helmet("Hat", 50, 70);

        chestInventory.addToInventory(sword);
        chestInventory.addToInventory(sword2);
        chestInventory.addToInventory(helmet);
    }

    public Inventory getChestInventory() {
        return chestInventory;
    }

}
