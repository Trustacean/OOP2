package Perpustakaan.Classes;

public class Buku extends Koleksi{
    protected int halaman;
    protected String isbn;
    
    Buku(String id_koleksi, String judul, String penerbit, boolean status) {
        super(id_koleksi, judul, penerbit, status);
    }
    
    public void setHalaman(int halaman) {
        this.halaman = halaman;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getHalaman() {
        return halaman;
    }

    public String getIsbn() {
        return isbn;
    }

    public String toString() {
        return super.toString()+" Halaman: "+halaman+" ISBN: "+isbn;
    }
}
