package Perpustakaan.Classes;

import java.sql.*;
import java.util.ArrayList;

public class DataHandler {
    ArrayList<Peminjam> peminjamList = new ArrayList<>();
    ArrayList<Koleksi> koleksiList = new ArrayList<>();
    String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
    String userid = "pbol";
    String password = "MHS225314067";
    Connection conn;
    Statement pstmt;
    Statement stmt;
    ResultSet rs;

    DataHandler() throws SQLException {
        this.getDBConnection();

    }

    public void getDBConnection() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(jdbcUrl, userid, password);
            System.out.println("Koneksi berhasil");
        } catch (ClassNotFoundException ex) {
            System.out.println("Koneksi tidak berhasil");
        }
    }

    public ArrayList<Peminjam> getPeminjam() throws SQLException {
        peminjamList.clear();
        pstmt = null;
        rs = null;
        pstmt = conn.createStatement();

        rs = pstmt.executeQuery("SELECT * FROM umum");

        while (rs.next()) {
            Umum umum = new Umum(
                    rs.getString("id_peminjam"),
                    rs.getString("nama"),
                    rs.getString("alamat"),
                    rs.getString("nik"),
                    rs.getString("mak_pinjam"));
            peminjamList.add(umum);
        }

        rs = pstmt.executeQuery("SELECT * FROM mahasiswa");

        while (rs.next()) {
            Mahasiswa mahasiswa = new Mahasiswa(
                    rs.getString("id_peminjam"),
                    rs.getString("nama"),
                    rs.getString("alamat"),
                    rs.getString("nim"),
                    rs.getString("mak_pinjam"));
            peminjamList.add(mahasiswa);
        }

        rs = pstmt.executeQuery("SELECT * FROM dosen");

        while (rs.next()) {
            Dosen dosen = new Dosen(
                    rs.getString("id_peminjam"),
                    rs.getString("nama"),
                    rs.getString("alamat"),
                    rs.getString("nip"),
                    rs.getString("mak_pinjam"));
            peminjamList.add(dosen);
        }

        return peminjamList;
    }

    public ArrayList<Koleksi> getKoleksi() throws SQLException {
        koleksiList.clear();
        pstmt = null;
        rs = null;
        pstmt = conn.createStatement();

        rs = pstmt.executeQuery("SELECT * FROM buku");

        while (rs.next()) {
            Buku buku = new Buku(
                    rs.getString("id_koleksi"),
                    rs.getString("judul"),
                    rs.getString("penerbit"),
                    rs.getString("isbn"),
                    rs.getString("halaman"));
            koleksiList.add(buku);
        }

        rs = pstmt.executeQuery("SELECT * FROM disk");

        while (rs.next()) {
            Disk disk = new Disk(
                    rs.getString("id_koleksi"),
                    rs.getString("judul"),
                    rs.getString("penerbit"),
                    rs.getString("isbn"),
                    rs.getString("format"));
            koleksiList.add(disk);
        }

        rs = pstmt.executeQuery("SELECT * FROM majalah");

        while (rs.next()) {
            Majalah majalah = new Majalah(
                    rs.getString("id_koleksi"),
                    rs.getString("judul"),
                    rs.getString("penerbit"),
                    rs.getString("issn"),
                    rs.getString("volume"),
                    rs.getString("seri"));
            koleksiList.add(majalah);
        }

        return koleksiList;
    }

    public int insertMahasiswa(String id_peminjam, String nama, String alamat, String mak_pinjam, String nim) {
        String kueri = "INSERT INTO mahaiswa VALUES (?,?,?,?,?)";
        int rq = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(kueri)) {
            pstmt.setString(1, id_peminjam);
            pstmt.setString(2, nama);
            pstmt.setString(3, alamat);
            pstmt.setString(4, nim);
            pstmt.setString(5, mak_pinjam);
            rq = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;
    }

    public int insertDosen(String id_peminjam, String nama, String alamat, String mak_pinjam, String nip) {
        String kueri = "INSERT INTO dosen VALUES (?,?,?,?,?)";
        int rq = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(kueri)) {
            pstmt.setString(1, id_peminjam);
            pstmt.setString(2, nama);
            pstmt.setString(3, alamat);
            pstmt.setString(4, nip);
            pstmt.setString(5, mak_pinjam);
            rq = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;
    }

    public int insertUmum(String id_peminjam, String nama, String alamat, String mak_pinjam, String nik) {
        String kueri = "INSERT INTO umum VALUES (?,?,?,?,?)";
        int rq = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(kueri)) {
            pstmt.setString(1, id_peminjam);
            pstmt.setString(2, nama);
            pstmt.setString(3, alamat);
            pstmt.setString(4, nik);
            pstmt.setString(5, mak_pinjam);
            rq = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;
    }

    public int insertBuku(String id_koleksi, String judul, String penerbit, String isbn, String halaman) {
        String kueri = "INSERT INTO buku VALUES (?,?,?,?,?,?)";
        int rq = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(kueri)) {
            pstmt.setString(1, id_koleksi);
            pstmt.setString(2, judul);
            pstmt.setString(3, penerbit);
            pstmt.setString(4, "0");
            pstmt.setString(5, halaman);
            pstmt.setString(6, isbn);
            rq = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;
    }

    public int insertDisk(String id_koleksi, String judul, String penerbit, String isbn, String format) {
        String kueri = "INSERT INTO disk VALUES (?,?,?,?,?,?)";
        int rq = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(kueri)) {
            pstmt.setString(1, id_koleksi);
            pstmt.setString(2, judul);
            pstmt.setString(3, penerbit);
            pstmt.setString(4, "0");
            pstmt.setString(5, format);
            pstmt.setString(6, isbn);
            rq = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;
    }

    public int insertMajalah(String id_koleksi, String judul, String penerbit, String issn, String volume,
            String seri) {
        String kueri = "INSERT INTO majalah VALUES (?,?,?,?,?,?,?)";
        int rq = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(kueri)) {
            pstmt.setString(1, id_koleksi);
            pstmt.setString(2, judul);
            pstmt.setString(3, penerbit);
            pstmt.setString(4, "0");
            pstmt.setString(5, volume);
            pstmt.setString(6, seri);
            pstmt.setString(7, issn);
            rq = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rq;
    }
}