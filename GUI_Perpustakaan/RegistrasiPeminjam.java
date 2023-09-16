package GUI_Perpustakaan;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistrasiPeminjam {
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
    private JPanel panel = new JPanel();


    RegistrasiPeminjam(GUI_Perpustakaan p) {
        p.reCreatePanel();
    }


	public RegistrasiPeminjam(ActionListener actionListener) {
	}

}
