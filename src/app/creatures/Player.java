package app.creatures;

import app.Coordinates;
import app.Inventory;

import java.util.List;

public class Player extends Creature {

    private int level;
    private int experience;
    private Inventory inv;

    public Player(List<Coordinates> coordinatesPlayer, String name, int health, Inventory inventory) {
        super("\uD83D\uDC7D", coordinatesPlayer, name, health, inventory);
        this.level = 1;
        this.experience = 0;
    }

    public void setPlayerCoordinates(int x, int y) {
        List<Coordinates> coordinates = getCoordinatesList();
        coordinates.get(0).setX(x);
        coordinates.get(0).setY(y);
    }


    public Inventory getInv() {
        return inv;
    }


//    public List<Coordinates> setPlayeCoordinates(int x, int y) {
//        coordinatesPlayer = new ArrayList<>();
//        coordinatesPlayer.add(new Coordinates(x, y));
//        return coordinatesPlayer;
//    }



}
