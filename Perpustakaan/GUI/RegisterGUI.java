package Perpustakaan.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import Perpustakaan.Classes.*;

public class RegisterGUI extends JPanel {
    private JLabel title = new JLabel("PERPUSTAKAAN"),
            subtitle = new JLabel("", SwingConstants.CENTER),
            label[] = new JLabel[5];

    private JTextField textField[] = new JTextField[5];

    private String[] comboBoxItems1 = { "Umum", "Mahasiswa", "Dosen" },
            comboBoxItems2 = { "Buku", "Disk", "Majalah" };
    private JComboBox comboBox;
    private JButton tambahButton = new JButton("Daftar"),
            resetButton = new JButton("Reset"),
            hapusButton = new JButton("Hapus"),
            keluarButton = new JButton("Keluar");
    private int selectedIndex;
    private JFrame frame;

    RegisterGUI(JFrame f, boolean isKoleksi) {
        frame = f;
        this.setLayout(null);

        add(title);
        add(subtitle);
        add(tambahButton);
        add(resetButton);
        add(hapusButton);
        add(keluarButton);

        title.setBounds(200, 25, 100, 25);
        subtitle.setBounds(180, 50, 140, 25);
        tambahButton.setBounds(150, 400, 100, 25);
        resetButton.setBounds(275, 400, 100, 25);
        hapusButton.setBounds(150, 450, 100, 25);
        keluarButton.setBounds(275, 450, 100, 25);

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetField();
            }
        });

        for (int i = 0; i < 5; i++) {
            label[i] = new JLabel();
            add(label[i]);
            label[i].setBounds(80, 180 + (i * 40), 100, 25);
            textField[i] = new JTextField(5);
            add(textField[i]);
            textField[i].setBounds(180, 180 + (i * 40), 200, 25);
        }

        if (isKoleksi) {
            registerKoleksi();
        } else {
            registerPeminjam();
        }
    }

    private void registerPeminjam() { // Register Peminjam
        remove(textField[4]);

        comboBox = new JComboBox(comboBoxItems1);
        add(comboBox);
        comboBox.setBounds(80, 120, 100, 25);

        subtitle.setText("REGISTRASI PEMINJAM");
        label[0].setText("Nama");
        label[1].setText("Alamat");
        label[3].setText("Maks Pinjam");

        peminjamStateChanged();

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                peminjamStateChanged();
            }

        });

        tambahButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Peminjam p;
                String[] values = new String[4];
                for (int i = 0; i < 4; i++) {
                    values[i] = textField[i].getText();
                }

                inputDialog(values);
                switch (selectedIndex) {
                    case 0:
                        System.out.println("umum");
                        p = new Umum(values[0], values[1], values[2], values[3]);
                        Umum a = (Umum) p;
                        System.out.println(p.getNama() + p.getAlamat() + a.getNik() + p.getMak_pinjam());
                        break;
                    case 1:
                        System.out.println("mahasiswa");
                        p = new Mahasiswa(values[0], values[1], values[2], values[3]);
                        Mahasiswa b = (Mahasiswa) p;
                        System.out.println(p.getNama() + p.getAlamat() + b.getNim() + p.getMak_pinjam());
                        break;
                    case 2:
                        System.out.println("dosen");
                        p = new Dosen(values[0], values[1], values[2], values[3]);
                        Dosen c = (Dosen) p;
                        System.out.println(p.getNama() + p.getAlamat() + c.getNip() + p.getMak_pinjam());
                        ;
                        break;

                }
            }
        });
    }

    private void registerKoleksi() { // Register Koleksi
        comboBox = new JComboBox(comboBoxItems2);
        add(comboBox);
        comboBox.setBounds(80, 120, 100, 25);

        subtitle.setText("REGISTRASI KOLEKSI");
        label[0].setText("Judul");
        label[1].setText("Penerbit");

        koleksiStateChanged();

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                koleksiStateChanged();
            }

        });

        tambahButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Koleksi p;
                String[] values = new String[5];
                for (int i = 0; i < 5; i++) {
                    values[i] = textField[i].getText();
                }
                inputDialog(values);
                switch (selectedIndex) {
                    case 0:
                        System.out.println("buku");
                        p = new Buku(values[0], values[1], values[2], values[3]);
                        Buku a = (Buku) p;
                        System.out.println(p.getJudul() + p.getPenerbit() + a.getIsbn() + a.getHalaman());
                        break;
                    case 1:
                        System.out.println("disk");
                        p = new Disk(values[0], values[1], values[2], values[3]);
                        Disk b = (Disk) p;
                        System.out.println(p.getJudul() + p.getPenerbit() + b.getIsbn() + b.getFormat());
                        break;
                    case 2:
                        System.out.println("majalah");
                        p = new Majalah(values[0], values[1], values[2], values[3], values[4]);
                        Majalah c = (Majalah) p;
                        System.out.println(p.getJudul() + p.getPenerbit() + c.getIssn() + c.getVolume() + c.getSeri());
                        break;

                }
            }
        });

    }

    private void peminjamStateChanged() {
        selectedIndex = comboBox.getSelectedIndex();
        switch (selectedIndex) {
            case 0: // Umum
                label[2].setText("NIK");
                break;
            case 1: // Mahasiswa
                label[2].setText("NIM");
                break;
            case 2: // Dosen
                label[2].setText("NIP");
                break;
        }
    }

    private void koleksiStateChanged() {
        label[2].setText("ISBN");
        label[4].setText(null);
        textField[4].setVisible(false);

        selectedIndex = comboBox.getSelectedIndex();
        switch (selectedIndex) {
            case 0: // Buku
                label[3].setText("Halaman");
                break;
            case 1: // Disk
                label[3].setText("Format");
                break;
            case 2: // Majalah
                label[2].setText("ISSN");
                label[3].setText("Volume");
                label[4].setText("Seri");
                textField[4].setVisible(true);
                break;
        }
    }

    public void resetField() {
        for (int i = 0; i < 5; i++) {
            textField[i].setText(null);
        }
    }

    public void inputDialog(String[] val) {
        JDialog dialog = new JDialog(frame, "Attention");
        JLabel label = new JLabel("Berhasil Ditambahkan", SwingConstants.CENTER),
                labelVal[] = new JLabel[val.length],
                labelCont[] = new JLabel[val.length];
        JButton button1 = new JButton("OK");
        JPanel p = new JPanel();

        for (int i = 0 ; i < val.length&&this.label[i].getText()!=null; i++) {
            labelVal[i] = new JLabel(" : " + val[i]);
            labelCont[i] = new JLabel(this.label[i].getText());
            p.add(labelCont[i]);
            p.add(labelVal[i]);
            labelCont[i].setBounds(10, i * 15 + 20, 200, 25);
            labelVal[i].setBounds(85, i * 15 + 20, 200, 25);
        }

        p.setLayout(null);
        p.add(label);
        p.add(button1);

        label.setBounds(0, 0, 250, 25);
        button1.setBounds(75, 120, 100, 25);

        dialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        dialog.add(p);
        dialog.setSize(250, 200);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
        frame.setEnabled(false);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setEnabled(true);
                dialog.dispose();

            }
        });

        resetField();
    }
}
