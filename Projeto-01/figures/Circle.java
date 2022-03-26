package figures;

import java.awt.*;
import java.awt.Color;

public class Circle extends Figure{

    public Circle(int x, int y, int w, Color background) {
        super(x, y, w, w, background);

    }

    @Override
    public void paint(Graphics g) {
        Graphics g2d = (Graphics2D) g;
        g2d.drawOval(this.x, this.y, this.w, this.w);
        g2d.setColor(this.background);
        g2d.fillOval(this.x, this.y, this.w, this.w);
    }
}
