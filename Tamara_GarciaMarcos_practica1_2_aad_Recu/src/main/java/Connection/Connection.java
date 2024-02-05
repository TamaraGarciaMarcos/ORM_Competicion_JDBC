package Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Esta clase se encarga de realizar la conexion con la base de datos
 * 
 * @author Tamara Garcia Marcos
 */
public class Connection {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_competicion";
    private static final String USER = "tu_usuario";
    private static final String PASSWORD = "tu_contraseña";

    public static Connection obtenerConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }

    public static void cerrarConexion(Connection connection) {
        if (connection != null) {
            try {
                ((java.sql.Connection) connection).close();
            } catch (SQLException e) {
                e.printStackTrace();
                // Manejo de la excepción
            }
        }
    }
}
