package Perpustakaan.Classes;

public class Disk extends Koleksi {
    protected String format;
    protected String isbn;

    public Disk(String judul, String penerbit, String isbn, String format) {
        super(judul, penerbit);
        setFormat(format);
        setIsbn(isbn);
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
        return super.toString() + " Format: " + format + " ISBN: " + isbn;
    }
}
