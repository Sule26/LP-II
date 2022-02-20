import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;



public class RectEllipseApp {
    public static void main (String[] args) {
        RectEllipseFrame frame = new RectEllipseFrame();
     }
} 

class RectEllipseFrame extends JFrame {
    Rect ret1, ret2, ret3;
    Ellipse eli1, eli2, eli3;

    public RectEllipseFrame() {
        this.addWindowListener(
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("2.2.1 - 2.2.2");
        this.setSize(800, 600);
        this.setVisible(true);
        
        this.ret1 = new Rect(50, 50, 100, 30);
        this.ret2 = new Rect(50, 90, 80, 30);
        this.ret3 = new Rect(50, 130, 50, 20);
        this.eli1 = new Ellipse(50, 200, 100, 30);
        this.eli2 = new Ellipse(50, 300, 90, 80);
        this.eli3 = new Ellipse(50, 400, 120, 50);
    }

    public void paint(Graphics g) {
        super.paint(g);
        
        this.ret1.paint(g, Color.cyan, Color.black);
        this.ret2.paint(g, Color.yellow, Color.red);
        this.ret3.paint(g, Color.green, Color.white);
        
        this.eli1.paint(g, Color.cyan, Color.DARK_GRAY);
        this.eli2.paint(g, Color.yellow, Color.red);
        this.eli3.paint(g, Color.green, Color.lightGray);
    }
}

class Rect {
     int x, y;
     int w, h;
     Rect (int x, int y, int w, int h) {
         this.x = x;
         this.y = y;
         this.w = w;
         this.h = h;
     }

     void print () {
       System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this.w, this.h, this.x, this.y);
       }

    void paint (Graphics g, Color drawColor, Color fillColor) {
        g.setColor(drawColor);
        g.drawRect(this.x, this.y, this.w, this.h);
        g.setColor(fillColor);
        g.fillRect(this.x, this.y, this.w, this.h);
    }
}


class Ellipse {
    int x, y;
    int w, h;
    Ellipse (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print(){
        System.out.format ("Elipse de tamanho (%d,%d) na posição (%d,%d).\n", this.w,this.h, this.x, this.y);
    }
    
    
    void paint(Graphics g, Color drawColor, Color fillColor) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(drawColor);
        g2d.draw(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
        g2d.setColor(fillColor);
        g2d.fillOval(this.x, this.y, this.w, this.h);
    }
}
