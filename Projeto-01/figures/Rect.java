package figures;

import java.awt.*;
import java.awt.Color;

public class Rect extends Figure {

    public Rect (int x, int y, int w, int h, Color background) {
        super(x, y, w, h, background);
    
    }

    @Override
    public void paint (Graphics g) {
        g.drawRect(this.x, this.y, this.w, this.h);
        g.setColor(this.background);
        g.fillRect(this.x, this.y, this.w, this.h);
    }
}
