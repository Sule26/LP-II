package figures;

import java.awt.*;

public class Triangle extends Figure {
    private Polygon triangle;

    public Triangle(int x, int y, int w, int h, Color background, Color outline, int opacity) {
        super(x, y, w, h, background, outline, opacity);
        this.triangle = new Polygon();

        this.triangle.addPoint(this.getX(), this.getY() + this.getH());
        this.triangle.addPoint(((this.getW()) / 2) + this.getX(), this.getY());
        this.triangle.addPoint(this.getW() + this.getX(), this.getY() + this.getH());
    }

    @Override
    public void paint(Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(render);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity * 0.1f));
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(outline);
        g2d.drawPolygon(triangle);
        g2d.setColor(this.background);
        g2d.fillPolygon(triangle);

        if(focused) {
            g2d.setColor(Color.red);
            g2d.drawPolygon(triangle);
        }
    }

    @Override
    public boolean clicked(int x, int y) {
         return triangle.contains(x, y);
    }

    @Override
    public int[] getPosition() {
        return new int[]{this.getX(), this.getY()};
    }

    @Override
    public void setPosition(int[] coordenada) {
        this.x += coordenada[0];
        this.y += coordenada[1];
        this.triangle.translate(coordenada[0], coordenada[1]);
    }  

    @Override
    public void resize(int rw) {
        if (this.getW() > 200) {
            this.setW(200);
            this.setH(200);
        } else if (this.getW() < 30) {
            this.setW(30);
            this.setH(30);
        }
        this.setW(this.getW() + rw);
        this.setH(this.getH() + rw);

        this.triangle.reset();

        this.triangle.addPoint(this.getX(), this.getY() + this.getH());
        this.triangle.addPoint(((this.getW()) / 2) + this.getX(), this.getY());
        this.triangle.addPoint(this.getW() + this.getX(), this.getY() + this.getH());
    }

    @Override
    public void increaseSize() {
        if (this != null && this.w <= 200) {
            this.w += 10;
            this.h += 10;
        }

        this.triangle.reset();

        this.triangle.addPoint(this.getX(), this.getY() + this.getH());
        this.triangle.addPoint(((this.getW()) / 2) + this.getX(), this.getY());
        this.triangle.addPoint(this.getW() + this.getX(), this.getY() + this.getH());
    }
    @Override
    public void dicreaseSize() {
        if (this != null && this.w >= 30) {
            this.w -= 10;
            this.h -= 10;
        }

        this.triangle.reset();

        this.triangle.addPoint(this.getX(), this.getY() + this.getH());
        this.triangle.addPoint(((this.getW()) / 2) + this.getX(), this.getY());
        this.triangle.addPoint(this.getW() + this.getX(), this.getY() + this.getH());
    }
}
