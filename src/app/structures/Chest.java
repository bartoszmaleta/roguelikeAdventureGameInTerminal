package app.structures;

import java.util.List;

import app.Coordinates;
import app.inventory.Inventory;
import app.items.Armor;
import app.items.Elixir;
import app.inventory.Inventory;
import app.items.Helmet;
import app.items.Item;
import app.items.KeyToDoor;
import app.items.Sword;

public class Chest extends Sprite {
    private Inventory chestInventory;

    public Chest(List<Coordinates> coordinatesList) {
        // super("\uD83C\uDF81", coordinatesList);
        super("\uD83C\uDF81", coordinatesList);
        chestInventory = new Inventory();
        fillChest();
    }

    private void fillChest() {
        Sword sword = new Sword("One-handed sword", 10, 5);
        Sword sword2 = new Sword("Two-handed sword", 12, 7);
        Armor helmet = new Helmet("Hat", 50, 70);
        Item key = new KeyToDoor("Door key", 27, "asd123");

        chestInventory.addToInventory(sword);
        chestInventory.addToInventory(sword2);
        chestInventory.addToInventory(helmet);
        chestInventory.addToInventory(key);
    }

    public Chest(List<Coordinates> coordinatesList, String differentConstructor) {
        // super("\uD83C\uDF81", coordinatesList);
        super("\uD83C\uDF81", coordinatesList);
        chestInventory = new Inventory();
        fillChest2();
    }

    private void fillChest2() {
        Sword sword = new Sword("Magical Sword", 800, 4);
        Armor helmet = new Helmet("Magical Hat", 400, 800);
        Item elixir = new Elixir("Small potion", 20, 20);

        chestInventory.addToInventory(sword);
        chestInventory.addToInventory(helmet);
        chestInventory.addToInventory(elixir);
    }

    public Inventory getChestInventory() {
        return chestInventory;
    }

    public void printChest() {

    }

    // test

}
