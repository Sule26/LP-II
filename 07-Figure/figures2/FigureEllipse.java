package figures2;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class FigureEllipse extends Figure{

    public FigureEllipse (int x, int y, int w, int h) {
        super(x, y, w, h);

    }

    public void print() {
        System.out.format("Elipse do tamanho (%d,%d) na posição (%d,%d).\n", this.w, this.h, this.x, this.y);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.orange);
        g2d.draw(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(this.x, this.y, this.w, this.h);
    }   
}
