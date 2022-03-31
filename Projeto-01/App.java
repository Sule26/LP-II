import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class App {
    public static void main(String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> FigureList = new ArrayList<Figure>();
    Random rand = new Random();
    Figure focus = null;
    Point pMouse;
    int dx, dy;

    Color color[] = { Color.BLUE, Color.GREEN, Color.DARK_GRAY, Color.MAGENTA, Color.BLACK, Color.YELLOW, Color.CYAN,
            Color.GRAY, Color.PINK, Color.ORANGE };

    ListFrame() {
        this.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });

        this.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        pMouse = getMousePosition();
                        setFocusTraversalKeysEnabled(false);
                        int x = pMouse.x;
                        int y = pMouse.y;
                        int w = 50;
                        int h = 50;
                        int opacity = 10;
                        switch (e.getKeyCode()) {
                            case 82: // R
                                FigureList.add(new Rect(x, y, w, h, color[0], color[9], opacity));
                                break;
                            case 69: // E
                                FigureList.add(new Ellipse(x, y, w, h, color[1], color[8], opacity));
                                break;
                            case 67: // C
                                FigureList.add(new Circle(x, y, w, color[2], color[7], opacity));
                                break;
                            case 84: // T
                                FigureList.add(new Triangle(x, y, w, h, color[3], color[6], opacity));
                                break;
                            case 80: // P
                                FigureList.add(new Pentagon(x, y, w, h, color[4], color[5], opacity));
                                break;
                            case KeyEvent.VK_TAB:
                                for (Figure fig : FigureList) {
                                    focus = fig;
                                    FigureList.remove(focus);
                                    FigureList.add(focus);
                                    break;
                                }
                                break;
                            case KeyEvent.VK_DELETE:
                                if (focus != null) {
                                    FigureList.remove(focus);
                                    focus = null;
                                }
                                break;
                            case KeyEvent.VK_UP:
                                if (focus != null && focus.y > 40) {
                                    focus.y -= 10;
                                }
                                break;
                            case KeyEvent.VK_DOWN:
                                if (focus != null && (focus.y + focus.h) < 685) {
                                    focus.y += 10;
                                }
                                break;
                            case KeyEvent.VK_LEFT:
                                if (focus != null && focus.x > 10) {
                                    focus.x -= 10;
                                }
                                break;
                            case KeyEvent.VK_RIGHT:
                                if (focus != null && (focus.x + focus.w) < 685) {
                                    focus.x += 10;
                                }
                                break;
                            case KeyEvent.VK_NUMPAD0:
                                if (focus != null) {
                                    focus.background = color[0];
                                }
                                break;
                            case KeyEvent.VK_NUMPAD1:
                                if (focus != null) {
                                    focus.background = color[1];
                                }
                                break;
                            case KeyEvent.VK_NUMPAD2:
                                if (focus != null) {
                                    focus.background = color[2];
                                }
                                break;
                            case KeyEvent.VK_NUMPAD3:
                                if (focus != null) {
                                    focus.background = color[3];
                                }
                                break;
                            case KeyEvent.VK_NUMPAD4:
                                if (focus != null) {
                                    focus.background = color[4];
                                }
                                break;
                            case KeyEvent.VK_NUMPAD5:
                                if (focus != null) {
                                    focus.background = color[5];
                                }
                                break;
                            case KeyEvent.VK_NUMPAD6:
                                if (focus != null) {
                                    focus.background = color[6];
                                }
                                break;
                            case KeyEvent.VK_NUMPAD7:
                                if (focus != null) {
                                    focus.background = color[7];
                                }
                                break;
                            case KeyEvent.VK_NUMPAD8:
                                if (focus != null) {
                                    focus.background = color[8];
                                }
                                break;
                            case KeyEvent.VK_NUMPAD9:
                                if (focus != null) {
                                    focus.background = color[9];
                                }
                                break;
                            case KeyEvent.VK_0:
                                if (focus != null) {
                                    focus.outline = color[0];
                                }
                                break;
                            case KeyEvent.VK_1:
                                if (focus != null) {
                                    focus.outline = color[1];
                                }
                                break;
                            case KeyEvent.VK_2:
                                if (focus != null) {
                                    focus.outline = color[2];
                                }
                                break;
                            case KeyEvent.VK_3:
                                if (focus != null) {
                                    focus.outline = color[3];
                                }
                                break;
                            case KeyEvent.VK_4:
                                if (focus != null) {
                                    focus.outline = color[4];
                                }
                                break;
                            case KeyEvent.VK_5:
                                if (focus != null) {
                                    focus.outline = color[5];
                                }
                                break;
                            case KeyEvent.VK_6:
                                if (focus != null) {
                                    focus.outline = color[6];
                                }
                                break;
                            case KeyEvent.VK_7:
                                if (focus != null) {
                                    focus.outline = color[7];
                                }
                                break;
                            case KeyEvent.VK_8:
                                if (focus != null) {
                                    focus.outline = color[8];
                                }
                                break;
                            case KeyEvent.VK_9:
                                if (focus != null) {
                                    focus.outline = color[9];
                                }
                                break;
                            case KeyEvent.VK_ADD:
                                if (focus != null && focus.w <= 100) {
                                    focus.w += 10;
                                    focus.h += 10;
                                }
                                break;
                            case KeyEvent.VK_SUBTRACT:
                                if (focus != null && focus.w >= 20) {
                                    focus.w -= 10;
                                    focus.h -= 10;
                                }
                                break;
                            case 72: // H
                                if (focus != null && focus.opacity > 1) {
                                    focus.opacity -= 1;
                                }
                                break;
                            case 74: // J
                                if (focus != null && focus.opacity < 10) {
                                    focus.opacity += 1;
                                }
                                break;
                        }
                        repaint();
                    }
                });

        this.addMouseListener(
                new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        pMouse = getMousePosition();
                        focus = null;
                        for (Figure fig : FigureList) {
                            if ((fig.x <= pMouse.x) && (fig.y <= pMouse.y) && (pMouse.x <= (fig.x + fig.w))
                                    && (pMouse.y <= (fig.y + fig.h))) {
                                focus = fig;
                                dx = focus.x - pMouse.x;
                                dy = focus.y - pMouse.y;
                            }
                        }
                        if (focus != null) {
                            FigureList.remove(focus);
                            FigureList.add(focus);
                        }
                        repaint();
                    }
                });

        this.addMouseMotionListener(
                new MouseMotionAdapter() {
                    public void mouseDragged(MouseEvent e) {
                        pMouse = getMousePosition();
                        if (focus != null) {
                            FigureList.remove(focus);
                            FigureList.add(focus);
                            focus.x = pMouse.x + dx;
                            focus.y = pMouse.y + dy;
                        }
                        repaint();
                    }
                });

        this.setTitle("Projeto 01");
        this.setSize(700, 700);
    }

    public void paint(Graphics g) {
        super.paintComponents(g);
        for (Figure fig : this.FigureList) {
            fig.paint(g);
        }

        if (focus != null) {
            focus.border(g);
        }
    }
}
