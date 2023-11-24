package Perpustakaan.Classes;
import java.io.Serializable;

public class Peminjam implements Serializable {
    protected String id_peminjam;
    protected String nama;
    protected String alamat;
    protected int mak_pinjam;

    public Peminjam() {
        
    }

    public Peminjam(String id_peminjam, String nama, String alamat, String mak_pinjam) {
        this.id_peminjam = id_peminjam;
        this.nama = nama;
        this.alamat = alamat;
        this.mak_pinjam = Integer.parseInt(mak_pinjam);
    }

    public void setId_peminjam(String id_peminjam) {
        this.id_peminjam = id_peminjam;
    }

    public String getId_peminjam() {
        return id_peminjam;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setMak_pinjam(String mak_pinjam) {
        this.mak_pinjam = Integer.parseInt(mak_pinjam);
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getMak_pinjam() {
        return mak_pinjam;
    }

    public String toString() {
        return "ID Peminjam: " + id_peminjam + " Nama: " + nama + " Alamat: " + alamat + " Maks Pinjam: " + mak_pinjam;
    }
}
