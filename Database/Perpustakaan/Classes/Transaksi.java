package Perpustakaan.Classes;

import java.sql.Date;

public class Transaksi {
    protected int id_transaksi;
    protected Date tgl_pinjam;
    protected Date tgl_kembali;
    protected double denda;
    protected Koleksi[] koleksi;
    protected Peminjam peminjam;

    Transaksi(Peminjam peminjam){
        this.peminjam = peminjam;
        this.koleksi = new Koleksi[100];
    }

    public String toString() {
        return super.toString();
    }
    
}
