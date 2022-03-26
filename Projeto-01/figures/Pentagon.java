package figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Pentagon extends Figure {
    
    public Pentagon (int x, int y, int w, int h, Color background) {
        super(x, y, w, h, background);
    }

    @Override
    public void paint(Graphics g) {
        Graphics g2d = (Graphics2D) g;
        int[] xdir = {(int) (this.x + this.w/2), this.x + this.w, (int) (this.x + this.w*0.75), (int) (this.x + this.w*0.25), this.x};
		int[] ydir = {this.y, (int) (this.y + this.h*0.40), this.y+this.h, this.y+this.h, (int) (this.y + this.h*0.40) };
        g2d.drawPolygon(xdir, ydir, 5); 
		g2d.setColor(this.background);
		g2d.fillPolygon(xdir, ydir, 5);
    }

}
