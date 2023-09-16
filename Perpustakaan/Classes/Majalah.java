package Perpustakaan.Classes;

public class Majalah extends Koleksi{
    protected int volume;
    protected int seri;
    protected String issn;

    Majalah(String id_koleksi, String judul, String penerbit, boolean status) {
        super(id_koleksi, judul, penerbit, status);
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setSeri(int seri) {
        this.seri = seri;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public int getVolume() {
        return volume;
    }

    public int getSeri() {
        return seri;
    }

    public String getIssn() {
        return issn;
    }
    
    public String toString() {
        return super.toString()+" Volume "+volume+" Seri "+seri+" ISSN "+issn;
    }
}
