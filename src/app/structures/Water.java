package app.structures;

import java.util.List;

import app.Coordinates;
import app.engine.Collision;

public class Water extends Sprite implements Collision {

    public Water(List<Coordinates> coordinatesList) {
        // super("\uD83C\uDF0A", coordinatesList); // waves
        super("\uD83D\uDD35", coordinatesList); // blue circle
    }
    
}
