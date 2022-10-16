package ru.vsu.cs.shevchenko_daniil;

import java.awt.*;

public class Background {
    private int y, width, height, step, distance = 0;
    private Color plateColor1, plateColor2;


    void drawBottom(Graphics2D graphics) {
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

    void drawRoof(Graphics2D graphics) {
        graphics.setColor(Color.black);
        graphics.fillRect(0, getHeight(), getWidth() / 10, getHeight() / 3 + 30);
        int counter = getHeight() + 25;
        graphics.setColor(Color.gray);
        while (counter < getHeight() + getHeight() / 3 + 30) {
            graphics.fillRect(0, counter, getWidth() / 10, getHeight() / 20);
            counter += getHeight() / 10;
        }
    }

    void drawTopPanel(Graphics2D graphics) {
        graphics.setColor(Color.black);
        graphics.drawRect(getWidth() / 10 * 8, getHeight() / 20, getWidth() / 6, getHeight() / 3);
        graphics.setColor(plateColor1);
        graphics.fillRect(getWidth() / 10 * 8 + 1, getHeight() / 20 + 1, getWidth() / 6 - 1, getHeight() / 3 - 1);

        graphics.setColor(Color.black);

        graphics.drawLine(getWidth() / 10 * 8 + 20, getHeight() / 20 + 30, getWidth() / 10 * 8 + 20, getHeight() / 20 + 130);
        graphics.drawLine(getWidth() / 10 * 8 + 20, getHeight() / 20 + 30, getWidth() / 10 * 8 + 70, getHeight() / 20 + 30);
        graphics.drawLine(getWidth() / 10 * 8 + 20, getHeight() / 20 + 130, getWidth() / 10 * 8 + 70, getHeight() / 20 + 130);

        graphics.drawLine(getWidth() / 10 * 8 + 100, getHeight() / 20 + 130, getWidth() / 10 * 8 + 130, getHeight() / 20 + 30);
        graphics.drawLine(getWidth() / 10 * 8 + 130, getHeight() / 20 + 30, getWidth() / 10 * 8 + 160, getHeight() / 20 + 130);
        graphics.drawLine(getWidth() / 10 * 8 + 100, getHeight() / 20 + 80, getWidth() / 10 * 8 + 160, getHeight() / 20 + 80);

        graphics.drawLine(getWidth() / 10 * 8 + 180, getHeight() / 20 + 30, getWidth() / 10 * 8 + 180, getHeight() / 20 + 130);
        graphics.drawLine(getWidth() / 10 * 8 + 180, getHeight() / 20 + 60, getWidth() / 10 * 8 + 210, getHeight() / 20 + 130);
        graphics.drawLine(getWidth() / 10 * 8 + 180, getHeight() / 20 + 60, getWidth() / 10 * 8 + 210, getHeight() / 20 + 30);

        graphics.drawLine(getWidth() / 10 * 8 + 230, getHeight() / 20 + 30, getWidth() / 10 * 8 + 230, getHeight() / 20 + 130);
        graphics.drawLine(getWidth() / 10 * 8 + 230, getHeight() / 20 + 30, getWidth() / 10 * 8 + 270, getHeight() / 20 + 30);
        graphics.drawLine(getWidth() / 10 * 8 + 230, getHeight() / 20 + 80, getWidth() / 10 * 8 + 270, getHeight() / 20 + 80);
        graphics.drawLine(getWidth() / 10 * 8 + 230, getHeight() / 20 + 130, getWidth() / 10 * 8 + 270, getHeight() / 20 + 130);
    }

    void drawFloor(Graphics2D graphics, int y, int size, Color color1, Color color2) {
        int counterX = 0;
        int counterY = 0;
        Color colorTemp;
        while (counterY < getHeight() + 100) {
            while (counterX < getWidth()) {
                graphics.setColor(color1);
                graphics.fillRect(counterX, counterY, size, size);
                counterX += size;
                graphics.setColor(color2);
                graphics.fillRect(counterX, counterY, size, size);
                counterX += size;
            }
            colorTemp = color1;
            color1 = color2;
            color2 = colorTemp;
            counterX = 0;
            counterY += size;
        }
    }

    void drawWall(Graphics2D graphics, int y) {
        graphics.setColor(new Color(205, 127, 50));
        graphics.fillRect(0, 0, width, y);

        graphics.setColor(Color.black);
        for (int i = 0; i < 190; i++) {
            graphics.drawLine(i*20, 0, i*20, y);
        }
    }

    void drawDoor(Graphics2D graphics) {
        graphics.setColor(new Color(0x5D3806));
        graphics.fillRect(getWidth()/40, getHeight()/100, getWidth()/20, getHeight()/3);
        graphics.setColor(Color.white);
        graphics.fillRect(getWidth()/40+10, getHeight()/100+15, getWidth()/30, getHeight()/8);
        graphics.setColor(new Color(0xFA8A8AE1, true));
        graphics.fillRect(getWidth()/40+15, getHeight()/100+19, getWidth()/35, getHeight()/9);
        graphics.setColor(new Color(0x5D3806));
        graphics.fillRect(getWidth()/40+35, getHeight()/100+15, getWidth()/200, getHeight()/4);
        graphics.fillRect(getWidth()/40, getHeight()/100+40, getWidth()/20, getHeight()/60);
    }

    void drawButtons(Graphics2D graphics) {
        graphics.setColor(Color.darkGray);
        graphics.fillRect(getWidth()/10*6,getHeight()/12, getWidth()/10, getHeight()/8);
        graphics.setColor(Color.lightGray);
        graphics.fillRect(getWidth()/10*6+8,getHeight()/12+5, getWidth()/11, getHeight()/10);

        graphics.setColor(Color.black);
        graphics.fillOval(getWidth()/10*6+18,getHeight()/12+15, 25, 25);
        graphics.fillOval(getWidth()/10*6+68,getHeight()/12+15, 25, 25);
        graphics.fillOval(getWidth()/10*6+118,getHeight()/12+15, 25, 25);
        graphics.fillRect(getWidth()/10*6+153, getHeight()/12+15, 25, 25);

        graphics.setColor(Color.red);
        graphics.fillOval(getWidth()/10*6+23,getHeight()/12+19, 15, 15);
        graphics.fillOval(getWidth()/10*6+73,getHeight()/12+19, 15, 15);
        graphics.fillOval(getWidth()/10*6+123,getHeight()/12+19, 15, 15);

        graphics.setColor(Color.green);
        graphics.fillRect(getWidth()/10*6+158, getHeight()/12+20, 15, 15);
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
