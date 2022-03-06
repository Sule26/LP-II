import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Rect> RectList = new ArrayList<Rect>();
    ArrayList<Ellipse> EllipseList = new ArrayList<Ellipse>();
    ArrayList<Circle> CircleList = new ArrayList<Circle>();
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    int x = rand.nextInt(350);
                    int y = rand.nextInt(350);
                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
                    if (evt.getKeyChar() == 'r') {
                        Rect r = new Rect(x, y, w, h);
                        RectList.add(r);
                    } else if (evt.getKeyChar() == 'e') {
                        Ellipse e = new Ellipse(x, y, w, h);
                        EllipseList.add(e);
                    } else if (evt.getKeyChar() == 'c') {
                        Circle c = new Circle(x, y, w);
                        CircleList.add(c);
                    }
                    repaint();
                }
            }
        );

        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Circle fig: this.CircleList) {
            fig.paint(g, Color.black, Color.red);
        }
        for (Rect fig: this.RectList) {
            fig.paint(g, Color.blue, Color.green);
        }
        for (Ellipse fig: this.EllipseList) {
            fig.paint(g, Color.orange, Color.YELLOW);
        }
    }
}
