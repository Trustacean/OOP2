package Perpustakaan.GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import Perpustakaan.Classes.*;

public class EditKoleksiPanel extends EditPanel {
    DafPerpus dtKoleksi;
    DefaultTableModel model;

    EditKoleksiPanel(JFrame frame, DafPerpus dtKoleksi) {
        super(frame);
        this.dtKoleksi = dtKoleksi;

        comboBox = new JComboBox<String>(comboBoxItems2);
        add(comboBox);
        comboBox.setBounds(40, 120, 100, 25);

        subtitle.setText("REGISTRASI KOLEKSI");
        label[0].setText("ID Koleksi");
        label[1].setText("Judul");
        label[2].setText("Penerbit");

        checkKoleksiType();

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkKoleksiType();
            }
        });

        tambahButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addKoleksi();
            }
        });

        showTable();
    }

    private void checkKoleksiType() {
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

    public boolean addKoleksi() {
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
            default:
                p = new Koleksi();
        }
        System.out.println(p);
        dtKoleksi.isiDataKoleksi(p);
        refreshTable();
        return true;
    }

    private void showTable() {
        JTable koleksiListtable = new JTable();
        String[] columnNames = { "Id Koleksi", "Judul", "Penerbit", "ISBN/SN", "Halaman/Format/Vol",
                "Seri (Majalah)" };

        model = new DefaultTableModel(columnNames, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        koleksiListtable.setModel(model);
        koleksiListtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        koleksiListtable.getTableHeader().setReorderingAllowed(false);

        koleksiListtable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = koleksiListtable.getSelectedRow();
                    System.out.println(selectedRow);
                    if (selectedRow >= 0) {
                        String[] temp = new String[6];
                        for (int i = 0; i < 6; i++) {
                            temp[i] = (String) koleksiListtable.getValueAt(selectedRow, i);
                            textField[i].setText(temp[i]);
                        }
                    }
                }
            }
        });

        refreshTable();

        JScrollPane scrollPane = new JScrollPane(koleksiListtable);
        scrollPane.setBounds(370, 20, 500, 500);

        add(scrollPane);
    }

    private void refreshTable() {
        model.setRowCount(0);
        for (Koleksi koleksi : dtKoleksi.koleksiList) {
            String id = koleksi.getId_koleksi();
            String judul = koleksi.getJudul();
            String penerbit = koleksi.getPenerbit();

            String var1 = "",
                    var2 = "",
                    var3 = "";

            if (koleksi instanceof Buku) {
                var1 = ((Buku) koleksi).getIsbn();
                var2 = ((Buku) koleksi).getHalaman();
            } else if (koleksi instanceof Disk) {
                var1 = ((Disk) koleksi).getIsbn();
                var2 = ((Disk) koleksi).getFormat();
            } else if (koleksi instanceof Majalah) {
                var1 = ((Majalah) koleksi).getIssn();
                var2 = ((Majalah) koleksi).getVolume();
                var3 = ((Majalah) koleksi).getSeri();
            }

            model.addRow(new String[] { id, judul, penerbit, var1, var2, var3 });
        }
    }
}
