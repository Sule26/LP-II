package panels;

import figures.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;


public class ListFrame  extends JFrame {

  ListPanel panel = new ListPanel();
  public ListFrame() {
    try {
        FileInputStream f = new FileInputStream("proj.bin");
        ObjectInputStream o = new ObjectInputStream(f);
        ListPanel.FigureList = (ArrayList<Figure>) o.readObject();
        o.close();
    } catch (Exception x) {
    }

    this.addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    try {
                        FileOutputStream f = new FileOutputStream("proj.bin");
                        ObjectOutputStream o = new ObjectOutputStream(f);
                        o.writeObject(ListPanel.FigureList);
                        o.flush();
                        o.close();
                    } catch (Exception x) {
                    }
                    System.exit(0);
                }
            });


    this.setTitle("João Pedro's Project");
    this.add(panel);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }
}
