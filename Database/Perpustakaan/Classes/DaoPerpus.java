package Perpustakaan.Classes;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class DaoPerpus {
    ArrayList<Peminjam> peminjamList = new ArrayList<>();
    ArrayList<Koleksi> koleksiList = new ArrayList<>();
    public DataHandler dataPerpus;

    public DaoPerpus() throws SQLException {
        dataPerpus = new DataHandler();
        try {
            peminjamList = dataPerpus.getPeminjam();
        } catch (SQLException ex) {
            Logger.getLogger(DaoPerpus.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            koleksiList = dataPerpus.getKoleksi();
        } catch (SQLException ex) {
            Logger.getLogger(DaoPerpus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Peminjam> getPeminjamList() throws SQLException {
        return dataPerpus.getPeminjam(); 
    }

    public ArrayList<Koleksi> getKoleksiList() throws SQLException {
        return dataPerpus.getKoleksi(); 
    }
}