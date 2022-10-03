package ru.vsu.cs.shevchenko_daniil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingPanel extends JPanel {

    private static final Color conveyorBeltColor = new Color(81, 81, 81);

    private Timer t;
    private int oldHeight, oldWight;

    private ConveyorBelt conveyorBelt;
    private ConveyorBelt[] conveyorBelts;

    public DrawingPanel() {

        oldHeight = getHeight();
        oldWight = getWidth();
        setSize(1920, 1080);

        conveyorBelt = new ConveyorBelt(getWidth()/200, getHeight()/2, getWidth()/30, getHeight()/3, getWidth()/10, conveyorBeltColor);
        conveyorBelts = new ConveyorBelt[10];
        for (int i = 0; i < conveyorBelts.length; i++) {
            conveyorBelts[i] = new ConveyorBelt(getWidth()/200 + i * conveyorBelt.getLength(), getWidth()/30, getWidth()/30 +  i * conveyorBelt.getLength(), getWidth()/3, getWidth()/10, conveyorBeltColor);
        }


        t = new Timer(10, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

        if (getHeight()!=oldHeight || getWidth()!= oldWight){
            conveyorBelt.resize(getWidth());
            oldHeight=getHeight();
            oldWight=getWidth();
        }

        DrawingThings.drawConveyorBelt(graphics, getWidth()/200, getHeight()/2, getWidth()/30, getHeight()/3, getWidth()/10, conveyorBeltColor);


    }
}
