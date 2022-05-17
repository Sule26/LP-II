import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;
import buttons.*;
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
    ArrayList<ButtonFigures> ButtonFiguresList = new ArrayList<ButtonFigures>();
    ArrayList<ButtonColors> ButtonColorsList = new ArrayList<ButtonColors>();
    Figure focus_figure = null;
    ButtonFigures focus_buttonFigure = null;
    ButtonColors focus_buttonColors = null;
    Point pMouse;
    int dx, dy;

    Color color[] = { new Color(255, 0, 0), new Color(255, 128, 0), new Color(255, 255, 0), new Color(0, 255, 0),
            new Color(0, 255, 255), new Color(0, 0, 255), new Color(127, 0, 255), new Color(255, 0, 255),
            new Color(255, 0, 127), new Color(128, 128, 128) };

    Color colorFocus[] = { new Color(153, 0, 0), new Color(153, 76, 0), new Color(153, 153, 0), new Color(0, 153, 0),
            new Color(0, 153, 153), new Color(0, 0, 153), new Color(76, 0, 153), new Color(153, 0, 153),
            new Color(153, 0, 76), new Color(64, 64, 64) };

    ListFrame() {
        try {
            FileInputStream f = new FileInputStream("proj.bin");
            ObjectInputStream o = new ObjectInputStream(f);
            this.FigureList = (ArrayList<Figure>) o.readObject();
            o.close();
        } catch (Exception x) {
        }

        ButtonFiguresList.add(new ButtonFigures(0, new Rect(20, 40, 35, 35, Color.black, Color.black, 10)));
        ButtonFiguresList.add(new ButtonFigures(1, new Ellipse(30, 90, 35, 35, Color.black, Color.black, 10)));
        ButtonFiguresList.add(new ButtonFigures(2, new Pentagon(20, 140, 35, 35, Color.black, Color.black, 10)));
        ButtonFiguresList.add(new ButtonFigures(3, new Triangle(20, 190, 35, 35, Color.black, Color.black, 10)));
        ButtonFiguresList.add(new ButtonFigures(4, new Circle(20, 240, 35, Color.black, Color.black, 10)));

        ButtonColorsList.add(new ButtonColors(0, new Rect(20, 670, 15, 15, color[0], Color.black, 10)));
        ButtonColorsList.add(new ButtonColors(1, new Rect(53, 670, 15, 15, color[1], Color.black, 10)));
        ButtonColorsList.add(new ButtonColors(2, new Rect(86, 670, 15, 15, color[2], Color.black, 10)));
        ButtonColorsList.add(new ButtonColors(3, new Rect(119, 670, 15, 15, color[3], Color.black, 10)));
        ButtonColorsList.add(new ButtonColors(4, new Rect(152, 670, 15, 15, color[4], Color.black, 10)));
        ButtonColorsList.add(new ButtonColors(5, new Rect(185, 670, 15, 15, color[5], Color.black, 10)));
        ButtonColorsList.add(new ButtonColors(6, new Rect(218, 670, 15, 15, color[6], Color.black, 10)));
        ButtonColorsList.add(new ButtonColors(7, new Rect(251, 670, 15, 15, color[7], Color.black, 10)));
        ButtonColorsList.add(new ButtonColors(8, new Rect(284, 670, 15, 15, color[8], Color.black, 10)));
        ButtonColorsList.add(new ButtonColors(9, new Rect(317, 670, 15, 15, color[9], Color.black, 10)));

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
                        if (20 <= pMouse.x && pMouse.x <= 20 + 35 && 40 <= pMouse.y && pMouse.y <= 40 + 275) {
                            focus_buttonFigure = null;
                            focus_buttonColors = null;
                            focus_figure = null;
                            for (ButtonFigures btn : ButtonFiguresList) {
                                if (btn.clicked(pMouse.x, pMouse.y)) {
                                    focus_buttonFigure = btn;
                                }
                            }
                        } else if (20 <= pMouse.x && pMouse.x <= 20 + 332 && 670 <= pMouse.y && pMouse.y <= 670 + 15) {
                            focus_buttonColors = null;
                            focus_buttonFigure = null;
                            focus_figure = null;
                            for (ButtonColors btn : ButtonColorsList) {
                                if (btn.clicked(pMouse.x, pMouse.y)) {
                                    focus_buttonColors = btn;
                                }
                            }
                        } else if (focus_buttonColors != null) {
                            focus_figure = null;
                            for (Figure fig : FigureList) {
                                if (fig.clicked(pMouse.x, pMouse.y)) {
                                    fig.setBackgroundColor(focus_buttonColors.getFigureColor());
                                    focus_figure = fig;
                                }
                            }
                            focus_buttonColors = null;
                            if (focus_figure != null) {
                                FigureList.remove(focus_figure);
                                FigureList.add(focus_figure);
                            }
                        } else if (focus_buttonFigure != null) { // Verifica se tem algo em focus_buttonFigure
                            focus_buttonColors = null;
                            int idx = focus_buttonFigure.idx;
                            int x = pMouse.x;
                            int y = pMouse.y;
                            int w = 50;
                            int h = 50;
                            int opacity = 10;
                            switch (idx) {
                                case 0:
                                    FigureList.add(new Rect(x, y, w, h, color[0], color[9], opacity));
                                    focus_figure = FigureList.get(FigureList.size() - 1);
                                    break;
                                case 1:
                                    FigureList.add(new Ellipse(x, y, w, h, color[1], color[8], opacity));
                                    focus_figure = FigureList.get(FigureList.size() - 1);
                                    break;
                                case 2:
                                    FigureList.add(new Pentagon(x, y, w, h, color[4], color[5], opacity));
                                    focus_figure = FigureList.get(FigureList.size() - 1);
                                    break;
                                case 3:
                                    FigureList.add(new Triangle(x, y, w, h, color[3], color[6], opacity));
                                    focus_figure = FigureList.get(FigureList.size() - 1);
                                    break;
                                case 4:
                                    FigureList.add(new Circle(x, y, w, color[2], color[7], opacity));
                                    focus_figure = FigureList.get(FigureList.size() - 1);
                                    break;
                                default:
                                    break;
                            }
                            focus_buttonFigure = null;
                        } else {
                            focus_figure = null;
                            focus_buttonColors = null;
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
        for (ButtonFigures btnFigures : this.ButtonFiguresList) {
            btnFigures.paint(g, focus_buttonFigure == btnFigures);
        }

        for (ButtonColors btnColors : this.ButtonColorsList) {
            btnColors.paint(g, focus_buttonColors == btnColors);
        }

        for (Figure fig : this.FigureList) {
            fig.paint(g, focus_figure == fig);
        }

        if (focus_figure != null) {
            focus_figure.drawBorder(g);
        }
    }
}
