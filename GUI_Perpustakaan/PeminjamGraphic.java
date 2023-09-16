package GUI_Perpustakaan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class PeminjamGraphic extends JPanel {

    private JMenuBar menuBar;
    private JLabel title;
    private JLabel subtitle;
    private JComboBox comboBox1;
    private JLabel labelNama;
    private JTextField fieldNama;
    private JLabel labelAlamat;
    private JTextField fieldAlamat;
    private JLabel labelNik;
    private JTextField fieldNik;
    private JLabel labelNim;
    private JTextField fieldNim;
    private JLabel labelNip;
    private JTextField fieldNip;
    private JButton buttonDaftar;
    private int selectedIndex;


    public PeminjamGraphic() {
        //construct preComponents
        String[] comboBox1Items = {"Umum", "Mahasiswa", "Dosen"};

        //construct components
        title = new JLabel ("PERPUSTAKAAN");
        subtitle = new JLabel ("REGISTRASI PEMINJAM");
        comboBox1 = new JComboBox (comboBox1Items);
        fieldNama = new JTextField (5);
        labelNama = new JLabel ("Nama");
        labelAlamat = new JLabel ("Alamat");
        fieldAlamat = new JTextField (5);
        labelNik = new JLabel ("NIK");
        fieldNik = new JTextField (5);
        labelNim = new JLabel ("NIM");
        fieldNim = new JTextField (5);
        labelNip = new JLabel ("NIP");
        fieldNip = new JTextField (5);
        buttonDaftar = new JButton ("Daftar");

        //adjust size and set layout
        setPreferredSize (new Dimension (475, 500));
        setLayout (null);

        //add components
        add (title);
        add (subtitle);
        add (comboBox1);
        add (fieldNama);
        add (labelNama);
        add (labelAlamat);
        add (fieldAlamat);
        add (labelNik);
        add (fieldNik);
        add (labelNip);
        add (fieldNip);
        add (labelNim);
        add (fieldNim);
        add (buttonDaftar);

        //set component bounds (only needed by Absolute Positioning)
        title.setBounds (195, 25, 100, 25);
        subtitle.setBounds (175, 60, 140, 25);
        comboBox1.setBounds (80, 120, 100, 25);
        labelNama.setBounds (80, 180, 100, 25);
        fieldNama.setBounds (180, 180, 200, 25);
        labelAlamat.setBounds (80, 220, 100, 25);
        fieldAlamat.setBounds (180, 220, 200, 25);
        labelNik.setBounds (80, 260, 100, 25);
        fieldNik.setBounds (180, 260, 200, 25);
        labelNim.setBounds (80, 260, 100, 25);
        fieldNim.setBounds (180, 260, 200, 25);
        labelNip.setBounds (80, 260, 100, 25);
        fieldNip.setBounds (180, 260, 200, 25);
        buttonDaftar.setBounds (180, 350, 100, 25);

        //comboBox reset state
        reset();
        itemStateChanged();
        
        comboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                itemStateChanged();
            }

        });
        
    }

    private void reset() {
        labelNik.setVisible (false);
        fieldNik.setVisible(false);
        labelNip.setVisible (false);
        fieldNip.setVisible (false);
        labelNim.setVisible(false);
        fieldNim.setVisible (false);
    }

    private void itemStateChanged() {
        reset();
        selectedIndex = comboBox1.getSelectedIndex();
        switch (selectedIndex) {
            case 0: umum(); break;
            case 1: mahasiswa(); break;
            case 2: dosen(); break;
        }
    }

    private void umum() {
        labelNik.setVisible (true);
        fieldNik.setVisible(true);
    }

    private void mahasiswa() {
        labelNim.setVisible(true);
        fieldNim.setVisible (true);
    }

    private void dosen() {
        labelNip.setVisible (true);
        fieldNip.setVisible (true);
    }




    public static void main (String[] args) {
        JFrame frame = new JFrame ("Perpustakaan");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new PeminjamGraphic());
        frame.pack();
        frame.setVisible (true);
    }
}
