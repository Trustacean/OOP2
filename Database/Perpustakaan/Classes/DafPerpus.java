package Perpustakaan.Classes;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DafPerpus {
    public ArrayList<Peminjam> peminjamList = new ArrayList<>();
    public ArrayList<Koleksi> koleksiList = new ArrayList<>();

    AppendableObjectOutputStream peminjamOutObjectStream;
    AppendableObjectOutputStream koleksiOutObjectStream;

    public DafPerpus() throws IOException, ClassNotFoundException {
        readPeminjamFile();
        readKoleksiFile();
    }

    public void readPeminjamFile() throws IOException, ClassNotFoundException {
        File pinjamFile = new File("Perpustakaan/Data/peminjam2.dat");
        boolean append = pinjamFile.exists();

        FileOutputStream fout = new FileOutputStream(pinjamFile, append);
        peminjamOutObjectStream = new AppendableObjectOutputStream(fout, append);

        FileInputStream inFileStream = new FileInputStream(pinjamFile);
        ObjectInputStream peminjamInObjectStream = new ObjectInputStream(inFileStream);

        while (true) {
            try {
                peminjamList.add((Peminjam) peminjamInObjectStream.readObject());
            } catch (EOFException e) {
                break;
            }
        }
        peminjamInObjectStream.close();
    }

    public void readKoleksiFile() throws IOException, ClassNotFoundException {
        File koleksiFile = new File("Perpustakaan/Data/koleksi2.dat");
        boolean append = koleksiFile.exists();

        FileOutputStream fout = new FileOutputStream(koleksiFile, append);
        koleksiOutObjectStream = new AppendableObjectOutputStream(fout, append);

        FileInputStream inFileStream = new FileInputStream(koleksiFile);
        ObjectInputStream koleksiInObjectStream = new ObjectInputStream(inFileStream);

        while (true) {
            try {
                koleksiList.add((Koleksi) koleksiInObjectStream.readObject());
            } catch (EOFException e) {
                break;
            }
        }
        koleksiInObjectStream.close();
    }

    public void isiDataPeminjam(Peminjam data) {
        try {
            peminjamList.add(data);
            System.out.println(data.getNama());
            peminjamOutObjectStream.writeObject(data);
        } catch (Exception ex) {
            Logger.getLogger(DafPerpus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void isiDataKoleksi(Koleksi data) {
        try {
            koleksiList.add(data);
            System.out.println(data.getJudul());
            koleksiOutObjectStream.writeObject(data);
        } catch (Exception ex) {
            Logger.getLogger(DafPerpus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
