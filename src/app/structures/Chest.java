package app.structures;

import java.util.ArrayList;
import java.util.List;

import app.Coordinates;
import app.Inventory;
import app.items.Item;
import app.items.Sword;

public class Chest extends Sprite {
    private Inventory chestInventory;

    public Chest(List<Coordinates> coordinatesList) {
        super("+", coordinatesList);
        chestInventory = new Inventory();
        fillChest();
    }

    private void fillChest() {
        Item sword = new Sword("Two-handed sword", 10, 5);
        Item sword2 = new Sword("Two-handed sword2", 11, 6);
        Item sword3 = new Sword("Two-handed sword3", 12, 7);

        chestInventory.addToInventory(sword);
        chestInventory.addToInventory(sword2);
        chestInventory.addToInventory(sword3);
    }

}
