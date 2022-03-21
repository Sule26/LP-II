package figures;

import java.awt.*;

public class Line extends Figure{
    
    public Line(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void print() {
        System.out.format("Linha de tamanho (%d,%d)", this.x, this.y);
    }

    public void paint(Graphics g) {
        g.setColor(Color.PINK);
        g.drawLine(x, y, w, h);
    }
}
