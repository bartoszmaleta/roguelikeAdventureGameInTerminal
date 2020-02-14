package app.structures;

import app.Coordinates;

import java.util.List;

public class Bridge extends Sprite {

    public Bridge(List<Coordinates> coordinatesList) {
        // super("\uD83D\uDF59", coordinatesList); // squares
        // super("\uDBB8\uDC19", coordinatesList); // arrows
        // super("#", coordinatesList); // just HASH

        super("\uD83C\uDFC1", coordinatesList); // flag start

//         super("\uD83E\uDDF3", coordinatesList); // keyboard

    }

}
