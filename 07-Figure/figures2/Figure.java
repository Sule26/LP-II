package figures2;

import java.awt.Graphics;

public abstract class Figure {

    int x, y;
    int w, h;

    public Figure (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    
    public abstract void print();
    public abstract void paint (Graphics g);
    

}
