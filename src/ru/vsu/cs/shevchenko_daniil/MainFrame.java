package ru.vsu.cs.shevchenko_daniil;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private DrawingPanel dp;

    public MainFrame() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(1920, 1080);
        dp = new DrawingPanel();
        this.add(dp);
    }
}
