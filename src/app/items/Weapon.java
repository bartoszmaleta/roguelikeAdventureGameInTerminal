package app.items;

public class Weapon extends Item {
    private int damage;

    public Weapon(String name, int damage, int value, String appearance) {
        super(name, value, appearance);
        this.damage = damage;
    }
    
    
}
