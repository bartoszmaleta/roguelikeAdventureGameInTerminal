package app.creatures;

import app.Coordinates;
import app.Inventory;

import java.util.List;

public class Monster extends Creature {

    public Monster(String apparel, List<Coordinates> coordinatesList, String name, int health, Inventory inventory, int damage, int experience) {
        super(apparel, coordinatesList, name, health, inventory, damage, experience);
    }
}
