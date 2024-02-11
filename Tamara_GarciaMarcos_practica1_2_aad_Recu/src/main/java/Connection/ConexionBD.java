package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Esta clase se encarga de realizar la conexion con la base de datos
 * @author Tamara Garcia Marcos
 */
public class ConexionBD {
	private static final String URL = "jdbc:mysql://localhost:3306/jdbc_competicion";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public static void cerrarConexion(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
