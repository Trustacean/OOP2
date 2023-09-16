package Perpustakaan.Classes;

public class Dosen extends Peminjam{
    protected String nip;

    Dosen(String id_peminjam, String nama, String alamat, String mak_pinjam) {
        super(id_peminjam, nama, alamat, mak_pinjam);
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNip() {
        return nip;
    }

    public String toString() {
        return super.toString()+" NIP: " + nip;
    }
}
