package GUI_Perpustakaan;

import javax.swing.*;

import java.awt.Color;
  
 public class ae {
    public static void main(String[] args) {
        JPanel p1 = new JPanel();
        p1.setBackground(Color.black);
        p1.setBounds(0,0,250,250);
        JFrame frame = new JFrame();
        frame.setTitle("Aintnoway");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(750, 750);
        frame.add(p1);
        frame.setLayout(null);

        frame.setVisible(true);
    }
 }