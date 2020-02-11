package app.structures;

import java.util.List;

import app.Coordinates;

public class Chest extends Sprite {

    public Chest(String apparel, List<Coordinates> coordinatesList) {
        super("+", coordinatesList);
    }

}
