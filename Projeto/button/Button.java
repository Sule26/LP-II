package button;
import ivisible.IVisible;
import java.awt.Graphics;
import figures.Figure;


public class Button implements IVisible {
  public int idx;
  private Figure figure;

  public Button(int idx, Figure figure) {
    this.idx = idx;
    setFigure(figure);
  }

  public void setFigure(Figure figure) {
    this.figure = figure;
  }
  
  public boolean clicked(int x, int y) {
    return true;
  }

  public void paint(Graphics g, boolean focused) {
    
  }
}
