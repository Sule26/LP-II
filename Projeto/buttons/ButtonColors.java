package buttons;

import ivisible.IVisible;
import java.awt.*;

import figures.*;

public class ButtonColors implements IVisible {
  public int idx;
  private Figure figure;
  private int xy = 7;
  private int wh = 14;

  public ButtonColors(int idx, Figure figure) {
    this.idx = idx;
    setFigure(figure);
  }

  public void setFigure(Figure figure) {
    this.figure = figure;
  }

  public Color getFigureColor() {
    return this.figure.getBackgroundColor();
  }

  public boolean clicked(int x, int y) {
    return (figure.getX() - xy <= x && x <= (figure.getX() - xy) + (figure.getW() + wh) && figure.getY() - 5 <= y
    && y <= (figure.getY() - xy) + (figure.getH() + wh));
  }

  public void paint(Graphics g, boolean focused) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setStroke(new BasicStroke(3));
    g2d.setColor(Color.black);
    g2d.drawRect(figure.getX() - xy, figure.getY() - xy, figure.getW() + wh, figure.getH() + wh);
    if (focused) {
      g2d.setColor(Color.gray);
    } else {
      g2d.setColor(Color.LIGHT_GRAY);
    }
    g2d.fillRect(figure.getX() - xy, figure.getY() - xy, figure.getW() + wh, figure.getH() + wh);
    this.figure.paint(g, false);
  }
}
