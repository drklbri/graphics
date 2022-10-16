package ru.vsu.cs.shevchenko_daniil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class DrawingPanel extends JPanel {

    private static final Color conveyorBeltColor = new Color(81, 81, 81);
    private static final Color moldIn = new Color(0xB4B3B3);
    private static final Color moldOut = new Color(0x72512D);
    private static final Color backgroundPlateColor1 = new Color(194, 197, 206);
    private static final Color backgroundPlateColor2 = new Color(149, 152, 157);
    private static final Color cakeColor1 = new Color(0xC5C4A5A5, true);


    private Timer t1, t2, t3;
    private int oldHeight, oldWight;

    private ConveyorBelt conveyorBelt1;
    private ConveyorBelt conveyorBelt2;
    private ConveyorBelt conveyorBelt3;
    private Cake cake;
    private Background background;

    private CakeMold[] cakeMolds;
    private CakeMold cakeMold;

    private Random rnd;

    public DrawingPanel() {

        rnd = new Random();

        oldHeight = getHeight();
        oldWight = getWidth();
        setSize(1920, 1080);


        conveyorBelt1 = new ConveyorBelt(
                getHeight() / 2,
                getWidth(),
                getHeight() / 8,
                200,
                conveyorBeltColor
        );

        conveyorBelt2 = new ConveyorBelt(
                getHeight() / 3,
                getWidth(),
                getHeight() / 16,
                100,
                conveyorBeltColor
        );

        conveyorBelt3 = new ConveyorBelt(
                getHeight() / 5,
                getWidth(),
                getHeight() / 32,
                50,
                conveyorBeltColor
        );

        cakeMold = new CakeMold(
                conveyorBelt1.getStep()  * 2 + conveyorBelt1.getPosition() - 20,
                conveyorBelt1.getY()+ conveyorBelt1.getLength()/15,
                conveyorBelt1.getLength()-20,
                moldOut,
                moldIn
        );

       /* cakeMolds = new CakeMold[3];
        for (int i = 0; i < 3; i++) {
            cakeMolds[i] = new CakeMold(
                    conveyorBelt.getStep() * i * 2 + conveyorBelt.getPosition() - 20,
                    conveyorBelt.getY()+ conveyorBelt.getLength()/15,
                    conveyorBelt.getLength()-20,
                    moldOut,
                    moldIn);
        }*/

        cake = new Cake(
                1,
                2,
                40,
                cakeMold.getX()-55,
                cakeMold.getY()+cakeMold.getR()/2,
                cakeColor1,
                moldIn
        );

        background = new Background(
                conveyorBelt1.getY()+conveyorBelt1.getLength(),
                getWidth(),
                500,
                conveyorBelt1.getStep()/2,
                backgroundPlateColor1,
                backgroundPlateColor2
        );


        t1 = new Timer(1, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conveyorBelt1.incPosition();
                /*for (int i = 0; i < 3; i++)
                    cakeMolds[i].move();*/
                cakeMold.move();
                cake.move();
                repaint();
            }
        });

        t2 = new Timer(5, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conveyorBelt2.incPosition();
                repaint();
            }
        });

        t3 = new Timer(10, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conveyorBelt3.incPosition();
                repaint();
            }
        });



        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (t1.isRunning()){

                    t1.stop();
                }
                else {
                    t1.start();
                }

                if (t2.isRunning()){

                    t2.stop();
                }
                else {
                    t2.start();
                }

                if (t3.isRunning()){

                    t3.stop();
                }
                else {
                    t3.start();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D graphics = (Graphics2D) g;

        if (oldHeight ==0 && oldWight==0){
            oldHeight=getHeight();
            oldWight=getWidth();
        }

       /* if (getHeight()!=oldHeight || getWidth()!= oldWight){
            conveyorBelt.draw(graphics);
            oldHeight=getHeight();
            oldWight=getWidth();
            conveyorBelt.resize(oldWight, oldHeight);
        }*/
        background.drawFloor(graphics, conveyorBelt1.getY(), 50, Color.black, Color.white);
        background.drawWall(graphics, conveyorBelt3.getY()-10);
        background.drawButtons(graphics);
        background.drawDoor(graphics);
        background.drawTopPanel(graphics);
        conveyorBelt1.draw(graphics);
        conveyorBelt2.draw(graphics);
        conveyorBelt3.draw(graphics);
        /*for (int i = 0; i < 3; i++) {
            cakeMolds[i].draw(graphics);
        }*/
        cakeMold.draw(graphics);
        background.drawBottom(graphics);
        cake.draw(graphics);

        background.drawRoof(graphics);


    }
}
