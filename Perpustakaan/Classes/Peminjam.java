package Perpustakaan.Classes;

public class Peminjam {
    protected String id_peminjam;
    protected String nama;
    protected String alamat;
    protected String mak_pinjam;

    Peminjam(String id_peminjam, String nama, String alamat, String mak_pinjam) {
        this.id_peminjam = id_peminjam;
        this.nama = nama;
        this.alamat = alamat;
        this.mak_pinjam = mak_pinjam;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setMak_pinjam(String mak_pinjam) {
        this.mak_pinjam = mak_pinjam;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }
    
    public String getMak_pinjam() {
        return mak_pinjam;
    }
    
    public String toString() {
        return "Nama: "+nama+" Alamat: "+alamat;
    }
}
