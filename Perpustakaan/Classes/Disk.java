package Perpustakaan.Classes;

public class Disk extends Koleksi{
    protected String format;
    protected String isbn;

    Disk(String id_koleksi, String judul, String penerbit, boolean status) {
        super(id_koleksi, judul, penerbit, status);
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getFormat() {
        return format;
    }

    public String getIsbn() {
        return isbn;
    }

    public String toString() {
        return super.toString()+" Format: "+format+" ISBN: " + isbn;
    }
}
