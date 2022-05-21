package figures;

import java.awt.*;

public class Pentagon extends Figure {

    private Polygon pentagon;

    public Pentagon(int x, int y, int w, int h, Color background, Color outline, int opacity) {
        super(x, y, w, h, background, outline, opacity);

        this.pentagon = new Polygon();

        this.pentagon.addPoint((int) (this.getX() + this.getW() / 2), this.getY());
        this.pentagon.addPoint(this.getX() + this.getW(), (int) (this.getY() + this.getH() * 0.40));
        this.pentagon.addPoint((int) (this.getX() + this.getW() * 0.75), this.getY() + this.getH());
        this.pentagon.addPoint((int) (this.getX() + this.getW() * 0.25), this.getY() + this.getH());
        this.pentagon.addPoint(this.getX(), (int) (this.getY() + this.getH() * 0.40));
    }

    @Override
    public void paint(Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(render);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity * 0.1f));
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(this.outline);
        g2d.drawPolygon(pentagon);
        g2d.setColor(this.background);
        g2d.fillPolygon(pentagon);
        if (focused) {
            g2d.setColor(Color.red);
            g2d.drawPolygon(pentagon);
        }
    }

    @Override
    public boolean clicked(int x, int y) {
        return this.pentagon.contains(x, y);
    }

    @Override
    public int[] getPosition() {
        return new int[] { this.getX(), this.getY() };
    }

    @Override
    public void setPosition(int[] coordenada) {
        this.x += coordenada[0];
        this.y += coordenada[1];
        this.pentagon.translate(coordenada[0], coordenada[1]);
    }

    @Override
    public void resize(int rw) {
        if (this.getW() >= 200) {
            this.setW(200);
            this.setH(200);
        } else if (this.getW() <= 30) {
            this.setW(30);
            this.setH(30);
        }
        this.setW(this.getW() + rw);
        this.setH(this.getH() + rw);

        this.pentagon.reset();

        this.pentagon.addPoint((int) (this.getX() + this.getW() / 2), this.getY());
        this.pentagon.addPoint(this.getX() + this.getW(), (int) (this.getY() + this.getH() * 0.40));
        this.pentagon.addPoint((int) (this.getX() + this.getW() * 0.75), this.getY() + this.getH());
        this.pentagon.addPoint((int) (this.getX() + this.getW() * 0.25), this.getY() + this.getH());
        this.pentagon.addPoint(this.getX(), (int) (this.getY() + this.getH() * 0.40));
    }

    @Override
    public void increaseSize() {
        if (this != null && this.w <= 200) {
            this.w += 10;
            this.h += 10;
        }
        this.pentagon.reset();

        this.pentagon.addPoint((int) (this.getX() + this.getW() / 2), this.getY());
        this.pentagon.addPoint(this.getX() + this.getW(), (int) (this.getY() + this.getH() * 0.40));
        this.pentagon.addPoint((int) (this.getX() + this.getW() * 0.75), this.getY() + this.getH());
        this.pentagon.addPoint((int) (this.getX() + this.getW() * 0.25), this.getY() + this.getH());
        this.pentagon.addPoint(this.getX(), (int) (this.getY() + this.getH() * 0.40));

    }

    @Override
    public void dicreaseSize() {
        if (this != null && this.w >= 30) {
            this.w -= 10;
            this.h -= 10;
        }
        this.pentagon.reset();

        this.pentagon.addPoint((int) (this.getX() + this.getW() / 2), this.getY());
        this.pentagon.addPoint(this.getX() + this.getW(), (int) (this.getY() + this.getH() * 0.40));
        this.pentagon.addPoint((int) (this.getX() + this.getW() * 0.75), this.getY() + this.getH());
        this.pentagon.addPoint((int) (this.getX() + this.getW() * 0.25), this.getY() + this.getH());
        this.pentagon.addPoint(this.getX(), (int) (this.getY() + this.getH() * 0.40));

    }


}
