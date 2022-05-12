package figures;

import java.awt.*;
import java.awt.Color;
import java.awt.geom.Ellipse2D;


public class Ellipse extends Figure {

    public Ellipse(int x, int y, int w, int h, Color background, Color outline, int opacity) {
        super(x, y, w, h, background, outline, opacity);
    }

    @Override
    public void paint(Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity * 0.1f));
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(this.outline);
        g2d.draw(new Ellipse2D.Double(this.getX(), this.getY(), this.getW() / 2, this.getH()));
        g2d.setColor(this.background);
        g2d.fillOval(this.getX(), this.getY(), this.getW() / 2, this.getH());
    }

    @Override
    public void drawBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.draw(new Ellipse2D.Double(this.getX() - 3, this.getY() - 3, (this.getW() / 2) + 6, this.getH() + 6));

    }

}
