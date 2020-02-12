package app.structures;

import app.Coordinates;
import app.engine.Collision;

import java.util.List;

public class Border extends Sprite implements Collision {

    public Border(List<Coordinates> coordinatesList) {
        super("X", coordinatesList);
        for (int y = 0; y < 33; y++) {
            for (int x = 0; x < 117; x++) {
                if (y == 0) {
                    coordinatesList.add(new Coordinates(x, y));
                }
                if (x == 0 || x == 116) {
                    coordinatesList.add(new Coordinates(x, y));
                }
                if (y == 32) {
                    coordinatesList.add(new Coordinates(x, y));
                }
            }
        }
    }

}
