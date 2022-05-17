package figures;

import java.awt.*;

public class Pentagon extends Figure {

    public Pentagon(int x, int y, int w, int h, Color background, Color outline, int opacity) {
        super(x, y, w, h, background, outline, opacity);
    }

    @Override
    public void paint(Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        int[] xdir = { (int) (this.getX() + this.getW() / 2), this.getX() + this.getW(), (int) (this.getX() + this.getW() * 0.75), (int) (this.getX() + this.getW() * 0.25), this.getX() };
        int[] ydir = { this.getY(), (int) (this.getY() + this.getH() * 0.40), this.getY() + this.getH(), this.getY() + this.getH(), (int) (this.getY() + this.getH() * 0.40) };
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity * 0.1f));
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(this.outline);
        g2d.drawPolygon(xdir, ydir, 5);
        g2d.setColor(this.background);
        g2d.fillPolygon(xdir, ydir, 5);

        if(focused) {
            this.drawBorder(g2d);
        }
    }

    @Override
    public void drawBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int[] xBorder = { (int) ((this.getX() - 5) + (this.getW() + 10) / 2), (this.getX() - 5) + (this.getW() + 10), (int) ((this.getX() - 5) + (this.getW() + 10) * 0.75), (int) ((this.getX() - 5) + (this.getW() + 10) * 0.25), this.getX() - 5 };
        int[] yBorder = { (this.getY() - 5), (int) ((this.getY() - 5) + (this.getH() + 10) * 0.40), (this.getY() - 5) + (this.getH() + 10), (this.getY() - 5) + (this.getH() + 10), (int) ((this.getY() - 5) + (this.getH() + 10) * 0.40) };
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(Color.red);
        g2d.drawPolygon(xBorder, yBorder, 5);
    }

    @Override
    public boolean clicked(int x, int y) {
        int[] xdir = { (int) (this.getX() + this.getW() / 2), this.getX() + this.getW(), (int) (this.getX() + this.getW() * 0.75), (int) (this.getX() + this.getW() * 0.25), this.getX() };
        int[] ydir = { this.getY(), (int) (this.getY() + this.getH() * 0.40), this.getY() + this.getH(), this.getY() + this.getH(), (int) (this.getY() + this.getH() * 0.40) };
        Polygon p = new Polygon(xdir, ydir, 5);
        return p.contains(x, y);
    }
}
