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
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(this.outline);
        g2d.drawOval(this.getX(), this.getY(), this.w, this.w);
        g2d.setColor(this.background);
        g2d.fillOval(this.getX(), this.getY(), this.w, this.w);
    }
}
