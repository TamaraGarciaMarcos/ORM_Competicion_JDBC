package PatronDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import Connection.ConexionBD;
import Modelo.Fichaje;
import Modelo.Jugador;
/**
 * Esta clase se encarga de simular la implementacion del DAO en la clase Fichaje * 
 * @author Tamara Garcia Marcos
 */
public class FichajeDAOImpl implements FichajeDAO {
	Logger log;
	
	@Override
    public void insert(Fichaje fichaje){
        String query = "INSERT INTO fichajes (fecha, nombre_jugador) VALUES (?, ?)";
        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setDate(1, java.sql.Date.valueOf(fichaje.getFecha()));
            pstmt.setString(2, fichaje.getJugador().getNombre());
            pstmt.executeUpdate();
            log.info("Se ha podido insertar el fichaje");
        }catch (SQLException sqle) {
			log.error("No se ha podido insertar el fichaje");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
    }

    @Override
    public void delete(Fichaje fichaje) {
        String query = "DELETE FROM fichajes WHERE fecha = ? AND nombre_jugador = ?";
        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setDate(1, java.sql.Date.valueOf(fichaje.getFecha()));
            pstmt.setString(2, fichaje.getJugador().getNombre());
            pstmt.executeUpdate();
            log.info("Se ha podido eliminar el fichaje");
        }catch (SQLException sqle) {
			log.error("No se ha podido eliminar el fichaje");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
    }

    @Override
    public List<Fichaje> getAll(){
        List<Fichaje> fichajes = new ArrayList<>();
        String query = "SELECT * FROM fichajes";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                String nombreJugador = rs.getString("nombre_jugador");
                Jugador jugador = obtenerJugadorPorNombre(nombreJugador);
                Fichaje fichaje = new Fichaje(fecha, jugador);
                fichajes.add(fichaje);
            }
            log.info("Se ha podido obtener el listado de los fichajes");
        }catch (SQLException sqle) {
			log.error("No se ha podido obtener el listado de los fichajes");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
        return fichajes;
    }

    private Jugador obtenerJugadorPorNombre(String nombre){
        String query = "SELECT * FROM jugadores WHERE nombre = ?";
        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nombre);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nacionalidad = rs.getString("nacionalidad");
                    LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
                    String posicion= rs.getString("posicion");
                    return new Jugador(nombre, nacionalidad, fechaNacimiento, posicion);
                }
            }catch (Exception e) {
    			System.out.println(e.getMessage());
                System.out.println(e.toString());
    		}
            log.info("Se ha podido obtener el jugador por su nombre");
        }catch (SQLException sqle) {
			log.error("No se ha podido obtener el jugador por su nombre");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
        return null;
    }

	@Override
	public List<Fichaje> obtenerFichajesPorEquipo(String nombreEquipo){
		List<Fichaje> fichajes = new ArrayList<>();
		String query = "SELECT * FROM fichajes WHERE equipoOrigen = ? OR equipoDestino = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, nombreEquipo);
			pstmt.setString(2, nombreEquipo);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					LocalDate fecha = rs.getDate("fecha").toLocalDate();
					String nombreJugador = rs.getString("nombre_jugador");
					Jugador jugador = obtenerJugadorPorNombre(nombreJugador);
					Fichaje fichaje = new Fichaje(fecha, jugador);
					fichajes.add(fichaje);
				}
			}catch (Exception e) {
    			System.out.println(e.getMessage());
                System.out.println(e.toString());
    		}
            log.info("Se ha podido obtener los fichajes por equipo");
		}catch (SQLException sqle) {
			log.error("No se ha podido obtener los fichajes por equipo");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
		return fichajes;
	}

	@Override
	public List<Fichaje> obtenerFichajesPorFecha(String fecha){
		List<Fichaje> fichajes = new ArrayList<>();
		String query = "SELECT * FROM fichajes WHERE fecha = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, fecha);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					LocalDate fechaFichaje = rs.getDate("fecha").toLocalDate();
					String nombreJugador = rs.getString("nombre_jugador");
					Jugador jugador = obtenerJugadorPorNombre(nombreJugador);
					Fichaje fichaje = new Fichaje(fechaFichaje, jugador);
					fichajes.add(fichaje);
				}
			}catch (Exception e) {
    			System.out.println(e.getMessage());
                System.out.println(e.toString());
    		}
            log.info("Se ha podido obtener los fichajes por fecha");
		}catch (SQLException sqle) {
			log.error("No se ha podido obtener los fichajes por fecha");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
		return fichajes;
	}

	@Override
	public List<Fichaje> obtenerFichajesEntreEquipos(String equipoOrigen, String equipoDestino){
		List<Fichaje> fichajes = new ArrayList<>();
		String query = "SELECT * FROM fichajes WHERE equipoOrigen = ? AND equipoDestino = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, equipoOrigen);
			pstmt.setString(2, equipoDestino);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					LocalDate fecha = rs.getDate("fecha").toLocalDate();
					String nombreJugador = rs.getString("nombre_jugador");
					Jugador jugador = obtenerJugadorPorNombre(nombreJugador);
					Fichaje fichaje = new Fichaje(fecha, jugador);
					fichajes.add(fichaje);
				}
			}catch (Exception e) {
    			System.out.println(e.getMessage());
                System.out.println(e.toString());
    		}
            log.info("Se ha podido obtener los fichajes entre equipos");
		}catch (SQLException sqle) {
			log.error("No se ha podido obtener los fichajes entre equipos");
			System.out.println(sqle.getMessage());
            System.out.println(sqle.toString());
		}
		return fichajes;
	}
}
