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
import Modelo.Jugador;
/**
 * Esta clase se encarga de simular la implementacion del DAO en la clase Jugador * 
 * @author Tamara Garcia Marcos
 */
public class JugadorDAOImpl implements JugadorDAO {
	private static final int JUGADORES_POR_EQUIPO = 5;
	private static int equipoActual = 1;
	private static int jugadorActual = 1;
	Logger log;

	@Override
	public void insert(Jugador jugador) {
		String query = "INSERT INTO jugadores (nombre, nacionalidad, fecha_nacimiento, equipo_id) VALUES (?, ?, ?, ?)";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, jugador.getNombre());
			pstmt.setString(2, jugador.getNacionalidad());
			pstmt.setDate(3, java.sql.Date.valueOf(jugador.getFechaNacimiento()));
			pstmt.setInt(4, equipoActual);
			pstmt.executeUpdate();

			// Incrementar contador de jugadores y equipos
			jugadorActual++;
			if (jugadorActual > JUGADORES_POR_EQUIPO) {
				jugadorActual = 1;
				equipoActual++;
			}
			log.info("Se ha podido insertar el jugador");
		} catch (SQLException sqle) {
			log.error("No se ha podido insertar el fichaje");
			System.out.println(sqle.getMessage());
			System.out.println(sqle.toString());
		}
	}

	@Override
	public void delete(Jugador jugador){
		String query = "DELETE FROM jugadores WHERE nombre = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, jugador.getNombre());
			pstmt.executeUpdate();
			log.info("Se ha podido eliminar el jugador");
		}catch(SQLException sqle){
			log.error("No se ha podido eliminar el jugador");
			System.out.println(sqle.getMessage());
			System.out.println(sqle.toString());
		}
	}

	@Override
	public List<Jugador> getAll() {
		List<Jugador> jugadores = new ArrayList<>();
		String query = "SELECT * FROM jugadores";
		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String nacionalidad = rs.getString("nacionalidad");
				LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
				String posicion = rs.getString("posicion");
				Jugador jugador = new Jugador(nombre, nacionalidad, fechaNacimiento, posicion);
				jugadores.add(jugador);
			}
			log.info("Se ha podido obtener el listado de jugadores");
		} catch (SQLException sqle) {
			log.error("No se ha podido obtener el listado de jugadores");
			System.out.println(sqle.getMessage());
			System.out.println(sqle.toString());
		}
		return jugadores;
	}

	@Override
	public List<Jugador> obtenerJugadoresPorEquipo(String nombreEquipo){
		List<Jugador> jugadores = new ArrayList<>();
		String query = "SELECT j.nombre, j.nacionalidad, j.fecha_nacimiento " + "FROM jugadores j "
				+ "JOIN equipos e ON j.equipo_id = e.id " + "WHERE e.nombre = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, nombreEquipo);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					String nombre = rs.getString("nombre");
					String nacionalidad = rs.getString("nacionalidad");
					LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
					String posicion = rs.getString("posicion");
					Jugador jugador = new Jugador(nombre, nacionalidad, fechaNacimiento, posicion);
					jugadores.add(jugador);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println(e.toString());
			}
			log.info("Se ha podido obtener los jugadores por equipo");
		} catch (SQLException sqle) {
			log.error("No se ha podido obtener los jugadores por equipo");
			System.out.println(sqle.getMessage());
			System.out.println(sqle.toString());
		}
		return jugadores;
	}

	@Override
	public List<Jugador> obtenerJugadoresPorNacionalidad(String nacionalidad){
		List<Jugador> jugadores = new ArrayList<>();
		String query = "SELECT * FROM jugadores WHERE nacionalidad = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, nacionalidad);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					String nombre = rs.getString("nombre");
					LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
					String posicion = rs.getString("posicion");
					Jugador jugador = new Jugador(nombre, nacionalidad, fechaNacimiento, posicion);
					jugadores.add(jugador);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println(e.toString());
			}
			log.info("Se ha podido obtener los jugadores por su nacionalidaad");
		} catch (SQLException sqle) {
			log.error("No se ha podido obtener los jugadores por su nacionalidaad");
			System.out.println(sqle.getMessage());
			System.out.println(sqle.toString());
		}
		return jugadores;
	}

	@Override
	public List<Jugador> obtenerJugadoresPorEdad(int edad){
		List<Jugador> jugadores = new ArrayList<>();
		String query = "SELECT * FROM jugadores WHERE YEAR(CURDATE()) - YEAR(fecha_nacimiento) = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, edad);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					String nombre = rs.getString("nombre");
					String nacionalidad = rs.getString("nacionalidad");
					LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
					String posicion = rs.getString("posicion");
					Jugador jugador = new Jugador(nombre, nacionalidad, fechaNacimiento, posicion);
					jugadores.add(jugador);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println(e.toString());
			}
			log.info("Se ha podido obtener los jugadores por su edad");
		} catch (SQLException sqle) {
			log.error("No se ha podido obtener los jugadores por su edad");
			System.out.println(sqle.getMessage());
			System.out.println(sqle.toString());
		}
		return jugadores;
	}
}
