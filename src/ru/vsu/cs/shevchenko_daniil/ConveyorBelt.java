package ru.vsu.cs.shevchenko_daniil;

import java.awt.*;

public class ConveyorBelt {

    private int y, width, length, step;
    private int position = 0;
    private Color color;

    public ConveyorBelt(int y, int width, int length, int step, Color color) {
        this.y = y;
        this.width = width;
        this.length = length;
        this.step = step;
        this.color = color;
    }

    void draw (Graphics2D graphics) {
        graphics.setColor(Color.black);
        graphics.drawLine(0, y, width, y);
        graphics.drawLine(0, y, 0, y + length);
        graphics.drawLine(0, y+length, width, y+length);
        graphics.setColor(color);
        graphics.fillRect(1, y+1, width-1, length);

        graphics.setColor(Color.black);
        for (int i = 0; i < width/step + 2; i++) {
            graphics.drawLine(step*i+10 + position, y, step*i + 10 + position, y+length);
        }
    }

    public void incPosition() {
        position++;
        if (position == step) {
            position = 0;
        }
    }

    public void resize(int width, int height) {
        setY(height/2);
        setWidth(width);
        setLength(height/8);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
