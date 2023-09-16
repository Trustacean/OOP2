package Perpustakaan.Classes;

public class Umum extends Peminjam{
    protected String nik;

    Umum(String id_peminjam, String nama, String alamat, String mak_pinjam) {
        super(id_peminjam, nama, alamat, mak_pinjam);
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNik() {
        return nik;
    }

    public String toString() {
        return super.toString()+" NIK: "+nik;
    }
}
