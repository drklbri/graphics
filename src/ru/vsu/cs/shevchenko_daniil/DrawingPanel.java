package ru.vsu.cs.shevchenko_daniil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingPanel extends JPanel {

    private static final Color conveyorBeltColor = new Color(81, 81, 81);
    private static final Color moldIn = new Color(0xB4B3B3);
    private static final Color moldOut = new Color(0x72512D);
    private static final Color backgroundPlateColor1 = new Color(194, 197, 206);
    private static final Color backgroundPlateColor2 = new Color(149, 152, 157);


    private Timer t;
    private int oldHeight, oldWight;

    private ConveyorBelt conveyorBelt;
    private CakeMold cakeMold;
    private Background background;

    private CakeMold[] cakeMolds;

    public DrawingPanel() {

        oldHeight = getHeight();
        oldWight = getWidth();
        setSize(1920, 1080);

        conveyorBelt = new ConveyorBelt(
                getHeight()/2,
                getWidth(),
                getHeight()/8,
                200,
                conveyorBeltColor);

        cakeMold = new CakeMold(
                conveyorBelt.getStep()/3+1500,
                conveyorBelt.getY()+ conveyorBelt.getLength()/15,
                conveyorBelt.getLength()-20,
                moldOut,
                moldIn);

        cakeMolds = new CakeMold[10];
        for (int i = 0; i < 10; i++) {
            cakeMolds[i] = new CakeMold(
                    conveyorBelt.getStep() * i + conveyorBelt.getPosition() - 30,
                    conveyorBelt.getY()+ conveyorBelt.getLength()/15,
                    conveyorBelt.getLength()-20,
                    moldOut,
                    moldIn);
        }

        background = new Background(
                conveyorBelt.getY()+conveyorBelt.getLength(),
                getWidth(),
                500,
                conveyorBelt.getStep()/2,
                backgroundPlateColor1,
                backgroundPlateColor2
        );


        t = new Timer(10, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conveyorBelt.incPosition();
                for (int i = 0; i < 10; i++)
                    cakeMolds[i].move();
                repaint();
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (t.isRunning()){

                    t.stop();
                }
                else {
                    t.start();
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

        conveyorBelt.draw(graphics);
        for (int i = 0; i < 10; i++) {
            cakeMolds[i].draw(graphics);
        }
        background.draw(graphics);




    }
}
