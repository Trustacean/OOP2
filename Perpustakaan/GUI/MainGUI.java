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
    JPanel contentPane = new JPanel();
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

        contentPane.setLayout(new CardLayout());
        contentPane.add(new RegisterGUI(contentPane, this, false),"Peminjam");
        contentPane.add(new RegisterGUI(contentPane, this, true), "Koleksi");

        frame.setJMenuBar(menubar);
        frame.setTitle("Perpustakaan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(475, 600);
        frame.setResizable(false);
        frame.setLayout(null);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == peminjamItem) {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane,"Peminjam");
            System.out.println("e");
        }
        if (e.getSource() == koleksiItem) {
            System.out.println("f");
        }
    }
}
