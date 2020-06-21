package main.java.com.concurrency.chapter14.bounce;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/14 11:13
 */
public class BallComponent extends JPanel {
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 450;

    private java.util.List<Ball> balls = new ArrayList<>();

    public void add(Ball b) {
        balls.add(b);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b: balls) {
            g2.fill(b.getShape());
        }
    }

    public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }
}
