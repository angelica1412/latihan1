import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Koneksi {
    private Connection connect;
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/tugas_oop";
    private String username = "root";
    private String password = "";


    public Connection getKoneksi() throws SQLException{
        if(connect == null){
            try {
                Class.forName(driverName);
                System.out.println("Class driver ditemukan");
                connect = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return connect;
    }
}