package app.items;

public abstract class Item {
    private String name;
    private int value;
    private String appearance;

    public Item(String name, int value, String appearence) {
        this.name = name;
        this.value = value;
        this.appearance = appearence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }
    
    
}
