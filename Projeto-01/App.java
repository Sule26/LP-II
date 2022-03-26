import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
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
                        int x = rand.nextInt(650);
                        int y = rand.nextInt(650);
                        int w = 50;
                        int h = 50;
                        if (e.getKeyChar() == 'r' || e.getKeyChar() == 'R') {
                            FigureList.add(new Rect(x, y, w, h, color[0]));
                        } else if (e.getKeyChar() == 'e' || e.getKeyChar() == 'E') {
                            FigureList.add(new Ellipse(x, y, w / 2, h, color[1]));
                        } else if (e.getKeyChar() == 'c' || e.getKeyChar() == 'C') {
                            FigureList.add(new Circle(x, y, w, color[2]));
                        } else if (e.getKeyChar() == 't' || e.getKeyChar() == 'T') {
                            FigureList.add(new Triangle(x, y, w, h, color[3]));
                        } else if (e.getKeyChar() == 'p' || e.getKeyChar() == 'P') {
                            FigureList.add(new Pentagon(x, y, w, h, color[4]));
                        } else if (e.getKeyCode() == 9) {
                            // ADD
                        } else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                            if (focus != null) {
                                FigureList.remove(focus);
                            }
                        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                            if (focus != null) {
                                focus.y -= 10;
                            }
                        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                            if (focus != null) {
                                focus.y += 10;
                            }
                        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                            if (focus != null) {
                                focus.x -= 10;
                            }
                        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                            if (focus != null) {
                                focus.x += 10;
                            }
                        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD0) {
                            if (focus != null) {
                                focus.background = color[0];
                            }
                        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
                            if (focus != null) {
                                focus.background = color[1];
                            }
                        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
                            if (focus != null) {
                                focus.background = color[2];
                            }
                        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
                            if (focus != null) {
                                focus.background = color[3];
                            }
                        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
                            if (focus != null) {
                                focus.background = color[4];
                            }
                        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD5) {
                            if (focus != null) {
                                focus.background = color[5];
                            }
                        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD6) {
                            if (focus != null) {
                                focus.background = color[6];
                            }
                        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD7) {
                            if (focus != null) {
                                focus.background = color[7];
                            }
                        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD8) {
                            if (focus != null) {
                                focus.background = color[8];
                            }
                        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD9) {
                            if (focus != null) {
                                focus.background = color[9];
                            }
                        } else if (e.getKeyCode() == KeyEvent.VK_ADD) {
                            if (focus != null && focus.w <= 100) {
                                focus.w += 10;
                                focus.h += 10;
                            }
                        } else if (e.getKeyCode() == KeyEvent.VK_SUBTRACT) {
                            if (focus != null && focus.w >= 20) {
                                focus.w -= 10;
                                focus.h -= 10;
                            }
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
