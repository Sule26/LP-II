package buttons;

import ivisible.IVisible;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.*;
import figures.*;

public class ButtonFigures implements IVisible {
  private int x, y;
  private int w, h;
  public int idx;
  private BufferedImage colors, trash;

  public ButtonFigures(int idx, int x, int y, int w, int h) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.idx = idx;
  }

  /*
   * public void setFigure(Figure figure) {
   * this.figure = figure;
   * }
   */

  public boolean clicked(int x, int y) {
    return x >= this.x && x <= this.x + this.w && y >= this.y && y <= this.y + this.h;
  }

  public void paint(Graphics g, boolean focused) {
    Graphics2D g2d = (Graphics2D) g;
    /*
     * g2d.setStroke(new BasicStroke(3));
     * g2d.setColor(Color.black);
     * if (figure instanceof Ellipse) {
     * g2d.drawRect(20 - xy, figure.getY() - xy, figure.getW() + wh, figure.getH() +
     * wh);
     * } else {
     * g2d.drawRect(figure.getX() - xy, figure.getY() - xy, figure.getW() + wh,
     * figure.getH() + wh);
     * }
     * 
     * if (focused) {
     * g2d.setColor(Color.GRAY);
     * } else {
     * g2d.setColor(Color.LIGHT_GRAY);
     * }
     * 
     * if (figure instanceof Ellipse) {
     * g2d.fillRect(20 - xy, figure.getY() - xy, figure.getW() + wh, figure.getH() +
     * wh);
     * } else {
     * g2d.fillRect(figure.getX() - xy, figure.getY() - xy, figure.getW() + wh,
     * figure.getH() + wh);
     * }
     * if(this.idx >= 0 && this.idx <= 4) {
     * this.figure.paint(g, false);
     * } else if (this.idx == 5) {
     * 
     * } else if (this.idx == 6) {
     * 
     * }
     * 
     * }
     */

    g2d.setStroke(new BasicStroke(3));
    g2d.setColor(Color.black);
    g2d.drawRect(x - 1, y - 1, w + 1, h + 1);
    if (focused) {
      g2d.setColor(Color.GRAY);
    } else {
      g2d.setColor(Color.LIGHT_GRAY);
    }
    g2d.fillRect(x, y, w, h);

    switch (this.idx) {
      case 0:
        g2d.setColor(Color.black);
        g2d.drawRect(x + w / 4, y + h / 4, w / 2 + 1, h / 2 + 1);
        g2d.setColor(Color.black);
        g2d.fillRect(x + w / 4 + 1, y + h / 4 + 1, w / 2, h / 2);
        break;
      case 1:
        g2d.setColor(Color.black);
        g2d.drawOval(x + w / 4, y + h / 4, w / 2, h / 2);
        g2d.setColor(Color.black);
        g2d.fillOval(x + w / 4 + 1, y + h / 4 + 1, w / 2, h / 2);
        break;
      case 2:
        g2d.setColor(Color.black);
        Polygon triangle = new Polygon();
        triangle.addPoint(x + 15, y + 35);
        triangle.addPoint(x + w / 2, y + 15);
        triangle.addPoint(x + 35, y + 35);
        g2d.drawPolygon(triangle);
        g2d.setColor(Color.black);
        g2d.fillPolygon(triangle);
        break;
      case 3:
        g2d.setColor(Color.black);
        Polygon pentagon = new Polygon();
        pentagon.addPoint(x + w / 2, y + 10);
        pentagon.addPoint(x + w - 10, (int) (y + h * 0.4) + 2);
        pentagon.addPoint((int) (x + w * 0.75) - 5, y + h / 2 + 15);
        pentagon.addPoint((int) (x + w * 0.25) + 5, y + h / 2 + 15);
        pentagon.addPoint(x + 10, (int) (y + h * 0.4) + 2);
        g2d.drawPolygon(pentagon);
        g2d.setColor(Color.black);
        g2d.fillPolygon(pentagon);
        break;
      case 4:
        g2d.setColor(Color.black);
        g2d.draw(new Ellipse2D.Double(this.x + 17, this.y + 12, this.w / 4 + 5, this.h / 2 + 5));
        g2d.setColor(Color.black);
        g2d.fillOval(this.x + 17, this.y + 12, this.w / 4 + 5, this.h / 2 + 5);
        break;
      case 5:
        g2d.setColor(Color.black);
        try {
          colors = ImageIO.read(getClass().getResourceAsStream("colors.png"));
        } catch (IOException e) {
          System.out.println("Error: Image was not found!");
        }
        g2d.drawImage(colors, this.x, this.y, 50, 50, null);
        break;
      case 6:
        g2d.setColor(Color.black);
        try {
          trash = ImageIO.read(getClass().getResourceAsStream("trash.png"));
        } catch (IOException e) {
          System.out.println("Error: Image was not found!");
        }
        g2d.drawImage(trash, this.x, this.y, 50, 50, null);
        break;
    }
  }
}
