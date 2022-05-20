package figures;

import ivisible.IVisible;
import java.awt.Graphics;
import java.awt.Color;
import java.io.Serializable;

public abstract class Figure implements IVisible, Serializable {
    protected int x, y;
    protected int w, h;
    protected Color background, outline;
    protected int opacity;
    boolean quad = false;

    public Figure(int x, int y, int w, int h, Color background, Color outline, int opacity) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.background = background;
        this.outline = outline;
        this.opacity = opacity;
    }

    public abstract void paint(Graphics g, boolean focused);
    public abstract boolean clicked(int x, int y);
    public abstract int[] getPosition();
    public abstract void setPosition(int[] coordenada);  

    public boolean corner(int x, int y) {
        return x >= this.getX() + this.getW() - 5 && x <= this.getX() + this.getW()
                && y >= this.getY() + this.getH() - 5 && y <= this.getY() + this.getH();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getW() {
        return this.w;
    }

    public int getH() {
        return this.h;
    }

    public void setX(int newX) {
        this.x = newX;
    }

    public void setY(int newY) {
        this.y = newY;
    }

    public void setW(int newW) {
        this.w = newW;
    }

    public void setH(int newH) {
        this.h = newH;
    }

    public Color getBackgroundColor() {
        return this.background;
    }

    public void drag(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void changeBackgroundColor(Color newColor) {
        this.background = newColor;
    }

    public void changeOutlineColor(Color newColor) {
        this.outline = newColor;
    }

    public void increaseSize() {
        if (this != null && this.w <= 100) {
            this.w += 10;
            this.h += 10;
        }
    }

    public void dicreaseSize() {
        if (this != null && this.w >= 20) {
            this.w -= 10;
            this.h -= 10;
        }
    }

    public void increaseOpacity() {
        if (this.opacity < 10) {
            this.opacity += 1;
        }
    }

    public void dicreaseOpacity() {
        if (this.opacity > 1) {
            this.opacity -= 1;
        }
    }

    public void changePositionArrowKeys(int x) {
        // x = 1 = cima
        // x = 2 = direita
        // x = 3 = baixo
        // x = 4 = esquerda
        switch (x) {
            case 1:
                if (this.y > 40) {
                    this.y -= 10;
                }
                break;
            case 2:
                if ((this.x + this.w) < 685) {
                    this.x += 10;
                }
                break;
            case 3:
                if ((this.y + this.h) < 685) {
                    this.y += 10;
                }
                break;
            case 4:
                if (this.x > 10) {
                    this.x -= 10;
                }
                break;
        }
    }

    public boolean resizeButton() {
        return this.quad;
    }

    public void resize(int rw) {
        if(this.w > 100) {
            this.w = 100;
            this.h = 100;
        }else if(this.w < 20) {
            this.w = 20;
            this.h = 20;
        }
        w += rw;
        h += rw;
    }
}
