package ru.vsu.cs.shevchenko_daniil;

import java.awt.*;
import java.util.Random;

public class Cake {
    public int cakeType, decorationType;
    private int r, x, y;
    private int position = 0;
    private Color colorOfCake, colorOfDecoration;
    private Random rnd = new Random();
    final private static Color baseCakeColor = new Color(0x804F1F);

    //cake
    // 0 - Square
    // 1 - Circle
//decoration
    // 0 - Circles
    void draw(Graphics2D graphics) {
        switch (cakeType) {
            case 0:
                graphics.setColor(Color.black);
                graphics.drawLine(x - r, y, x - r, y + r);
                graphics.drawLine(x - r, y + r, x + r, y + r);
                graphics.drawLine(x + r, y + r, x + r, y - r);
                graphics.drawLine(x + r, y - r, x - r, y - r);
                graphics.drawLine(x - r, y - r, x - r, y);
                graphics.setColor(baseCakeColor);
                graphics.fillRoundRect(x - r + 1, y - r + 1, 2 * r, 2 * r, 10, 10);

                switch (decorationType) {
                    case 0:
                        drawSquares(graphics,colorOfDecoration);
                        break;
                    case 1:
                        drawCircles(graphics, colorOfDecoration);
                        break;
                    case 2:
                        drawAnotherStuff(graphics, colorOfDecoration);
                        break;
                }
                break;
            case 1:
                graphics.setColor(baseCakeColor);
                graphics.fillOval(x - r * 5 / 4, y - r * 5 / 4, r * 5 / 2, r * 5 / 2);

                switch (decorationType) {
                    case 0:
                        drawSquares(graphics, colorOfDecoration);
                        break;
                    case 1:
                        drawCircles(graphics, colorOfDecoration);
                        break;
                    case 2:
                        drawAnotherStuff(graphics, colorOfDecoration);
                        break;
                }

        }
        position = getX();
    }

    void move() {
        position++;
        setX(position);
        if (position == 1920 + 115) {
            setX(0);
            setDecorationType(rnd.nextInt(3));
            setCakeType(rnd.nextInt(2));
        }
    }

    public Cake(int cakeType, int decorationType, int r, int x, int y, Color colorOfCake, Color colorOfDecoration) {
        this.cakeType = cakeType;
        this.decorationType = decorationType;
        this.r = r;
        this.x = x;
        this.y = y;
        this.colorOfCake = colorOfCake;
        this.colorOfDecoration = colorOfDecoration;
    }

    void drawCircles(Graphics2D graphics, Color colorOfDecoration) {
        switch (cakeType) {
            case 0:
                graphics.setColor(colorOfDecoration);
                graphics.drawOval(x - r, y - r, r * 2, r * 2);
                graphics.drawOval(x - r * 3 / 4, y - r * 3 / 4, r * 3 / 2, r * 3 / 2);
                graphics.drawOval(x - r / 4, y - r / 4, r * 1 / 2, r * 1 / 2);

                graphics.drawLine(x - r / 2, y + r / 2, x, y - r * 3 / 4);
                graphics.drawLine(x, y - r * 3 / 4, x + r / 2, y + r / 2);
                graphics.drawLine(x + r / 2, y + r / 2, x - r * 3 / 4, y);
                graphics.drawLine(x - r * 3 / 4, y - r * 1 / 4, x + r * 3 / 4, y - r * 1 / 4);
                graphics.drawLine(x + r * 3 / 4, y, x - r / 2, y + r / 2);
                break;
            case 1:
                graphics.setColor(colorOfDecoration);
                graphics.drawOval(x - r, y - r, r * 2, r * 2);
                graphics.drawOval(x - r * 3 / 4, y - r * 3 / 4, r * 3 / 2, r * 3 / 2);
                graphics.drawOval(x - r / 4, y - r / 4, r / 2, r / 2);

                graphics.drawLine(x - r / 2, y + r / 2, x, y - r * 3 / 4);
                graphics.drawLine(x, y - r * 3 / 4, x + r / 2, y + r / 2);
                graphics.drawLine(x + r / 2, y + r / 2, x - r * 3 / 4, y);
                graphics.drawLine(x - r * 3 / 4, y - r * 1 / 4, x + r * 3 / 4, y - r * 1 / 4);
                graphics.drawLine(x + r * 3 / 4, y, x - r / 2, y + r / 2);
                break;
        }
    }

