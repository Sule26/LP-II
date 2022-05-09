package figures;

import java.awt.*;



public class Pentagon extends Figure {

    public Pentagon (int x, int y, int w, int h, Color background, Color outline, int opacity) {
        super(x, y, w, h, background, outline, opacity);
    }
    
    @Override
    public void paint(Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity * 0.1f));
        g2d.setStroke(new BasicStroke(5));
        int[] xdir = {(int) (this.getX() + this.w/2), this.getX() + this.w, (int) (this.getX() + this.w*0.75), (int) (this.getX() + this.w*0.25), this.getX()};
		int[] ydir = {this.getY(), (int) (this.getY() + this.h*0.40), this.getY()+this.h, this.getY()+this.h, (int) (this.getY() + this.h*0.40) };
        g2d.setColor(this.outline);
        g2d.drawPolygon(xdir, ydir, 5); 
		g2d.setColor(this.background);
		g2d.fillPolygon(xdir, ydir, 5);
    }

}
