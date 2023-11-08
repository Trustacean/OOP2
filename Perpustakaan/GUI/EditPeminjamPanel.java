package Perpustakaan.GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import Perpustakaan.Classes.*;

public class EditPeminjamPanel extends EditPanel {
    DafPerpus dtPeminjam;
    DefaultTableModel model;

    EditPeminjamPanel(JFrame frame, DafPerpus dtPeminjam) {
        super(frame);
        this.dtPeminjam = dtPeminjam;

        remove(textField[5]);

        comboBox = new JComboBox<String>(comboBoxItems1);
        add(comboBox);
        comboBox.setBounds(40, 120, 100, 25);

        subtitle.setText("REGISTRASI PEMINJAM");
        label[0].setText("ID Peminjam");
        label[1].setText("Nama");
        label[2].setText("Alamat");
        label[4].setText("Maks Pinjam");

        checkPeminjamType();

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkPeminjamType();
            }
        });

        tambahButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addPeminjam();
            }
        });

        showTable();
    }

    private void checkPeminjamType() {
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

    public boolean addPeminjam() {
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
        Peminjam p;
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
            default:
                p = new Peminjam();
        }

        dtPeminjam.isiDataPeminjam(p);

        refreshTable();
        return true;
    }

    private void showTable() {
        JTable peminjamListTable = new JTable();
        String[] columnNames = { "Id Peminjam", "Nama", "Alamat", "Identitas", "Maksimal Pinjam" };

        model = new DefaultTableModel(columnNames, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        peminjamListTable.setModel(model);
        peminjamListTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        peminjamListTable.getTableHeader().setReorderingAllowed(false);

        peminjamListTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = peminjamListTable.getSelectedRow();
                    System.out.println(selectedRow);
                    if (selectedRow >= 0) {
                        String[] temp = new String[5];
                        for (int i = 0; i < 5; i++) {
                            temp[i] = (String) peminjamListTable.getValueAt(selectedRow, i);
                            textField[i].setText(temp[i]);
                        }
                    }
                }
            }
        });

        refreshTable();

        JScrollPane scrollPane = new JScrollPane(peminjamListTable);
        scrollPane.setBounds(370, 20, 500, 500);

        add(scrollPane);
    }

    private void refreshTable() {
        model.setRowCount(0);
        for (Peminjam peminjam : dtPeminjam.peminjamList) {
            String idPeminjam = peminjam.getId_peminjam();
            String nomorIdentitas = "";

            if (peminjam instanceof Umum) {
                nomorIdentitas = ((Umum) peminjam).getNik();
            } else if (peminjam instanceof Mahasiswa) {
                nomorIdentitas = ((Mahasiswa) peminjam).getNim();
            } else if (peminjam instanceof Dosen) {
                nomorIdentitas = ((Dosen) peminjam).getNip();
            }

            String nama = peminjam.getNama();
            String alamat = peminjam.getAlamat();
            String maksimalPinjam = peminjam.getMak_pinjam();

            model.addRow(new String[] { idPeminjam, nama, alamat, nomorIdentitas, maksimalPinjam });
        }
    }
}
