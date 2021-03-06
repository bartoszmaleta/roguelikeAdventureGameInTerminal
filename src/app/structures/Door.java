package app.structures;

import java.util.List;

import app.Coordinates;

public class Door extends Sprite {

        private String keyIdNeeded;
    
        public Door( List<Coordinates> coordinatesList, String keyIdNeeded) {
            super("\u26E9", coordinatesList);
            this.keyIdNeeded = keyIdNeeded;
            // keyIdNeeded = "asd123"  // HERE OR IN CONSTRUCTOR!!
        }
    
        public String getKeyIdNeeded() {
            return keyIdNeeded;
        }
    
        public void setKeyIdNeeded(String keyIdNeeded) {
            this.keyIdNeeded = keyIdNeeded;
        }

}
