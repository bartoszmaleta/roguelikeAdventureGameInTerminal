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

    public String infoToString() {
        String tableInfo = "";
        int tableLen = 49;

        tableInfo += "\n\nPress i to show inventory";
        tableInfo += "\n" ;
        
        tableInfo += "\nHEALTH = " + this.level;
        tableInfo += "\nEXPERIENCE = " + this.experience;
        tableInfo += "\nLEVEL = " + this.level;
        
        return tableInfo;
    }


//    public List<Coordinates> setPlayeCoordinates(int x, int y) {
//        coordinatesPlayer = new ArrayList<>();
//        coordinatesPlayer.add(new Coordinates(x, y));
//        return coordinatesPlayer;
//    }



}
