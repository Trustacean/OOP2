package Perpustakaan.Classes;

public class Buku extends Koleksi {
    protected String halaman;
    protected String isbn;
    
    public Buku(String id_koleksi, String judul, String penerbit, String isbn, String halaman) {
        super(id_koleksi,judul, penerbit);
        setHalaman(halaman);
        setIsbn(isbn);
    }
    
    public void setHalaman(String halaman) {
        this.halaman = halaman;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getHalaman() {
        return halaman;
    }

    public String getIsbn() {
        return isbn;
    }

    public String toString() {
        return super.toString()+" Halaman: "+halaman+" ISBN: "+isbn;
    }
}
