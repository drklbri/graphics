package ru.vsu.cs.shevchenko_daniil;

import java.awt.*;
import java.awt.geom.*;

public class Trapezium implements Shape {
    private GeneralPath trapezium = new GeneralPath();

    public Trapezium (Graphics graphics, int x1, int y1, int x2, int y2, int length)
    {

        double Ax = x1;
        double Ay = y1;

        double Bx = x2;
        double By = y2;

        double Cx = x2 + length;
        double Cy = y2;

        double Dx = x1 + length;
        double Dy = y1;


        trapezium.moveTo(Ax, Ay);
        trapezium.lineTo(Bx, By);
        trapezium.lineTo(Cx, Cy);
        trapezium.lineTo(Dx, Dy);
        trapezium.lineTo(Ax, Ay);
        trapezium.closePath();

    }

    @Override
    public java.awt.Rectangle getBounds() {
        return trapezium.getBounds();
    }

    @Override
    public Rectangle2D getBounds2D() {
        return trapezium.getBounds2D();
    }

    @Override
    public boolean contains(double x, double y) {
        return trapezium.contains(x, y);
    }

    @Override
    public boolean contains(Point2D p) {
        return trapezium.contains(p);
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return trapezium.intersects(x, y, w, h);
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        return trapezium.intersects(r);
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        return trapezium.contains(x, y,w ,h);
    }

    @Override
    public boolean contains(Rectangle2D r) {
        return trapezium.contains(r);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return trapezium.getPathIterator(at);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return trapezium.getPathIterator(at, flatness);
    }
}