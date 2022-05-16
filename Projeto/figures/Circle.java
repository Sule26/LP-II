package figures;

import java.awt.*;
import java.awt.Color;

public class Circle extends Figure{

    public Circle(int x, int y, int w, Color background, Color outline, int opacity) {
        super(x, y, w, w, background, outline, opacity);

    }

    @Override
    public void paint(Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity * 0.1f));
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(this.outline);
        g2d.drawOval(this.getX(), this.getY(), this.getW(), this.getW());
        g2d.setColor(this.background);
        g2d.fillOval(this.getX(), this.getY(), this.getW(), this.getW());
    }

    @Override
    public void drawBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.drawOval(this.getX() - 3, this.getY() - 3, this.getW() + 6, this.getW() + 6);
    }

    @Override
    public boolean clicked(int x, int y) {
        int cx = this.getX() + (this.getW() / 2);
        int cy = this.getY() + (this.getH() / 2);
        int r = this.getW() / 2;
        return Math.sqrt(Math.pow(x - cx, 2) + Math.pow(y - cy, 2)) <= r;
    }
}
