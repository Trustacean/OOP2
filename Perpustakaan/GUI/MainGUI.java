package Perpustakaan.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MainGUI implements ActionListener {
    JMenuBar menubar = new JMenuBar();
    JMenu editMenu = new JMenu("Edit"),
            transaksiMenu = new JMenu("Transaksi"),
            tampilMenu = new JMenu("Tampil"),
            helpMenu = new JMenu("Help");

    JMenuItem peminjamItem = new JMenuItem("Peminjam"),
            koleksiItem = new JMenuItem("Koleksi"),
            pinjamItem = new JMenuItem("Pinjam"),
            kembaliItem = new JMenuItem("Kembali"),
            bukuItem = new JMenuItem("Buku"),
            diskItem = new JMenuItem("Disk"),
            majalahItem = new JMenuItem("Majalah");
    JPanel panelContainer = new JPanel(),
            mainPanel = new JPanel();
    JLabel title = new JLabel("PERPUSTAKAAN");
    CardLayout cl = new CardLayout();
    JFrame frame = new JFrame();

    public MainGUI() {
        editMenu.add(peminjamItem);
        editMenu.add(koleksiItem);
        transaksiMenu.add(pinjamItem);
        transaksiMenu.add(kembaliItem);
        tampilMenu.add(bukuItem);
        tampilMenu.add(diskItem);
        tampilMenu.add(majalahItem);

        peminjamItem.addActionListener(this);
        koleksiItem.addActionListener(this);

        menubar.add(editMenu);
        menubar.add(transaksiMenu);
        menubar.add(tampilMenu);
        menubar.add(helpMenu);


        panelContainer.setLayout(cl);
        panelContainer.add(mainPanel, "mainPanel");
        panelContainer.add(new RegisterGUI(frame,false), "peminjamItem");
        panelContainer.add(new RegisterGUI(frame,true), "koleksiItem");


        cl.show(panelContainer,"mainPanel");
        mainPanel.setLayout(null);
        mainPanel.add(title);
        title.setBounds(200, 25, 100, 25);

        frame.setTitle("Perpustakaan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setJMenuBar(menubar);
        frame.setResizable(false);
        frame.add(panelContainer);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == peminjamItem) {
            cl.show(panelContainer, "peminjamItem");
            System.out.println("e");
        }
        if (e.getSource() == koleksiItem) {
            cl.show(panelContainer, "koleksiItem");
            System.out.println("f");
        }
    }
}
