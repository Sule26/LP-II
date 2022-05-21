package panels;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import buttons.*;
import java.util.ArrayList;
import figures.*;

public class ListPanel extends JPanel {
    static ArrayList<Figure> FigureList = new ArrayList<Figure>();
    ArrayList<ButtonFigures> ButtonFiguresList = new ArrayList<ButtonFigures>();
    ArrayList<ButtonColors> ButtonColorsList = new ArrayList<ButtonColors>();
    Figure focus_figure = null;
    ButtonFigures focus_buttonFigure = null;
    ButtonColors focus_buttonColors = null;
    Point pMouse;
    int mouseX, mouseY;
    String options[] = { "Background", "Outline", "Both" };
    Color rgb;
    Rect auxButton = new Rect(0, 0, 10, 10, Color.red, Color.black, 10);
    boolean resizeButton = false;

    Color color[] = { new Color(255, 0, 0), new Color(255, 128, 0), new Color(255, 255, 0), new Color(0, 255, 0),
            new Color(0, 255, 255), new Color(0, 0, 255), new Color(127, 0, 255), new Color(255, 0, 255),
            new Color(255, 0, 127), new Color(128, 128, 128) };

    public ListPanel() {

        ButtonFiguresList.add(new ButtonFigures(0, 20, 50, 50, 50));
        ButtonFiguresList.add(new ButtonFigures(1, 20, 100, 50, 50));
        ButtonFiguresList.add(new ButtonFigures(2, 20, 150, 50, 50));
        ButtonFiguresList.add(new ButtonFigures(3, 20, 200, 50, 50));
        ButtonFiguresList.add(new ButtonFigures(4, 20, 250, 50, 50));
        ButtonFiguresList.add(new ButtonFigures(5, 20, 300, 50, 50));
        ButtonFiguresList.add(new ButtonFigures(6, 20, 350, 50, 50));

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

        repaint();

        this.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        pMouse = getMousePosition();
                        int x = pMouse.x;
                        int y = pMouse.y;
                        int w = 50;
                        int h = 50;
                        int opacity = 10;
                        if (e.isControlDown()) {
                            switch (e.getKeyCode()) {
                                case KeyEvent.VK_DELETE:
                                    while (FigureList.size() != 0) {
                                        FigureList.remove(0);
                                        focus_figure = null;
                                    }
                                    break;
                                case 65: // A
                                    for (Figure fig : FigureList) {
                                        int random = (int) (Math.random() * 10);
                                        fig.changeBackgroundColor(color[random]);
                                    }
                                    break;
                                case 83: // S
                                    for (Figure fig : FigureList) {
                                        int random = (int) (Math.random() * 10);
                                        fig.changeOutlineColor(color[random]);
                                    }
                                    break;
                                case KeyEvent.VK_NUMPAD0:
                                    for (Figure fig : FigureList) {
                                        fig.changeBackgroundColor(color[0]);
                                    }
                                    break;
                                case KeyEvent.VK_NUMPAD1:
                                    for (Figure fig : FigureList) {
                                        fig.changeBackgroundColor(color[1]);
                                    }
                                    break;
                                case KeyEvent.VK_NUMPAD2:
                                    for (Figure fig : FigureList) {
                                        fig.changeBackgroundColor(color[2]);
                                    }
                                case KeyEvent.VK_NUMPAD3:
                                    for (Figure fig : FigureList) {
                                        fig.changeBackgroundColor(color[3]);
                                    }
                                    break;
                                case KeyEvent.VK_NUMPAD4:
                                    for (Figure fig : FigureList) {
                                        fig.changeBackgroundColor(color[4]);
                                    }
                                    break;
                                case KeyEvent.VK_NUMPAD5:
                                    for (Figure fig : FigureList) {
                                        fig.changeBackgroundColor(color[5]);
                                    }
                                    break;
                                case KeyEvent.VK_NUMPAD6:
                                    for (Figure fig : FigureList) {
                                        fig.changeBackgroundColor(color[6]);
                                    }
                                    break;
                                case KeyEvent.VK_NUMPAD7:
                                    for (Figure fig : FigureList) {
                                        fig.changeBackgroundColor(color[7]);
                                    }
                                    break;
                                case KeyEvent.VK_NUMPAD8:
                                    for (Figure fig : FigureList) {
                                        fig.changeBackgroundColor(color[8]);
                                    }
                                    break;
                                case KeyEvent.VK_NUMPAD9:
                                    for (Figure fig : FigureList) {
                                        fig.changeBackgroundColor(color[9]);
                                    }
                                    break;
                                case KeyEvent.VK_0:
                                    for (Figure fig : FigureList) {
                                        fig.changeOutlineColor(color[0]);
                                    }
                                    break;
                                case KeyEvent.VK_1:
                                    for (Figure fig : FigureList) {
                                        fig.changeOutlineColor(color[1]);
                                    }
                                    break;
                                case KeyEvent.VK_2:
                                    for (Figure fig : FigureList) {
                                        fig.changeOutlineColor(color[2]);
                                    }
                                    break;
                                case KeyEvent.VK_3:
                                    for (Figure fig : FigureList) {
                                        fig.changeOutlineColor(color[3]);
                                    }
                                    break;
                                case KeyEvent.VK_4:
                                    for (Figure fig : FigureList) {
                                        fig.changeOutlineColor(color[4]);
                                    }
                                    break;
                                case KeyEvent.VK_5:
                                    for (Figure fig : FigureList) {
                                        fig.changeOutlineColor(color[5]);
                                    }
                                    break;
                                case KeyEvent.VK_6:
                                    for (Figure fig : FigureList) {
                                        fig.changeOutlineColor(color[6]);
                                    }
                                    break;
                                case KeyEvent.VK_7:
                                    for (Figure fig : FigureList) {
                                        fig.changeOutlineColor(color[7]);
                                    }
                                    break;
                                case KeyEvent.VK_8:
                                    for (Figure fig : FigureList) {
                                        fig.changeOutlineColor(color[8]);
                                    }
                                    break;
                                case KeyEvent.VK_9:
                                    for (Figure fig : FigureList) {
                                        fig.changeOutlineColor(color[9]);
                                    }
                                    break;
                            }
                        } else {
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
                                    focus_figure = FigureList.get(0);
                                    FigureList.remove(focus_figure);
                                    FigureList.add(focus_figure);
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
                        }
                        repaint();
                    }
                });

        this.addMouseListener(
                new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {

                        pMouse = getMousePosition();
                        mouseX = e.getX();
                        mouseY = e.getY();
                        // Verifica se o clique foi na área do botões de figuras
                        if (20 <= pMouse.x && pMouse.x <= 20 + 50 && 50 <= pMouse.y && pMouse.y <= 50 + 350) {
                            focus_buttonFigure = null;
                            focus_buttonColors = null;
                            focus_figure = null;
                            for (Figure fig : FigureList) {
                                if (fig.clicked(pMouse.x, pMouse.y)) {
                                    focus_figure = fig;
                                }
                            }
                            if(focus_figure == null) {
                                for (ButtonFigures btn : ButtonFiguresList) {
                                    if (btn.clicked(pMouse.x, pMouse.y)) {
                                        focus_buttonFigure = btn;
                                    }
                                }
                            }
                            repaint();
                            // Verifica se o clique foi na área dos botões das changePositionArrowKeys
                        } else if (20 <= pMouse.x && pMouse.x <= 20 + 332 && 670 <= pMouse.y && pMouse.y <= 670 + 15) {
                            focus_buttonColors = null;
                            focus_buttonFigure = null;
                            focus_figure = null;
                            for (Figure fig : FigureList) {
                                if (fig.clicked(pMouse.x, pMouse.y)) {
                                    focus_figure = fig;
                                }
                            }
                            if(focus_figure == null) {
                                for (ButtonColors btn : ButtonColorsList) {
                                    if (btn.clicked(pMouse.x, pMouse.y)) {
                                        focus_buttonColors = btn;
                                    }
                                }
                            }
                            repaint();
                        } else if (focus_buttonColors != null) {
                            focus_figure = null;
                            for (Figure fig : FigureList) {
                                if (fig.clicked(pMouse.x, pMouse.y)) {
                                    fig.changeBackgroundColor(focus_buttonColors.getFigureColor());
                                    focus_figure = fig;
                                }
                            }
                            focus_buttonColors = null;
                            if (focus_figure != null) {
                                FigureList.remove(focus_figure);
                                FigureList.add(focus_figure);
                            }
                            repaint();
                        } else if (focus_buttonFigure != null) {
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
                                    FigureList.add(new Circle(x, y, w, color[2], color[7], opacity));
                                    focus_figure = FigureList.get(FigureList.size() - 1);
                                    break;
                                case 2:
                                    FigureList.add(new Triangle(x, y, w, h, color[3], color[6], opacity));
                                    focus_figure = FigureList.get(FigureList.size() - 1);
                                    break;
                                case 3:
                                    FigureList.add(new Pentagon(x, y, w, h, color[4], color[5], opacity));
                                    focus_figure = FigureList.get(FigureList.size() - 1);
                                    break;
                                case 4:
                                    FigureList.add(new Ellipse(x, y, w, h, color[1], color[8], opacity));
                                    focus_figure = FigureList.get(FigureList.size() - 1);
                                    break;
                                case 5:
                                    focus_buttonFigure = null;
                                    for (Figure fig : FigureList) {
                                        if (fig.clicked(pMouse.x, pMouse.y)) {
                                            focus_figure = fig;
                                        }
                                    }
                                    if (focus_figure != null) {
                                        int option = JOptionPane.showOptionDialog(null,
                                                "Você deseja trocar a cor da borda ou de fundo?", "Troca de cor",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                                                options,
                                                options[0]);
                                        Color newColor = JColorChooser.showDialog(null, "Escolha a cor", Color.red);
                                        switch (option) {
                                            case 0:
                                                focus_figure.changeBackgroundColor(newColor);
                                                break;
                                            case 1:
                                                focus_figure.changeOutlineColor(newColor);
                                                break;
                                            case 2:
                                                focus_figure.changeBackgroundColor(newColor);
                                                focus_figure.changeOutlineColor(newColor);
                                                break;
                                        }
                                    }
                                    break;
                                case 6:
                                    focus_buttonFigure = null;
                                    for (Figure fig : FigureList) {
                                        if (fig.clicked(pMouse.x, pMouse.y)) {
                                            focus_figure = fig;
                                        }
                                    }
                                    FigureList.remove(focus_figure);
                                    focus_figure = null;
                                    break;
                            }
                            focus_buttonFigure = null;
                            repaint();
                        } else {
                            focus_figure = null;
                            focus_buttonColors = null;
                            focus_buttonFigure = null;
                            for (Figure fig : FigureList) {
                                if (fig.clicked(pMouse.x, pMouse.y)) {
                                    focus_figure = fig;
                                } else if (auxButton.clicked(pMouse.x, pMouse.y)) {
                                    focus_figure = fig;
                                    resizeButton = true;
                                } else {
                                    resizeButton = false;
                                }
                            }
                            if (focus_figure != null) {
                                FigureList.remove(focus_figure);
                                FigureList.add(focus_figure);
                            }
                            repaint();
                        }

                        repaint();
                    }
                });

        this.addMouseMotionListener(
                new MouseAdapter() {
                    public void mouseDragged(MouseEvent e) {
                        if (resizeButton && focus_figure != null) {
                            focus_figure.resize(e.getX() - mouseX);
                        } else {
                            if (focus_figure != null) {
                                int[] position = new int[] { e.getX() - mouseX, e.getY() - mouseY };
                                focus_figure.setPosition(position);
                            }
                        }
                        repaint();
                        mouseX = e.getX();
                        mouseY = e.getY();
                    }
                });
        this.setFocusTraversalKeysEnabled(false);
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(700, 700));
        this.setVisible(true);
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
            auxButton.setX(focus_figure.getX() + focus_figure.getW() + 5);
            auxButton.setY(focus_figure.getY() + focus_figure.getH() + 5);
            auxButton.paint(g, false);
        }
    }
}
