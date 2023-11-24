package Perpustakaan.GUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import Perpustakaan.Classes.*;



public class MainGUI implements ActionListener {
    DaoPerpus data;
    
    ArrayList<Peminjam> peminjamList = new ArrayList<Peminjam>();
    JFrame frame = new JFrame();
    CardLayout cl = new CardLayout();
    JPanel panelContainer = new JPanel(),
            mainPanel = new JPanel(),
            editPeminjamPanel,
            editKoleksiPanel;

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

    JLabel title = new JLabel("PERPUSTAKAAN");

            
    public MainGUI() throws SQLException {

        data = new DaoPerpus();
        
        editPeminjamPanel = new EditPeminjamPanel(frame,data);
        editKoleksiPanel = new EditKoleksiPanel(frame,data);

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
        
        peminjamItem.addActionListener(this);
        koleksiItem.addActionListener(this);

        panelContainer.setLayout(cl);
        panelContainer.add(mainPanel, "mainPanel");
        panelContainer.add(editPeminjamPanel, "peminjamItem");
        panelContainer.add(editKoleksiPanel, "koleksiItem");

        cl.show(panelContainer, "mainPanel");

        mainPanel.setLayout(null);
        mainPanel.add(title);
        title.setBounds(200, 25, 100, 25);

        frame.setTitle("Perpustakaan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setJMenuBar(menubar);
        frame.setResizable(false);
        frame.add(panelContainer);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
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

    public void setPeminjamList(ArrayList<Peminjam> peminjamList) {
        this.peminjamList = new ArrayList<Peminjam>(peminjamList);
    }
}
