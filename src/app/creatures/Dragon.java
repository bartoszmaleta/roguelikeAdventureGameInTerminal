package app.creatures;

import java.util.List;

import app.Coordinates;
import app.inventory.Inventory;

public class Dragon extends Monster {

    public Dragon(String apparel, List<Coordinates> coordinatesList, String name, int health, Inventory inventory,
            int damage, int experience) {
        super(apparel, coordinatesList, name, health, inventory, damage, experience);
    }

}