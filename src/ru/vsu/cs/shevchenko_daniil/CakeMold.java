package ru.vsu.cs.shevchenko_daniil;


import java.awt.*;
import java.util.Random;

public class CakeMold {
    // 0 - квадрат, 1 - круг
    private int x, y, r, height, width;
    private Color colorOut, colorIn;
    private int position = 0;

    void draw(Graphics2D graphics) {
            graphics.setColor(colorOut);
            graphics.drawLine(x, y, x-r, y);
            graphics.drawLine(x-r, y, x - r, y + r);
            graphics.drawLine(x - r, y+ r, x, y+ r);
            graphics.drawLine(x , y+ r, x, y);
            graphics.setColor(colorIn);
            graphics.fillRect(x+1-r, y+1, r-1, r-1);
            position = getX();
    }

    void move() {
            position++;
            setX(position);
            if (position - r == 1920) {
                setX(0);
            }
    }

    public CakeMold(int x, int y, int r, Color colorOut, Color colorIn) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.colorOut = colorOut;
        this.colorIn = colorIn;
    }

    public int getPosition() {
        return position;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Color getColorOut() {
        return colorOut;
    }

    public void setColorOut(Color colorOut) {
        this.colorOut = colorOut;
    }

    public Color getColorIn() {
        return colorIn;
    }

    public void setColorIn(Color colorIn) {
        this.colorIn = colorIn;
    }


}
