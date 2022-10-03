package ru.vsu.cs.shevchenko_daniil;

import java.awt.*;
import java.awt.geom.*;

public class Arrow implements Shape {
    private GeneralPath arrow = new GeneralPath();

    public Arrow (Graphics graphics, int x, int y, int length)
    {

        double Ax = x;
        double Ay = y;

        double Bx = Ax - 50;
        double By = Ay - 50;

        double Cx = Bx + 20;
        double Cy = By - 20;

        double Dx = x + 50;
        double Dy = y;


        double Fx = Ax - 50;
        double Fy = Ay + 50;

        double Ex = Fx + 20;
        double Ey = Fy + 20;





        arrow.moveTo(Ax, Ay);
        arrow.lineTo(Bx, By);
        arrow.lineTo(Cx, Cy);
        arrow.lineTo(Dx, Dy);
        arrow.lineTo(Ex, Ey);
        arrow.lineTo(Fx, Fy);
        arrow.lineTo(Ax, Ay);
        arrow.closePath();

    }


    @Override
    public Rectangle getBounds() {
        return arrow.getBounds();
    }

    @Override
    public Rectangle2D getBounds2D() {
        return arrow.getBounds2D();
    }

    @Override
    public boolean contains(double x, double y) {
        return arrow.contains(x, y);
    }

    @Override
    public boolean contains(Point2D p) {
        return arrow.contains(p);
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return arrow.intersects(x, y, w, h);
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        return arrow.intersects(r);
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        return arrow.contains(x, y,w ,h);
    }

    @Override
    public boolean contains(Rectangle2D r) {
        return arrow.contains(r);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return arrow.getPathIterator(at);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return arrow.getPathIterator(at, flatness);
    }
}