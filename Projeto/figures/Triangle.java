package figures;

import java.awt.*;

public class Triangle extends Figure {

    private int[] xdir = { this.getX(), ((this.getW()) / 2) + this.getX(), this.getW() + this.getX() };
    private int[] ydir = { this.getY() + this.getH(), this.getY(), this.getY() + this.getH() };

    public Triangle(int x, int y, int w, int h, Color background, Color outline, int opacity) {
        super(x, y, w, h, background, outline, opacity);
    }

    @Override
    public void paint(Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity * 0.1f));
        g2d.setStroke(new BasicStroke(2));
        int[] xdir = { this.getX(), ((this.getW()) / 2) + this.getX(), this.getW() + this.getX() };
        int[] ydir = { this.getY() + this.getH(), this.getY(), this.getY() + this.getH() };
        g2d.setColor(outline);
        g2d.drawPolygon(xdir, ydir, 3);
        g2d.setColor(this.background);
        g2d.fillPolygon(xdir, ydir, 3);
    }

    @Override
    public void drawBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
         int[] xdir = { (this.getX() - 3), (((this.getW() + 6)) / 2) + (this.getX() - 3),
                (this.getW() + 6) + (this.getX() - 3) };
        int[] ydir = { (this.getY() - 3) + (this.getH() + 6), (this.getY() - 3),
                (this.getY() - 3) + (this.getH() + 6) };
        g2d.drawPolygon(xdir, ydir, 3);
    }

    @Override
    public boolean clicked(int x, int y) {

        double A = area(this.xdir[0], this.ydir[0],this.xdir[1], this.ydir[1], this.xdir[2], this.ydir[2]);
        double A1 = area(x, y, this.xdir[1], this.ydir[1], this.xdir[2], this.ydir[2]);
        double A2 = area(this.xdir[0], this.ydir[0], x, y,  this.xdir[2], this.ydir[2]);
        double A3 = area(this.xdir[0], this.ydir[0], this.xdir[1], this.ydir[1], x, y);

        return A == A1 + A2 + A3;
    }

    public double area(int x1, int y1, int x2,  int y2, int x3, int y3) {
        return Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0);
    }
}
