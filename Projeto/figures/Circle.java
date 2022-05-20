package figures;

import java.awt.*;
import java.awt.Color;

public class Circle extends Figure {

    public Circle(int x, int y, int w, Color background, Color outline, int opacity) {
        super(x, y, w, w, background, outline, opacity);

    }

    @Override
    public void paint(Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(render);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity * 0.1f));
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(this.outline);
        g2d.drawOval(this.getX(), this.getY(), this.getW(), this.getW());
        g2d.setColor(this.background);
        g2d.fillOval(this.getX(), this.getY(), this.getW(), this.getW());

        if (focused) {
            g2d.setColor(Color.red);
            g2d.drawOval(this.getX(), this.getY(), this.getW(), this.getW());
        }
    }

    @Override
    public boolean clicked(int x, int y) {
        int cx = this.getX() + (this.getW() / 2);
        int cy = this.getY() + (this.getH() / 2);
        int r = this.getW() / 2;
        return Math.sqrt(Math.pow(x - cx, 2) + Math.pow(y - cy, 2)) <= r;
    }

    public int[] getPosition() {
        return new int[]{this.getX(), this.getY()};
    }

    public void setPosition(int[] coordenada) {
        this.x += coordenada[0];
        this.y += coordenada[1];
    }
}
