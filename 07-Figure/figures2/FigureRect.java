package figures2;

import java.awt.*;

public class FigureRect extends Figure{
    public FigureRect (int x, int y, int w, int h) {
        super(x, y, w, h);
    
    }

    public void print() {
        System.out.format("Retangulo de tamanho (%d,%d) na posição (%d,%d).\n", this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        g.setColor(Color.blue);
        g.drawRect(this.x, this.y, this.w, this.h);
        g.setColor(Color.green);
        g.fillRect(this.x, this.y, this.w, this.h);

    }
}
