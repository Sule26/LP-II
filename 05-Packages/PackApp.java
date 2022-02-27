import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1, r2;
    Ellipse e1, e2;
    Circle c1, c2;

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30);
        this.r2 = new Rect(200, 50, 60, 60);
        this.e1 = new Ellipse(50, 100, 100,30);
        this.e2 = new Ellipse(200, 150, 80, 40);
        this.c1 = new Circle(50, 150, 50);
        this.c2 = new Circle(200, 200, 100);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g, Color.cyan, Color.black);
        this.r2.paint(g, Color.green, Color.red);

        this.e1.paint(g, Color.cyan, Color.DARK_GRAY);
        this.e2.paint(g, Color.yellow, Color.red);

        this.c1.paint(g, Color.MAGENTA, Color.pink);
        this.c2.paint(g, Color.ORANGE, Color.yellow);
    }
}
