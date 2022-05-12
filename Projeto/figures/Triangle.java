package figures;

import java.awt.*;

public class Triangle extends Figure {

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

}
