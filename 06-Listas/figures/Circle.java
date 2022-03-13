package figures;

import java.awt.*;

public class Circle {
    int x, y;
    int r;
    
    public Circle (int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public void print () {
        System.out.format("Circulo de raio (%d) na posição (%d, %d).\n", this.r, this.x, this.y);
    }

    public void paint (Graphics g, Color fillColor, Color drawColor) {
        Graphics g2d = (Graphics2D) g;
        g2d.setColor(drawColor);
        g2d.drawOval(this.x, this.y, this.r, this.r);
        g2d.setColor(fillColor);
        g2d.fillOval(this.x, this.y, this.r, this.r);
    }
}
