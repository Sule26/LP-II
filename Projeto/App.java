import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import javax.swing.*;
import buttons.Button;
import java.util.ArrayList;

import figures.*;

class App {
    public static void main(String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> FigureList = new ArrayList<Figure>();
    ArrayList<Button> ButtonList = new ArrayList<Button>();
    Figure focus_figure = null;
    Button focus_button = null;
    Point pMouse;
    int dx, dy;

    Color color[] = { Color.BLUE, Color.GREEN, Color.DARK_GRAY, Color.MAGENTA, Color.BLACK, Color.YELLOW, Color.CYAN,
            Color.GRAY, Color.PINK, Color.ORANGE };

    ListFrame() {
        try {
            FileInputStream f = new FileInputStream("proj.bin");
            ObjectInputStream o = new ObjectInputStream(f);
            this.FigureList = (ArrayList<Figure>) o.readObject();
            o.close();
        } catch (Exception x) {
        }

        ButtonList.add(new Button(0, new Rect(20, 40, 35, 35, color[4], color[4], 10)));
        ButtonList.add(new Button(1, new Ellipse(30, 90, 35, 35, color[4], color[4], 10)));
        ButtonList.add(new Button(2, new Pentagon(20, 140, 35, 35, color[4], color[4], 10)));
        ButtonList.add(new Button(3, new Triangle(20, 190, 35, 35, color[4], color[4], 10)));
        ButtonList.add(new Button(4, new Circle(20, 240, 35, color[4], color[4], 10)));

        this.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        try {
                            FileOutputStream f = new FileOutputStream("proj.bin");
                            ObjectOutputStream o = new ObjectOutputStream(f);
                            o.writeObject(FigureList);
                            o.flush();
                            o.close();
                        } catch (Exception x) {
                        }
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
                                    focus_figure = fig;
                                    FigureList.remove(focus_figure);
                                    FigureList.add(focus_figure);
                                    break;
                                }
                                break;
                            case KeyEvent.VK_DELETE:
                                if (focus_figure != null) {
                                    FigureList.remove(focus_figure);
                                    focus_figure = null;
                                }
                                break;
                            case KeyEvent.VK_UP:
                                if (focus_figure != null) {
                                    focus_figure.changePositionArrowKeys(1);
                                }
                                break;
                            case KeyEvent.VK_DOWN:
                                if (focus_figure != null) {
                                    focus_figure.changePositionArrowKeys(3);
                                }
                                break;
                            case KeyEvent.VK_LEFT:
                                if (focus_figure != null) {
                                    focus_figure.changePositionArrowKeys(4);
                                }
                                break;
                            case KeyEvent.VK_RIGHT:
                                if (focus_figure != null) {
                                    focus_figure.changePositionArrowKeys(2);
                                }
                                break;
                            case KeyEvent.VK_NUMPAD0:
                                if (focus_figure != null) {
                                    focus_figure.changeBackgroundColor(color[0]);
                                }
                                break;
                            case KeyEvent.VK_NUMPAD1:
                                if (focus_figure != null) {
                                    focus_figure.changeBackgroundColor(color[1]);
                                }
                                break;
                            case KeyEvent.VK_NUMPAD2:
                                if (focus_figure != null) {
                                    focus_figure.changeBackgroundColor(color[2]);
                                }
                                break;
                            case KeyEvent.VK_NUMPAD3:
                                if (focus_figure != null) {
                                    focus_figure.changeBackgroundColor(color[3]);
                                }
                                break;
                            case KeyEvent.VK_NUMPAD4:
                                if (focus_figure != null) {
                                    focus_figure.changeBackgroundColor(color[4]);
                                }
                                break;
                            case KeyEvent.VK_NUMPAD5:
                                if (focus_figure != null) {
                                    focus_figure.changeBackgroundColor(color[5]);
                                }
                                break;
                            case KeyEvent.VK_NUMPAD6:
                                if (focus_figure != null) {
                                    focus_figure.changeBackgroundColor(color[6]);
                                }
                                break;
                            case KeyEvent.VK_NUMPAD7:
                                if (focus_figure != null) {
                                    focus_figure.changeBackgroundColor(color[7]);
                                }
                                break;
                            case KeyEvent.VK_NUMPAD8:
                                if (focus_figure != null) {
                                    focus_figure.changeBackgroundColor(color[8]);
                                }
                                break;
                            case KeyEvent.VK_NUMPAD9:
                                if (focus_figure != null) {
                                    focus_figure.changeBackgroundColor(color[9]);
                                }
                                break;
                            case KeyEvent.VK_0:
                                if (focus_figure != null) {
                                    focus_figure.changeOutlineColor(color[0]);
                                }
                                break;
                            case KeyEvent.VK_1:
                                if (focus_figure != null) {
                                    focus_figure.changeOutlineColor(color[1]);
                                }
                                break;
                            case KeyEvent.VK_2:
                                if (focus_figure != null) {
                                    focus_figure.changeOutlineColor(color[2]);
                                }
                                break;
                            case KeyEvent.VK_3:
                                if (focus_figure != null) {
                                    focus_figure.changeOutlineColor(color[3]);
                                }
                                break;
                            case KeyEvent.VK_4:
                                if (focus_figure != null) {
                                    focus_figure.changeOutlineColor(color[4]);
                                }
                                break;
                            case KeyEvent.VK_5:
                                if (focus_figure != null) {
                                    focus_figure.changeOutlineColor(color[5]);
                                }
                                break;
                            case KeyEvent.VK_6:
                                if (focus_figure != null) {
                                    focus_figure.changeOutlineColor(color[6]);
                                }
                                break;
                            case KeyEvent.VK_7:
                                if (focus_figure != null) {
                                    focus_figure.changeOutlineColor(color[7]);
                                }
                                break;
                            case KeyEvent.VK_8:
                                if (focus_figure != null) {
                                    focus_figure.changeOutlineColor(color[8]);
                                }
                                break;
                            case KeyEvent.VK_9:
                                if (focus_figure != null) {
                                    focus_figure.changeOutlineColor(color[9]);
                                }
                                break;
                            case KeyEvent.VK_ADD:
                                focus_figure.increaseSize();
                                break;
                            case KeyEvent.VK_SUBTRACT:
                                focus_figure.dicreaseSize();
                                break;
                            case 72: // H
                                focus_figure.dicreaseOpacity();
                                break;
                            case 74: // J
                                focus_figure.increaseOpacity();
                                break;
                        }
                        repaint();
                    }
                });

        this.addMouseListener(
                new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        pMouse = getMousePosition();
                        if (20 <= pMouse.x && pMouse.x <= 20 + 35 && 40 <= pMouse.y && pMouse.y <= 40 + 275) { // Verifica se está dentro de alguma figura
                            focus_button = null;
                            for (Button btn : ButtonList) {
                                if (btn.clicked(pMouse.x, pMouse.y)) {
                                    focus_button = btn;
                                }
                            }
                        } else if (focus_button != null) { // Verifica se tem algo em focus_button
                            int idx = focus_button.idx;
                            int x = pMouse.x;
                            int y = pMouse.y;
                            int w = 50;
                            int h = 50;
                            int opacity = 10;
                            switch (idx) {
                                case 0: // R
                                    FigureList.add(new Rect(x, y, w, h, color[0], color[9], opacity));
                                    break;
                                case 1: 
                                    FigureList.add(new Ellipse(x, y, w, h, color[1], color[8], opacity));
                                    break;
                                case 2:
                                    FigureList.add(new Pentagon(x, y, w, h, color[4], color[5], opacity));
                                    break;
                                case 3:
                                    FigureList.add(new Triangle(x, y, w, h, color[3], color[6], opacity));
                                    break;
                                case 4:
                                    FigureList.add(new Circle(x, y, w, color[2], color[7], opacity));                                
                                    break;
                                default:
                                    break;
                            }
                            focus_button = null;
                        } else {
                            focus_figure = null;
                            for (Figure fig : FigureList) {
                                if (fig.clicked(pMouse.x, pMouse.y)) {
                                    focus_figure = fig;
                                    dx = focus_figure.getX() - pMouse.x;
                                    dy = focus_figure.getX() - pMouse.y;
                                }
                            }
                            if (focus_figure != null) {
                                FigureList.remove(focus_figure);
                                FigureList.add(focus_figure);
                            }
                        }
                        repaint();
                    }
                });

        this.addMouseMotionListener(
                new MouseMotionAdapter() {
                    public void mouseDragged(MouseEvent e) {
                        pMouse = getMousePosition();
                        if (focus_figure != null) {
                            FigureList.remove(focus_figure);
                            FigureList.add(focus_figure);
                            focus_figure.drag(dx, dy, pMouse.x, pMouse.y);
                        }
                        repaint();
                    }
                });

        this.setTitle("Projeto 01");
        this.setSize(700, 700);
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (Button btn : this.ButtonList) {
            btn.paint(g, focus_button == btn);
        }

        for (Figure fig : this.FigureList) {
            fig.paint(g, true);
        }

        if (focus_figure != null) {
            focus_figure.drawBorder(g);
        }
    }
}
