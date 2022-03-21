package figures;

import java.awt.*;

public class Circle extends Figure{

    public Circle(int x, int y, int w) {
        super(x, y, w, w);

    }

    public void print() {
        System.out.format("Circulo de raio (%d) na posição (%d, %d).\n", this.w, this.x, this.y);
    }

    public void paint(Graphics g) {
        Graphics g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.drawOval(this.x, this.y, this.w, this.w);
        g2d.setColor(Color.red);
        g2d.fillOval(this.x, this.y, this.w, this.w);
    }
}
