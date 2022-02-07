import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main(String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame() {
        this.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
        this.setTitle("1.2.1 - Modificando o exemplo");
        this.setSize(800, 600);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.black);

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.red);
        int w = getWidth();
        int h = getHeight();
        g2d.drawLine(0, 0, w, h);
        g2d.drawLine(0, h, w, 0);
        g2d.drawOval(350, 400, 150, 150);
        g2d.drawRect(50, 250, 150, 150);
        g2d.drawString("Hello, World!", 375, 50);
    }
}
