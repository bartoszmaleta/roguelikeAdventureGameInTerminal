package app.creatures;

import app.Coordinates;
import app.Inventory;
import app.structures.Sprite;

import java.util.List;

public class Creature extends Sprite {

    private String name;
    private int health;
    private Inventory inventory;


    public Creature(String apparel, List<Coordinates> coordinatesList, String name, int health, Inventory inventory) {
        super(apparel, coordinatesList);
        this.name = name;
        this.health = health;
        this.inventory = inventory;
    }

}
