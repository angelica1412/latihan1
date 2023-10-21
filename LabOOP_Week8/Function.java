import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Function {

    Koneksi koneksi = new Koneksi();
    
    void readData(String id) {
        try {
            Connection conn = koneksi.getKoneksi();
            String query = "SELECT * FROM user_admin WHERE id_admin = "+ id;
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            // iterate through the result set

            while (result.next()) {
                String id_admin = result.getString("id_admin");
                String username_admin = result.getString("username_admin");
                String password_admin = result.getString("password_admin");
                // print the values of each column
                System.out.println(id_admin +"\n"+ username_admin +"\n"+  password_admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void addData(String id, String username, String password) {
        try {
            Connection conn = koneksi.getKoneksi();
            String query = "INSERT INTO user_admin (id_admin, username_admin, password_admin) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, username);
            ps.setString(3, password);

            ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    void updateData(String username_admin, String id_admin) {
        try {
            Connection conn = koneksi.getKoneksi();
            String query = "UPDATE user_admin set username_admin = ? WHERE id_admin = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username_admin);
            ps.setString(2, id_admin);

            ps.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    void deleteData (String id_admin) {
        try {
            Connection conn = koneksi.getKoneksi();
            String query = "DELETE FROM user_admin WHERE id_admin = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id_admin);

            ps.executeUpdate();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
