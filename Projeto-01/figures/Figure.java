package figures;

import ivisible.IVisible;

import java.awt.Graphics;
import java.awt.Color;

public abstract class Figure implements IVisible {
    public int x, y;
    public int w, h;
    public Color background, outline;
    public int opacity;

    public Figure(int x, int y, int w, int h, Color background, Color outline, int opacity) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.background = background;
        this.outline = outline;
        this.opacity = opacity;
    }
    
    public abstract void paint(Graphics g);

    private void drag(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public boolean clicked(int x, int y) {
        return (this.x <= x && x <= this.x + this.w && this.y <= y && y <= this.y + this.h);
    }

    public void border(Graphics g) {
        g.setColor(Color.red);
        g.drawRect(this.x - 5, this.y - 5, this.w + 10, this.h + 10);
    }

}
