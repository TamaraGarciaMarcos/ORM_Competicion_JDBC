package PatronDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import Connection.ConexionBD;
import Modelo.Equipo;
/**
 * Esta clase se encarga de simular la implementacion del DAO en la clase Equipo * 
 * @author Tamara Garcia Marcos
 */
public class EquipoDAOImpl implements EquipoDAO {
	
	Logger log;
	
	// Métodos para crear y eliminar tablas según sea necesario
    public void crearTablas() {
        try (Connection conn = ConexionBD.getConnection()) {
            crearTablaEquipos(conn);
            crearTablaJugadores(conn);
            crearTablaFichajes(conn);
            log.info("Se han creado las tablas");
        }catch (SQLException sqle) {
			log.error("No se han podido crear las tablas");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
    }

    public void eliminarTablas(){
        try (Connection conn = ConexionBD.getConnection()) {
            eliminarTablaFichajes(conn);
            eliminarTablaJugadores(conn);
            eliminarTablaEquipos(conn);
            log.info("Se han eliminado las tablas");
        }catch (SQLException sqle) {
			log.error("No se han podido eliminar las tablas");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
    }

    private void crearTablaEquipos(Connection conn){
        String query = "CREATE TABLE IF NOT EXISTS equipos (id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100) NOT NULL)";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
            log.info("Se ha creado la tabla de equipos");
        }catch (SQLException sqle) {
			log.error("No se ha podido crear la tabla de equipos");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
    }

    private void crearTablaJugadores(Connection conn){
        String query = "CREATE TABLE IF NOT EXISTS jugadores (id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100) NOT NULL, nacionalidad VARCHAR(100), fecha_nacimiento DATE, equipo_id INT, FOREIGN KEY (equipo_id) REFERENCES equipos(id))";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
            log.info("Se ha creado la tabla de jugadores");
        }catch (SQLException sqle) {
			log.error("No se ha podido crear la tabla de jugadores");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
    }

    private void crearTablaFichajes(Connection conn) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS fichajes (id INT AUTO_INCREMENT PRIMARY KEY, fecha DATE, nombre_jugador VARCHAR(100) NOT NULL)";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
            log.info("Se ha creado la tabla de fichajes.");
        }catch (SQLException sqle) {
			log.error("No se ha podido crear la tabla de fichajes");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
    }


    private void eliminarTablaEquipos(Connection conn){
        String query = "DROP TABLE IF EXISTS equipos";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
            log.info("Se ha eliminado la tabla de equipos.");
        }catch (SQLException sqle) {
			log.error("No se han podido eliminar la tabla de equipos");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
    }
    

    private void eliminarTablaJugadores(Connection conn){
        String query = "DROP TABLE IF EXISTS jugadores";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
            log.info("Se ha eliminado la tabla de jugadores.");
        }catch (SQLException sqle) {
			log.error("No se han podido eliminar la tabla de jugadores");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
    }

    private void eliminarTablaFichajes(Connection conn){
        String query = "DROP TABLE IF EXISTS fichajes";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
            log.info("Se ha eliminado la tabla de fichajes.");
        }catch (SQLException sqle) {
			log.error("No se ha podido eliminar la tabla de fichajes");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
    }
	
	@Override
	public void insert(Equipo equipo){
		String query = "INSERT INTO equipos (nombre) VALUES (?)";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, equipo.getNombre());
			pstmt.executeUpdate();
			log.info("Se ha añadido el jugador al equipo");
		}catch (SQLException sqle) {
			log.error("No se han podido meter al jugador en el equipo");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
	}

	@Override
	public void delete(Equipo equipo){
		String query = "DELETE FROM equipos WHERE nombre = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, equipo.getNombre());
			pstmt.executeUpdate();
			log.info("Se ha eliminado el jugador del equipo");
		}catch (SQLException sqle) {
			log.error("No se han podido eliminar al jugador del equipo");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
	}

	@Override
	public List<Equipo> getAll(){
		List<Equipo> equipos = new ArrayList<>();
		String query = "SELECT * FROM equipos";
		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				Equipo equipo = new Equipo(nombre);
				equipos.add(equipo);
			}
			log.info("Se han obtenido todos los quipos");
		}catch (SQLException sqle) {
			log.error("No se han podido obtener todos los equipos");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
		return equipos;
	}

	@Override
	public List<Equipo> obtenerEquiposConPlantilla(){
		List<Equipo> equiposConPlantilla = new ArrayList<>();
		String query = "SELECT * FROM equipos WHERE tiene_plantilla = true";
		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				Equipo equipo = new Equipo(nombre);
				equiposConPlantilla.add(equipo);
			}
			log.info("Se han podido obtebner los equipos con sus jugadores");
		}catch (SQLException sqle) {
			log.error("No se han podido obtebner los equipos con sus jugadores");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
		return equiposConPlantilla;
	}

	@Override
	public List<Equipo> obtenerEquiposSinPlantilla() throws SQLException {
		List<Equipo> equiposSinPlantilla = new ArrayList<>();
		String query = "SELECT * FROM equipos WHERE tiene_plantilla = false";
		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				Equipo equipo = new Equipo(nombre);
				equiposSinPlantilla.add(equipo);
			}
			log.info("Se ha podido obtebner los equipos sin sus jugadores");
		}catch (SQLException sqle) {
			log.error("No se ha podido obtebner los equipos sin sus jugadores");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
		return equiposSinPlantilla;
	}

	@Override
	public Equipo obtenerEquipoPorNombre(String nombreEquipo) throws SQLException {
		String query = "SELECT * FROM equipos WHERE nombre = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, nombreEquipo);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					String nombre = rs.getString("nombre");
					return new Equipo(nombre);
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
	            System.out.println(e.toString());
			}
			log.info("Se ha podido obtener el equipo por su nombre");
		}catch (SQLException sqle) {
			log.error("No se ha podido obtener el equipo por su nombre");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
		return null;
	}

	@Override
	public void actualizarPlantillaEquipo(Equipo equipo){
		String query = "UPDATE equipos SET tiene_plantilla = ? WHERE nombre = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setBoolean(1, true); // Marcamos que el equipo tiene plantilla
			pstmt.setString(2, equipo.getNombre());
			pstmt.executeUpdate();
			log.info("Se ha podido actualizar la plantilla del equipo");
		}catch (SQLException sqle) {
			log.error("No se han podido actualizar la plantilla del equipo");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
	}

}
