package app.structures;

public abstract class Structure {

    private String apparel;
    private int x;
    private int y;

    public Structure(String apparel, int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getApparel() {
        return apparel;
    }

}
