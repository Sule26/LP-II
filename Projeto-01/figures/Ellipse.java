package figures;

import java.awt.*;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure {

    public Ellipse(int x, int y, int w, int h, Color background) {
        super(x, y, w, h, background);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
        g2d.setColor(this.background);
        g2d.fillOval(this.x, this.y, this.w, this.h);
    }

}
