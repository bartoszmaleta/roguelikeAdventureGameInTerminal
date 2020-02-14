package app.creatures;

import java.util.List;

import app.Coordinates;
import app.inventory.Inventory;
import app.items.Armor;
import app.items.Helmet;
import app.items.Item;

public class Trex extends Monster {
    private Inventory trexInventory;

    public Trex(List<Coordinates> coordinatesList, Inventory inventory) {
        super("\uD83E\uDD96", coordinatesList, "Poseidon", 30, inventory, 100, 150);
        
        Item helmet = new Helmet("Helm", 13, 65);
        // Armor shield = new Shield();
        super.getInventory().addToInventory(helmet);
    }


    public void setTrexInventory(Inventory trexInventory) {
        this.trexInventory = trexInventory;
    }

    

}