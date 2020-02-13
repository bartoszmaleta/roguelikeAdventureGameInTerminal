package app.services;

import java.util.Arrays;

public class CirclePrintingTest {
    public static void main(String[] args) {
        final int NUM_POINTS = 1000;
        final double RADIUS = 5d;

        final Point[] points = new Point[NUM_POINTS];

        for (int i = 0; i < NUM_POINTS; ++i) {
            final double angle = Math.toRadians(((double) i / NUM_POINTS) * 360d);

            points[i] = new Point(Math.cos(angle) * RADIUS, Math.sin(angle) * RADIUS);
        }

        System.out.println(Arrays.toString(points));
    }
}