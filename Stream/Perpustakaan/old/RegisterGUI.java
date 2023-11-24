package Perpustakaan.old;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import Perpustakaan.Classes.*;
import Perpustakaan.GUI.MainGUI;

public class RegisterGUI extends JPanel {
    private MainGUI main;
    private JFrame frame;
    private JLabel title = new JLabel("PERPUSTAKAAN"),
            subtitle = new JLabel("", SwingConstants.CENTER),
            label[] = new JLabel[6];

    private JTextField textField[] = new JTextField[6];

    private String[] comboBoxItems1 = { "Umum", "Mahasiswa", "Dosen" },
            comboBoxItems2 = { "Buku", "Disk", "Majalah" };
    private JComboBox<String> comboBox;
    private JButton tambahButton = new JButton("Daftar"),
            resetButton = new JButton("Reset"),
            hapusButton = new JButton("Hapus"),
            keluarButton = new JButton("Keluar");
    private JTable peminjamListTable;
    private int selectedIndex;

    private ArrayList<Peminjam> peminjamList = new ArrayList<Peminjam>();

    RegisterGUI(MainGUI m, JFrame f, boolean isKoleksi, ArrayList<Peminjam> peminjamList) {
        frame = f;
        this.main = m;
        this.peminjamList = peminjamList;
        this.setLayout(null);

        add(title);
        add(subtitle);
        add(tambahButton);
        add(resetButton);
        add(hapusButton);
        add(keluarButton);

        title.setBounds(150, 25, 100, 25);
        subtitle.setBounds(130, 50, 140, 25);
        tambahButton.setBounds(110, 450, 100, 25);
        resetButton.setBounds(235, 450, 100, 25);
        hapusButton.setBounds(110, 500, 100, 25);
        keluarButton.setBounds(235, 500, 100, 25);

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetField();
            }
        });

        for (int i = 0; i < 6; i++) {
            label[i] = new JLabel();
            add(label[i]);
            label[i].setBounds(40, 180 + (i * 40), 100, 25);
            textField[i] = new JTextField(5);
            add(textField[i]);
            textField[i].setBounds(140, 180 + (i * 40), 200, 25);
        }

        if (isKoleksi) {
            registerKoleksi();
        } else {
            registerPeminjam();
        }
    }

    private void registerPeminjam() { // Register Peminjam
        remove(textField[5]);
        showTable();

        comboBox = new JComboBox<String>(comboBoxItems1);
        add(comboBox);
        comboBox.setBounds(40, 120, 100, 25);

        subtitle.setText("REGISTRASI PEMINJAM");
        label[0].setText("ID Peminjam");
        label[1].setText("Nama");
        label[2].setText("Alamat");
        label[4].setText("Maks Pinjam");

        peminjamStateChanged();

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                peminjamStateChanged();
            }
        });

        tambahButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                daftarkanPeminjam();
            }
        });
    }

    private void showTable() {
        String[] columnNames = { "Id Peminjam", "Idenititas", "Nama", "Alamat", "Maksimal Pinjam" };
        peminjamList.add(0, new Mahasiswa("M1", "BUDI BUGATTI", "Alamat 1", "098098098", "1"));
        peminjamList.add(1, new Mahasiswa("M2", "ARMAN GTX", "Alamat 2", "123123123", "2"));

        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        peminjamListTable = new JTable(model);
        peminjamListTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        ListSelectionModel selectionModel = peminjamListTable.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = peminjamListTable.getSelectedRow();
                    for (int i = 0; i < 5; i++) {
                        textField[i].setText((String) peminjamListTable.getValueAt(selectedRow, i));
                    }

                }
            }
        });

        

        for (int i = 0; i < peminjamList.size(); i++) {
            String[] temp = new String[5];
            temp[0] = (peminjamList.get(i).getId_peminjam());

            if (peminjamList.get(i) instanceof Umum) {
                Umum u = (Umum) peminjamList.get(i);
                temp[1] = (u.getNik());
            }
            if (peminjamList.get(i) instanceof Mahasiswa) {
                Mahasiswa p = (Mahasiswa) peminjamList.get(i);
                temp[1] = (p.getNim());
            }
            if (peminjamList.get(i) instanceof Dosen) {
                Dosen d = (Dosen) peminjamList.get(i);
                temp[1] = (d.getNip());
            }

            temp[2] = (peminjamList.get(i).getNama());
            temp[3] = (peminjamList.get(i).getAlamat());
            temp[4] = (peminjamList.get(i).getMak_pinjam());

            model.addRow(temp);
        }

        JScrollPane scrollPane = new JScrollPane(peminjamListTable);
        scrollPane.setBounds(370, 20, 500, 500);

        add(scrollPane);
        main.setPeminjamList(this.peminjamList);
    }

    private void registerKoleksi() { // Register Koleksi
        comboBox = new JComboBox<String>(comboBoxItems2);
        add(comboBox);
        comboBox.setBounds(40, 120, 100, 25);

        subtitle.setText("REGISTRASI KOLEKSI");
        label[0].setText("ID Koleksi");
        label[1].setText("Judul");
        label[2].setText("Penerbit");

        koleksiStateChanged();

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                koleksiStateChanged();
            }
        });

        tambahButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                daftarkanKoleksi();
            }
        });
    }

    private void peminjamStateChanged() {
        selectedIndex = comboBox.getSelectedIndex();
        switch (selectedIndex) {
            case 0: // Umum
                label[3].setText("NIK");
                break;
            case 1: // Mahasiswa
                label[3].setText("NIM");
                break;
            case 2: // Dosen
                label[3].setText("NIP");
                break;
        }
    }

    private void koleksiStateChanged() {
        label[3].setText("ISBN");
        label[5].setText(null);
        textField[5].setVisible(false);

        selectedIndex = comboBox.getSelectedIndex();
        switch (selectedIndex) {
            case 0: // Buku
                label[4].setText("Halaman");
                break;
            case 1: // Disk
                label[4].setText("Format");
                break;
            case 2: // Majalah
                label[3].setText("ISSN");
                label[4].setText("Volume");
                label[5].setText("Seri");
                textField[5].setVisible(true);
                break;
        }
    }

    public boolean isStringStartingWith(String text, char c) throws Exception {
        if (text.charAt(0) == c) {
            return true;
        }
        throw new Exception("must start with the letter " + c);
    }

    public boolean isContainingNumber(String text) throws Exception {
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                throw new Exception("contain number! ");
            }
        }
        return false;
    }

    public boolean lengthIs(String text, int idealLength) throws Exception {
        if (text.length() == idealLength) {
            return true;
        }
        throw new Exception("length must be " + idealLength);
    }

    public boolean isAtMost(String text, int num) throws Exception {
        if (Integer.parseInt(text) <= num) {
            return true;
        }
        ;
        throw new Exception("more than " + num + "!");
    }

    public boolean isNumeric(String text) throws Exception {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                throw new Exception("is not numeric!");
            }
        }
        return true;
    }

    public boolean checkDiskFormat(String text) throws Exception {
        if (text.compareTo("Audio") == 0
                || text.compareTo("Video") == 0
                || text.compareTo("Document") == 0) {
            return true;
        } else {
            throw new Exception();
        }
    }

    public boolean daftarkanPeminjam() {
        Peminjam p = new Peminjam(null, null, null, null);
        String[] values = new String[5];
        for (int i = 0; i < 5; i++) {
            values[i] = textField[i].getText();
        }
        // check if string starts with the letter
        try {
            isStringStartingWith(values[0], comboBoxItems1[selectedIndex].charAt(0));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ID " + e.getMessage());
            resetField();
            return false;
        }
        // check if name contains numbers
        try {
            isContainingNumber(values[1]);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Name cannot contain numbers!");
            return false;
        }

        try {
            int[] digits = { 16, 9, 18 };
            lengthIs(values[3], digits[selectedIndex]);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, label[3].getText() + " " + e.getMessage());
            return false;
        }

        try {
            int[] amount = { 3, 5, 7 };
            isAtMost(values[4], amount[selectedIndex]);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Amount cannot be " + e.getMessage());
            return false;
        }

        inputDialog(values);
        switch (selectedIndex) {
            case 0:
                p = new Umum(values[0], values[1], values[2], values[3], values[4]);
                System.out.println(p);
                break;
            case 1:
                p = new Mahasiswa(values[0], values[1], values[2], values[3], values[4]);
                System.out.println(p);
                break;
            case 2:
                p = new Dosen(values[0], values[1], values[2], values[3], values[4]);
                System.out.println(p);
                break;

        }
        peminjamList.add(peminjamList.size(), p);
        showTable();
        return true;
    }

    public boolean daftarkanKoleksi() {
        Koleksi p;
        String[] values = new String[6];
        for (int i = 0; i < 6; i++) {
            values[i] = textField[i].getText();
        }

        try {
            isStringStartingWith(values[0], comboBoxItems2[selectedIndex].charAt(0));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "ID must start with the letter " + comboBoxItems2[selectedIndex].charAt(0));
            resetField();
            return false;
        }

        try {
            if (selectedIndex == 0 || selectedIndex == 2) {
                isNumeric(values[4]);
            }
            if (selectedIndex == 2) {
                isNumeric(values[5]);
            }
        } catch (Exception e) {
            String temp = label[4].getText();
            if (label[5].getText() != null) {
                temp += " and " + label[5].getText();
            }
            JOptionPane.showMessageDialog(this, temp + " must be numeric!");
            return false;
        }

        try {
            if (selectedIndex == 1) {
                checkDiskFormat(values[4]);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "disk format must be either 'Audio', 'Video', or 'Document'!");
            return false;
        }

        inputDialog(values);
        switch (selectedIndex) {
            case 0:
                p = new Buku(values[0], values[1], values[2], values[3], values[4]);
                System.out.println(p);
                break;
            case 1:
                p = new Disk(values[0], values[1], values[2], values[3], values[4]);
                System.out.println(p);
                break;
            case 2:
                p = new Majalah(values[0], values[1], values[2], values[3], values[4], values[5]);
                System.out.println(p);
                break;
        }
        return true;
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

        for (int i = 0; i < val.length && this.label[i].getText() != null; i++) {
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
