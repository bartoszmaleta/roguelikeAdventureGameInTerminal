package app.creatures;

import app.Coordinates;
import app.Inventory;
import app.engine.Move;

import java.util.ArrayList;
import java.util.List;

public class Player extends Creature implements Move {

    private int level;
    private int experience;
    private int x = 5;      // HARD CODED BEGINING POSITION
    private int y = 5;      // HARD CODED BEGINING POSITION
    List<Coordinates> coordinatesPlayer = setPlayeCoordinates(x, y);
    private Inventory inv = createInventory();    

    public Player(List<Coordinates> coordinatesPlayer, String name, int health, Inventory inventory, int level, int experience) {
        super("\uD83D\uDC7D", coordinatesPlayer, name, health, inventory);
        this.level = level;
        this.experience = experience; 
    }

    public List<Coordinates> setPlayeCoordinates(int x, int y) {
        coordinatesPlayer = new ArrayList<>();
        coordinatesPlayer.add(new Coordinates(x, y));
        return coordinatesPlayer;
    }

    public Inventory createInventory() {
        Inventory inv = new Inventory();
        return inv;
    }

}
