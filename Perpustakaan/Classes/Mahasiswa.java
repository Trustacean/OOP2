package Perpustakaan.Classes;

public class Mahasiswa extends Peminjam {
    protected String nim;

    public Mahasiswa(String nama, String alamat, String nim, String mak_pinjam) {
        super(nama, alamat, mak_pinjam);
        setNim(nim);
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public String toString() {
        return super.toString() + " NIM: " + nim;
    }
}
