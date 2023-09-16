                       package Perpustakaan.Classes;
public class Koleksi {
    protected String id_koleksi;
    protected String judul;
    protected String penerbit;
    protected boolean status;

    Koleksi(String id_koleksi, String judul, String penerbit, boolean status) {
        this.id_koleksi = id_koleksi;
        this.judul = judul;
        this.penerbit = penerbit;
        this.status = status;
    } 

    public void setId_koleksi(String id_koleksi) {
        this.id_koleksi = id_koleksi;
    }
    
    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getId_koleksi() {
        return id_koleksi;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public String toString() {
        return "Judul: " + judul + ", Penerbit: " + penerbit;
    }
}
