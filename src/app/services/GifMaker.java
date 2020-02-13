package app.services;

public class GifMaker {
    public void longLoop() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(i + 1);
        }
    }
}