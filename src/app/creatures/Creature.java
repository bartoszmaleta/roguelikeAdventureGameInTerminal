package app.creatures;

import app.Coordinates;
import app.Inventory;
import app.structures.Sprite;

import java.util.List;

public class Creature extends Sprite {

    private String name;
    private int health;
    private Inventory inventory;
    private int damage;
    private int experience;


    public Creature(String apparel, List<Coordinates> coordinatesList, String name, int health, Inventory inventory, int damage, int experience) {
        super(apparel, coordinatesList);
        this.name = name;
        this.health = health;
        this.inventory = inventory;
        this.damage = damage;
        this.experience = experience;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public void setExperience(int experience) {
        this.experience += experience;
    }

    public int getExperience() {
        return experience;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public boolean turn(Creature opponent) {
        int hp = opponent.getHealth();
        int dmg = getDamage();
        opponent.setHealth(hp-dmg);
        return opponent.getHealth() <= 0;
    }

//    public boolean fight(Creature attacker, Creature opponent) {
//        if (turn(opponent) <= 0) {
//            return true;
//        } else if (turn(attacker) <= 0){
//            return true;
//        } else {
//            turn(attacker);
//        }
//        return false;
//    }

}
