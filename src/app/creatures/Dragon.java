package app.creatures;

import java.util.List;

import app.Coordinates;
import app.inventory.Inventory;

public class Dragon extends Monster {
    private Inventory dragonInventory;

    public Dragon(List<Coordinates> coordinatesList, String name, int health, Inventory inventory,
            int damage, int experience) {
        super("*", coordinatesList, "Dragon", 30, inventory, 10, 150);
    }

}