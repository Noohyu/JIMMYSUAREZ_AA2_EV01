package evidenciasena;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jimmy
 */
public class EvidenciaSena {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/proyecto";
        String user = "root";
        String password = "97b54758bbbb2e29##";

        Connection conexion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion correcta");

            Statement statement = conexion.createStatement();
            String sql = "SELECT * FROM cliente";
            ResultSet resultado = statement.executeQuery(sql);

            while (resultado.next()) {
                long id = resultado.getLong("Cedula");
                String nombre = resultado.getString("Nombre");
                String apellido = resultado.getString("Apellido");
                String sexo = resultado.getString("SEXO");
                java.sql.Date fecha = resultado.getDate("FechaDeEpedicion");

                System.out.println("Cedula: " + id + 
                                   "\nNombre: " + nombre + 
                                   "\nApellido: " + apellido + 
                                   "\nSexo: " + sexo + 
                                   "\nFecha de Expedicion: " + fecha);
            }

            resultado.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

