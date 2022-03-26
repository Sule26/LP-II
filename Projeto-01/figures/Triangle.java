package figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Triangle extends Figure {

    public Triangle(int x, int y, int w, int h, Color background) {
        super(x, y, w, h, background);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int[] xdir = { this.x, ((this.w) / 2) + this.x, this.w + this.x };
        int[] ydir = { this.y + h, this.y + h - this.h, this.y + h };
        g2d.drawPolygon(xdir, ydir, 3);
        g2d.setColor(this.background);
        g2d.fillPolygon(xdir, ydir, 3);
    }

}