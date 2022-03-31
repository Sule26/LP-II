package figures;

import java.awt.*;
import java.awt.Color;

public class Circle extends Figure{

    public Circle(int x, int y, int w, Color background, Color outline, int opacity) {
        super(x, y, w, w, background, outline, opacity);

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity * 0.1f));
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(this.outline);
        g2d.drawOval(this.x, this.y, this.w, this.w);
        g2d.setColor(this.background);
        g2d.fillOval(this.x, this.y, this.w, this.w);
    }
}
