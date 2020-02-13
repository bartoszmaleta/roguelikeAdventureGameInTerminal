package app.structures;

import java.util.List;

import app.Coordinates;

public class Door extends Sprite {
    private String keyIdNeeded;
    
    public Door(String apparel, List<Coordinates> coordinatesList, String keyIdNeeded) {
        super("#", coordinatesList);
        this.keyIdNeeded = keyIdNeeded;
        // keyIdNeeded = "asd123"
    }

    public String getKeyIdNeeded() {
        return keyIdNeeded;
    }

    public void setKeyIdNeeded(String keyIdNeeded) {
        this.keyIdNeeded = keyIdNeeded;
    }

}
