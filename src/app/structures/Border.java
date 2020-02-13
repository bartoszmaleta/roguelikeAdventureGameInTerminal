package app.structures;

import app.Coordinates;
import app.engine.Collision;

import java.util.List;

public class Border extends Sprite implements Collision {

    public Border(List<Coordinates> coordinatesList, int height, int width) {
        super("X", coordinatesList);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                if (y == 0) {
                    coordinatesList.add(new Coordinates(x, y));
                }
                if (x == 0 || x == width - 1) {
                    coordinatesList.add(new Coordinates(x, y));
                }
                if (y == height - 1) {
                    coordinatesList.add(new Coordinates(x, y));
                }
            }
        }
    }

}
