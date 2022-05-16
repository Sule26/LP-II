package figures;

import java.awt.*;

public class Pentagon extends Figure {

    int[] xdir = { (int) (this.getX() + this.getW() / 2), this.getX() + this.getW(),
            (int) (this.getX() + this.getW() * 0.75), (int) (this.getX() + this.getW() * 0.25), this.getX() };
    int[] ydir = { this.getY(), (int) (this.getY() + this.getH() * 0.40), this.getY() + this.getH(),
            this.getY() + this.getH(), (int) (this.getY() + this.getH() * 0.40) };

    public Pentagon(int x, int y, int w, int h, Color background, Color outline, int opacity) {
        super(x, y, w, h, background, outline, opacity);
    }

    @Override
    public void paint(Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity * 0.1f));
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(this.outline);
        g2d.drawPolygon(xdir, ydir, 5);
        g2d.setColor(this.background);
        g2d.fillPolygon(xdir, ydir, 5);
    }

    @Override
    public void drawBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int[] xdir = { (int) ((this.getX() - 3) + (this.getW() + 6) / 2), (this.getX() - 3) + (this.getW() + 6),
                (int) ((this.getX() - 3) + (this.getW() + 6) * 0.75),
                (int) ((this.getX() - 3) + (this.getW() + 6) * 0.25), this.getX() - 3 };
        int[] ydir = { (this.getY() - 3), (int) ((this.getY() - 3) + (this.getH() + 6) * 0.40),
                (this.getY() - 3) + (this.getH() + 6),
                (this.getY() - 3) + (this.getH() + 6), (int) ((this.getY() - 3) + (this.getH() + 6) * 0.40) };
        g2d.setColor(Color.red);
        g2d.drawPolygon(xdir, ydir, 5);
    }

    @Override
    public boolean clicked(int x, int y) {
        return (this.getX() <= x && x <= this.getX() + this.getW() && this.getY() <= y
                && y <= this.getY() + this.getH());
    }

    public double areaPentagon() {
        double l = Math
                .sqrt(Math.abs(Math.pow(this.xdir[0] - this.xdir[1], 2) + Math.pow(this.ydir[0] - this.ydir[1], 2)));
        double a = l / 1.453;
        return 5 * l * a;
    }

    public double areaTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }
}
