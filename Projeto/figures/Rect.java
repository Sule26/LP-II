package figures;

import java.awt.*;
import java.awt.Color;

public class Rect extends Figure {

    public Rect(int x, int y, int w, int h, Color background, Color outline, int opacity) {
        super(x, y, w, h, background, outline, opacity);
    }

    @Override
    public void paint(Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity * 0.1f));
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(this.outline);
        g2d.drawRect(this.getX(), this.getY(), this.getW(), this.getH());
        g2d.setColor(this.background);
        g2d.fillRect(this.getX(), this.getY(), this.getW(), this.getH());
    }

    @Override
    public void drawBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.drawRect(this.getX() - 3, this.getY() - 3, this.getW() + 6, this.getH() + 6);
    }

    @Override
    public boolean clicked(int x, int y) {
        return (this.getX() <= x && x <= this.getX() + this.getW() && this.getY() <= y && y <= this.getY() + this.getH());
    }
}
