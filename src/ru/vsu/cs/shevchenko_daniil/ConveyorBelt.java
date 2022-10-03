package ru.vsu.cs.shevchenko_daniil;

import java.awt.*;

public class ConveyorBelt {

    private int x1, y1, x2, y2, length;
    private Color color;

    public ConveyorBelt(int x1, int y1, int x2, int y2, int length, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    void draw (Graphics2D graphics) {
        DrawingThings.drawConveyorBelt(graphics, getX1(), getY1(), getX2(), getY2(), getLength(), getColor());
    }

    void draw()

    void resize(int newLength) {
        setX1(newLength+100);
        setX2(newLength+100);
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


}
