package app.creatures;

import app.Coordinates;
import app.Inventory;

import java.util.List;

public class Player extends Creature {

    private int level;
    private int experience;
    private Inventory inv = createInventory();    

    public Player(List<Coordinates> coordinatesPlayer, String name, int health, Inventory inventory, int level, int experience) {
        super("@", coordinatesPlayer, name, health, inventory);
        this.level = level;
        this.experience = experience;
    }

    public void setPlayerCoordinates(int x, int y) {
        List<Coordinates> coordinates = getCoordinatesList();
        coordinates.get(0).setX(x);
        coordinates.get(0).setY(y);
    }


//    public List<Coordinates> setPlayeCoordinates(int x, int y) {
//        coordinatesPlayer = new ArrayList<>();
//        coordinatesPlayer.add(new Coordinates(x, y));
//        return coordinatesPlayer;
//    }

    public Inventory createInventory() {
        Inventory inv = new Inventory();
        return inv;
    }

}
