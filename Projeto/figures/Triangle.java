package figures;

import java.awt.*;

public class Triangle extends Figure {

    public Triangle(int x, int y, int w, int h, Color background, Color outline, int opacity) {
        super(x, y, w, h, background, outline, opacity);
    }

    @Override
    public void paint(Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        int[] xdir = { this.getX(), ((this.getW()) / 2) + this.getX(), this.getW() + this.getX() };
        int[] ydir = { this.getY() + this.getH(), this.getY(), this.getY() + this.getH() };
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity * 0.1f));
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(outline);
        g2d.drawPolygon(xdir, ydir, 3);
        g2d.setColor(this.background);
        g2d.fillPolygon(xdir, ydir, 3);

        if(focused) {
            this.drawBorder(g2d);
        }
    }

    @Override
    public void drawBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int[] xBorder = { (this.getX() - 5), (((this.getW() + 10)) / 2) + (this.getX() - 5), (this.getW() + 10) + (this.getX() - 5) };
        int[] yBorder = { (this.getY() - 5) + (this.getH() + 10), (this.getY() - 5), (this.getY() - 5) + (this.getH() + 10) };
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.red);
        g2d.drawPolygon(xBorder, yBorder, 3);
    }

    @Override
    public boolean clicked(int x, int y) {
        int[] xdir = { this.getX(), ((this.getW()) / 2) + this.getX(), this.getW() + this.getX() };
        int[] ydir = { this.getY() + this.getH(), this.getY(), this.getY() + this.getH() };
        double A = area(xdir[0], ydir[0], xdir[1], ydir[1], xdir[2], ydir[2]);
        double A1 = area(x, y, xdir[1], ydir[1], xdir[2], ydir[2]);
        double A2 = area(xdir[0], ydir[0], x, y, xdir[2], ydir[2]);
        double A3 = area(xdir[0], ydir[0], xdir[1], ydir[1], x, y);
        return A == A1 + A2 + A3;

        // Easiest way:
        /*
         * Polygon p = new Polygon(xdir, ydir, 3);
         * return p.contains(x, y);
         */
    }

    public double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }
}
