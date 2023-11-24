/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpustakaan.Dependencies;

import java.sql.*;



/**
 *
 * @author admin
 */
public class Database1 {
    static DataHandler dataHandler;
    static Connection conn;
    static Statement stat;
    public static void main(String[] args) throws SQLException {
        //load driver
        dataHandler = new DataHandler();
        dataHandler.getDBConnection();
        //buat koneksi
        conn = dataHandler.conn;
        stat=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        
       listDepartment();
//       System.out.println("Data yang berhasil dimasukkan "+insertDepartment()
//                +" departemen");
//       System.out.println("Data yang berhasil dimasukkan "
//               +insertDepartment(120,"IT",300,1300)+" departemen");
//       System.out.println("Data yang berhasil dimasukkan "
//               +insertDepartment(150,"CS")+" departemen");
       conn.close();
    }
    public static int insertDepartment() throws SQLException
    {
        String query="insert into Departemen values(210,'Everything',200,2500)";
        int numResult=stat.executeUpdate(query);
        
        return numResult;
        
    }
    public static int insertDepartment(int id,String nama,int man, int loc) throws SQLException
    {
        String query="insert into Departemen values("+id+",'"+nama+
                "',"+man+","+loc+")";
        int numResult=stat.executeUpdate(query);
        
        return numResult;
        
    }
    public static int insertDepartment(int id,String nama) throws SQLException
    {
        String query="insert into Departemen values(?,?,?,?)";
        PreparedStatement pstm=conn.prepareStatement(query);
        pstm.setObject(1, id);
        pstm.setObject(2, nama);
        pstm.setObject(3, 200);
        pstm.setObject(4, 2000);
        int numResult=pstm.executeUpdate();
        
        return numResult;
        
    }
    public static void listDepartment() throws SQLException
    {
         //buat statement
       String query="Select * from departments";
        //ambil hasil
        ResultSet rs=stat.executeQuery(query);
        int i=1;
        while(rs.next())
        {
            System.out.print(i++ +". ");
            System.out.println("Id Departemen : "+rs.getInt("department_id"));
            System.out.println("    Nama Departemen : "+rs.getString("department_name"));
        }
        
    }
}
    
