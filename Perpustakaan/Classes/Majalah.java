package Perpustakaan.Classes;

public class Majalah extends Koleksi {
    protected String volume;
    protected String seri;
    protected String issn;

    public Majalah(String judul, String penerbit, String issn, String volume, String seri) {
        super(judul, penerbit);
        setVolume(volume);
        setSeri(seri);
        setIssn(issn);
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setSeri(String seri) {
        this.seri = seri;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getVolume() {
        return volume;
    }

    public String getSeri() {
        return seri;
    }

    public String getIssn() {
        return issn;
    }

    public String toString() {
        return super.toString() + " Volume " + volume + " Seri " + seri + " ISSN " + issn;
    }
}
