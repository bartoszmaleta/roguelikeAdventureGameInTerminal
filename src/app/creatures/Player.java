package app.creatures;

import app.Coordinates;
import app.Inventory;
import app.engine.Move;

import java.util.List;

public class Player extends Creature implements Move {

    private int level;
    private int experience;

    public Player(String apparel, List<Coordinates> coordinatesList, String name, int health, Inventory inventory, int level, int experience) {
        super(apparel, coordinatesList, name, health, inventory);
        this.level = level;
        this.experience = experience;
    }
}
