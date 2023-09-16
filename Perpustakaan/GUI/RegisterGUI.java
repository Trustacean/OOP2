package Perpustakaan.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class RegisterGUI extends Panel{
    private JPanel panel;
    private JLabel title = new JLabel(),
            subtitle = new JLabel(),
            firstLabel = new JLabel(),
            secondLabel = new JLabel(),
            thirdLabel = new JLabel(),
            fourthLabel = new JLabel(),
            fifthLabel = new JLabel();
    private JTextField firstTextField = new JTextField(5),
            secondTextField = new JTextField(5),
            thirdTextField = new JTextField(5),
            fourthTextField = new JTextField(5),
            fifthTextField = new JTextField(5);

    private String[] comboBoxItems1 = { "Umum", "Mahasiswa", "Dosen" },
            comboBoxItems2 = { "Buku", "Disk", "Majalah" };
    private JComboBox comboBox1;
    private JButton daftarButton = new JButton();
    private int selectedIndex;

    RegisterGUI(JPanel panel,MainGUI gui, boolean type) {
        registerPeminjam();
    }
    private void registerPeminjam() {
        this.panel = panel;
        setBackground(Color.black);
        setBounds(0, 0, 475, 600);
        setLayout(null);
    }

    private void registerKoleksi() {

    }

}
