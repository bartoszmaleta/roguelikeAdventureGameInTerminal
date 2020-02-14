package app.creatures;

import java.util.List;

import app.Coordinates;
import app.inventory.Inventory;
import app.items.Armor;
import app.items.Helmet;
import app.items.Item;

public class Dragon extends Monster {
    private Inventory dragonInventory;

    public Dragon(List<Coordinates> coordinatesList, Inventory inventory) {
        super("\uD83D\uDC09", coordinatesList, "Dragon", 30, inventory, 10, 150);
        
        Item helmet = new Helmet("Helm", 13, 65);
        super.getInventory().addToInventory(helmet);
    }

    // TODO
    // private void setDragonInventory() {
        // this.dragonInventory.addToInventory(helmet);
        // this.dragonInventory = dragonInventory;
    // }



    

}