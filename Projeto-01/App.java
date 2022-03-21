import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class App {
    public static void main(String[] args) {
        ListFrame frame = new ListFrame();
        Figure focus = null;
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> FigureList = new ArrayList<Figure>();
    Random rand = new Random();

    ListFrame() {
        this.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });

        this.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent evt) {
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
                        if (evt.getKeyChar() == 'r') {
                            FigureList.add(new Rect(x, y, w, h));
                        } else if (evt.getKeyChar() == 'e') {
                            FigureList.add(new Ellipse(x, y, w, h));
                        } else if (evt.getKeyChar() == 'c') {
                            FigureList.add(new Circle(x, y, w));
                        } else if (evt.getKeyChar() == 'l') {
                            FigureList.add(new Line(x, y, x + 50, y + 50));
                        } else if (evt.getKeyChar() == KeyEvent.VK_TAB) {

                        }
                        repaint();
                    }
                });

        this.addMouseListener(
            new MouseAdapter(){
                public void mousePressed (MouseEvent evt) {
                    Figure focused = null;
                    float mx = evt.getX();
                    float my = evt.getY();
                    for (Figure fig: FigureList) {
                        if(mx > fig.x && mx < fig.x + fig.w && my > fig.y && my < fig.y + fig.h) {
                            focused = fig;
                            JFrame.getFrames();
                        }
                    }
                    FigureList.remove(focused);
                    FigureList.add(focused);
                }
            });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged (MouseEvent evt) {

            }
        });



        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (Figure fig : this.FigureList) {
            fig.paint(g);
        }
    }
}
