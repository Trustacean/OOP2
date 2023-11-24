package Perpustakaan.old;

import java.sql.*;


public class DataHandler {
    String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
    String userid = "pbol";
    String password = "MHS225314067";
    Connection conn;
    Statement stmt;
    ResultSet rset;
    String query;

    public DataHandler() {
        this.getDBConnection();
    }

    public void getDBConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // dari Driver class
            conn = DriverManager.getConnection(jdbcUrl, userid, password);
            System.out.println("Koneksi berhasil");
        } catch (Exception e) {
            // perform error handling here
            System.out.println("Masih belum konek");
        }
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Tidak bisa tutup koneksi");
        }
    }

    public ResultSet getAllEmployees() throws SQLException {
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        query = "SELECT ID_KOLEKSI, JUDUL, PENERBIT" +
                " FROM buku ";
        System.out.println("\nExecuting query: " + query);
        rset = stmt.executeQuery(query);
        return rset;
    }
}

class MainHandler {
    public static void main(String[] args) throws SQLException {
        DataHandler datahandler = new DataHandler();
        ResultSet rset = datahandler.getAllEmployees();
        while (rset.next()) {
            System.out.println(rset.getString(1) + " " + rset.getString(2) +
                    " " + rset.getString(3));
        }
        datahandler.close();
    }
}
