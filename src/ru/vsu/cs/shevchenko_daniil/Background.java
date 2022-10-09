package ru.vsu.cs.shevchenko_daniil;

import java.awt.*;

public class Background {
    private int y, width, height, step, distance = 0;
    private Color plateColor1, plateColor2;


    void draw(Graphics2D graphics) {
        int counter = 0;
        for (int i = 0; i * step < width; i++) {
            graphics.setColor(plateColor2);
            graphics.fillRect(step * counter, y, step, height);
            counter++;
            graphics.setColor(plateColor1);
            graphics.fillRect(step * counter, y, step, height);
            counter++;
        }
    }

    public Background(int y, int width, int height, int step, Color plateColor1, Color plateColor2) {
        this.step = step;
        this.height = height;
        this.y = y;
        this.width = width;
        this.plateColor1 = plateColor1;
        this.plateColor2 = plateColor2;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getPlateColor1() {
        return plateColor1;
    }

    public void setPlateColor1(Color plateColor1) {
        this.plateColor1 = plateColor1;
    }

    public Color getPlateColor2() {
        return plateColor2;
    }

    public void setPlateColor2(Color plateColor2) {
        this.plateColor2 = plateColor2;
    }
}
