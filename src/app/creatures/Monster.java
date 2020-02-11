package app.creatures;

import app.Coordinates;
import app.Inventory;

import java.util.List;

public class Monster extends Creature {

    private int damage;
    private List<Coordinates> moveBox;

    public Monster(String apparel, List<Coordinates> coordinatesList, String name, int health, Inventory inventory, int damage, List<Coordinates> moveBox) {
        super(apparel, coordinatesList, name, health, inventory);
        this.damage = damage;
        this.moveBox = moveBox;
    }
}
