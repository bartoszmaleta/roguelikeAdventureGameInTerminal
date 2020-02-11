package app.structures;

import java.util.List;

import app.Coordinates;

public class Door extends Sprite {

    public Door(List<Coordinates> coordinatesList) {
        super("#", coordinatesList);
    }

}
