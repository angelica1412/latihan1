import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Koneksi koneksi = new Koneksi();
        koneksi.getKoneksi();

        Function function = new Function();
        function.readData("2");

        // function.addData("2", "Maria", "Maria231");

        // function.updateData("Opik", "2");

        function.deleteData("2");
    }
}
