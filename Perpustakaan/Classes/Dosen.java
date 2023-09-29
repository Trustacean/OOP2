package Perpustakaan.Classes;

public class Dosen extends Peminjam {
    protected String nip;

    public Dosen(String nama, String alamat, String nip, String mak_pinjam) {
        super(nama, alamat, mak_pinjam);
        setNip(nip);
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNip() {
        return nip;
    }

    public String toString() {
        return super.toString() + " NIP: " + nip;
    }
}
