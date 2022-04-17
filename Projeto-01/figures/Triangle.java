package figures;

import java.awt.*;



public class Triangle extends Figure {

    public Triangle(int x, int y, int w, int h, Color background, Color outline, int opacity) {
        super(x, y, w, h, background, outline, opacity);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity * 0.1f));
        g2d.setStroke(new BasicStroke(5));
        int[] xdir = { this.x, ((this.w) / 2) + this.x, this.w + this.x };
        int[] ydir = { this.y + h, this.y + h - this.h, this.y + h };
        g2d.setColor(outline);
        g2d.drawPolygon(xdir, ydir, 3);
        g2d.setColor(this.background);
        g2d.fillPolygon(xdir, ydir, 3);
    }

}
