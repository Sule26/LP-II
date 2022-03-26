package figures;

import java.awt.Graphics;
import java.awt.Color;

public abstract class Figure {
    public int x, y;
    public int w, h;
    public Color background;

    public Figure(int x, int y, int w, int h, Color background) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.background = background;
    }

    public void drag(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public abstract void paint(Graphics g);

    public void border(Graphics g) {
        Graphics g2d = (Graphics) g;
        g2d.setColor(Color.red);
        g2d.drawRect(this.x - 5, this.y - 5, this.w + 10, this.h + 10);
    }
}
