package app.structures;

import app.Coordinates;

import java.util.List;
import java.util.ArrayList;

public class Sprite {

    private String apparel;
    private List<Coordinates> coordinatesList;

    public Sprite(String apparel, List<Coordinates> coordinatesList) {
        this.apparel = apparel;
        this.coordinatesList = coordinatesList;
    }

    public String getApparel() {
        return apparel;
    }

    public List<Coordinates> getCoordinatesList() {
        return coordinatesList;
    }

}
