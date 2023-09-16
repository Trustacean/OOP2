package GUI_Perpustakaan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI_Perpustakaan extends JFrame {
    private JMenuBar menubar = new JMenuBar();
    private JMenu editMenu = new JMenu("Edit"),
            transaksiMenu = new JMenu("Transaksi"),
            tampilMenu = new JMenu("Tampil"),
            helpMenu = new JMenu("Help");

    private JMenuItem peminjamItem = new JMenuItem("Peminjam"),
            koleksiItem = new JMenuItem("Koleksi"),
            pinjamItem = new JMenuItem("Pinjam"),
            kembaliItem = new JMenuItem("Kembali"),
            bukuItem = new JMenuItem("Buku"),
            diskItem = new JMenuItem("Disk"),
            majalahItem = new JMenuItem("Majalah");
    private JPanel panel = new JPanel();

    public GUI_Perpustakaan() {
        this.setTitle("Perpustakaan");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(new Dimension(475, 600));
        this.setResizable(false);
        this.setLayout(null);

        editMenu.add(peminjamItem);
        editMenu.add(koleksiItem);
        transaksiMenu.add(pinjamItem);
        transaksiMenu.add(kembaliItem);
        tampilMenu.add(bukuItem);
        tampilMenu.add(diskItem);
        tampilMenu.add(majalahItem);

        menubar.add(editMenu);
        menubar.add(transaksiMenu);
        menubar.add(tampilMenu);
        menubar.add(helpMenu);
        this.setJMenuBar(menubar);

        // reCreatePanel();

        peminjamItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegistrasiPeminjam s = new RegistrasiPeminjam(this);
            }
        });

    }

    public void reCreatePanel() {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 475, 580);
        panel.setBackground(Color.black);
        this.remove(panel);
        this.add(panel);
    }

    public static void main(String[] args) {
        GUI_Perpustakaan s = new GUI_Perpustakaan();

    }

}