    void drawSquares(Graphics2D graphics, Color colorOfDecoration) {
        graphics.setColor(colorOfDecoration);
        switch (cakeType) {
            case 0:
                graphics.drawLine(x - r + 1, y, x, y - r + 1);
                graphics.drawLine(x, y - r + 1, x + r - 1, y);
                graphics.drawLine(x + r - 1, y, x, y + r - 1);
                graphics.drawLine(x, y + r - 1, x - r + 1, y);

                graphics.drawLine(x - r / 2, y - r / 2, x + r / 2, y - r / 2);
                graphics.drawLine(x + r / 2, y - r / 2, x + r / 2, y + r / 2);
                graphics.drawLine(x + r / 2, y + r / 2, x - r / 2, y + r / 2);
                graphics.drawLine(x - r / 2, y + r / 2, x - r / 2, y - r / 2);

                graphics.drawLine(x - r / 2, y, x, y - r / 2);
                graphics.drawLine(x, y - r / 2, x + r / 2, y);
                graphics.drawLine(x + r / 2, y, x, y + r / 2);
                graphics.drawLine(x, y + r / 2, x - r / 2, y);

                graphics.drawLine(x - r / 4, y - r / 4, x + r / 4, y - r / 4);
                graphics.drawLine(x + r / 4, y - r / 4, x + r / 4, y + r / 4);
                graphics.drawLine(x + r / 4, y + r / 4, x - r / 4, y + r / 4);
                graphics.drawLine(x - r / 4, y + r / 4, x - r / 4, y - r / 4);

                graphics.setColor(Color.black);
                graphics.fillRect(x - 3, y - r + 8, 8, 8);
                graphics.fillRect(x - r + 8, y - 3, 8, 8);
                graphics.fillRect(x + r - 16, y - 5, 8, 8);
                graphics.fillRect(x - 3, y + r - 16, 8, 8);
                break;
            case 1:
                int newR = r * 5 / 4;
                graphics.drawLine(x - newR, y, x, y - newR);
                graphics.drawLine(x, y - newR, x + newR, y);
                graphics.drawLine(x + newR - 1, y, x, y + newR - 1);
                graphics.drawLine(x, y + newR - 1, x - newR + 1, y);

                graphics.drawLine(x - newR / 2, y - newR / 2, x + newR / 2, y - newR / 2);
                graphics.drawLine(x + newR / 2, y - newR / 2, x + newR / 2, y + newR / 2);
                graphics.drawLine(x + newR / 2, y + newR / 2, x - newR / 2, y + newR / 2);
                graphics.drawLine(x - newR / 2, y + newR / 2, x - newR / 2, y - newR / 2);

                graphics.drawLine(x - newR / 2, y, x, y - newR / 2);
                graphics.drawLine(x, y - newR / 2, x + newR / 2, y);
                graphics.drawLine(x + newR / 2, y, x, y + newR / 2);
                graphics.drawLine(x, y + newR / 2, x - newR / 2, y);

                graphics.drawLine(x - newR / 4, y - newR / 4, x + newR / 4, y - newR / 4);
                graphics.drawLine(x + newR / 4, y - newR / 4, x + newR / 4, y + newR / 4);
                graphics.drawLine(x + newR / 4, y + newR / 4, x - newR / 4, y + newR / 4);
                graphics.drawLine(x - newR / 4, y + newR / 4, x - newR / 4, y - newR / 4);

                graphics.setColor(Color.black);
                graphics.fillRect(x - 5, y - r, 10, 10);
                graphics.fillRect(x - r, y - 5, 10, 10);
                graphics.fillRect(x + r - 10, y - 5, 10, 10);
                graphics.fillRect(x - 5, y + r - 10, 10, 10);
                break;
        }
    }

    void drawAnotherStuff(Graphics2D graphics, Color colorOfDecoration) {
        graphics.setColor(Color.red);
        graphics.fillOval(x - 5, y - 15, 25, 20);
        graphics.setColor(Color.white);
        graphics.fillOval(x, y - 10, 10, 5);

        graphics.fillOval(x - 20, y - 30, 10, 10);
        graphics.fillOval(x + 10, y - 35, 10, 10);
        graphics.drawArc(x - r / 4, y - r / 4, r, r, 10, -150);
    }

    public int getCakeType() {
        return cakeType;
    }

    public void setCakeType(int cakeType) {
        this.cakeType = cakeType;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getDecorationType() {
        return decorationType;
    }

    public void setDecorationType(int decorationType) {
        this.decorationType = decorationType;
    }

    public Color getColorOfCake() {
        return colorOfCake;
    }

    public void setColorOfCake(Color colorOfCake) {
        this.colorOfCake = colorOfCake;
    }

    public Color getColorOfDecoration() {
        return colorOfDecoration;
    }

    public void setColorOfDecoration(Color colorOfDecoration) {
        this.colorOfDecoration = colorOfDecoration;
    }
}
