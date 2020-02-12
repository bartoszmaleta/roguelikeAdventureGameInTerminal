package app;

public class Coordinates {

    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // to change
    public void goDown() {
        this.y += 1;
    }

    public void goUp() {
        this.y -= 1;
    }

    public void goRight() {
        this.x += 1;
    }

    public void goLeft() {
        this.x -= 1;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
