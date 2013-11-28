package cafitnessclub.view.com;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GradientPanel extends JPanel {

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g.create();
        int w = getWidth();
        int h = getHeight();

        GradientPaint gp = new GradientPaint(
        		0, 0, new Color(184, 225, 225),
        		h, h, new Color(225, 225, 225), true);


        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);

        g2d.dispose();
    }
}
