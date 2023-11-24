package Perpustakaan.GUI;

import java.awt.event.*;
import javax.swing.*;

public class EditPanel extends JPanel {
    JFrame mainFrame;
    JLabel title = new JLabel("PERPUSTAKAAN"),
           subtitle = new JLabel("", SwingConstants.CENTER),
           label[] = new JLabel[6];

    JTextField textField[] = new JTextField[6];

    String[] comboBoxItems1 = { "Umum", "Mahasiswa", "Dosen" },
             comboBoxItems2 = { "Buku", "Disk", "Majalah" };
    JComboBox<String> comboBox;
    JButton tambahButton = new JButton("Daftar"),
            resetButton = new JButton("Reset"),
            hapusButton = new JButton("Hapus"),
            keluarButton = new JButton("Keluar");
    JTable peminjamListTable;
    int selectedIndex;

    EditPanel(JFrame frame) {
        this.mainFrame=frame;
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
    }

    public void resetField() {
        for (int i = 0; i < 5; i++) {
            textField[i].setText(null);
        }
    }

    public void inputDialog(String[] val) {
        JDialog dialog = new JDialog(mainFrame, "Attention");
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
        mainFrame.setEnabled(false);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setEnabled(true);
                dialog.dispose();

            }
        });
        resetField();
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
}
