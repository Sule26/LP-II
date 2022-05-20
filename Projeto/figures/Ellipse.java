package figures;

import java.awt.*;
import java.awt.Color;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Figure {

    public Ellipse(int x, int y, int w, int h, Color background, Color outline, int opacity) {
        super(x, y, w, h, background, outline, opacity);
    }

    @Override
    public void paint(Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(render);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity * 0.1f));
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(this.outline);
        g2d.draw(new Ellipse2D.Double(this.getX(), this.getY(), this.getW() / 2, this.getH()));
        g2d.setColor(this.background);
        g2d.fillOval(this.getX(), this.getY(), this.getW() / 2, this.getH());

        if(focused) {
            g2d.setColor(Color.red);
            g2d.draw(new Ellipse2D.Double(this.getX(), this.getY(), this.getW() / 2, this.getH()));
        }
    }

    @Override
    public boolean clicked(int x, int y) {
        int h = (this.getW() / 4);
        int k = (this.getH() / 2);
        int dx = x - (this.getX() + this.getW() / 4);
        int dy = y - (this.getY() + this.getH() / 2);
        return (Math.pow(dx, 2) / Math.pow(h, 2) + Math.pow(dy, 2) / Math.pow(k, 2)) <= 1;
    }

    public int[] getPosition() {
        return new int[]{this.getX(), this.getY()};
    }

    public void setPosition(int[] coordenada) {
        this.x += coordenada[0];
        this.y += coordenada[1];
    }
}
