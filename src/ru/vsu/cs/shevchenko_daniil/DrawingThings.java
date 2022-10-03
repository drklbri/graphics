package ru.vsu.cs.shevchenko_daniil;

import java.awt.*;

public class DrawingThings {

    public static void drawConveyorBelt(Graphics2D graphics, int x1, int y1, int x2, int y2, int length, Color color) {

        graphics.setColor(color);
        Trapezium trap = new Trapezium(graphics, x1, y1, x2, y2, length);
        graphics.fill(trap);

        graphics.setColor(Color.black);
        for (int i = 0; i < 8; i++) {
            graphics.fillRect(x2+i*19, y2, 2, length-17);
        }
        graphics.fillRect(x2 - 19, y1-110, 2, length-80);
        graphics.fillRect(x2 - 38, y1-50, 2, length-140);
        graphics.fillRect(x2 + 8*19, y2, 2, length-75);
        graphics.fillRect(x2 + 9*19, y2, 2, length-130);

        graphics.setColor(Color.orange);
        Arrow arrow = new Arrow(graphics, (x2 - x1 + length) /2 + 20, y2 + length/ 2 - 10, length);
        graphics.fill(arrow);
    }
}
