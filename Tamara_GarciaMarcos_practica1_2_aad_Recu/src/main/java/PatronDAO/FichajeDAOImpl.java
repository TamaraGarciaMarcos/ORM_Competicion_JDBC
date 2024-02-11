package PatronDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Connection.ConexionBD;
import Modelo.Fichaje;
import Modelo.Jugador;

public class FichajeDAOImpl implements FichajeDAO {

	@Override
    public void insert(Fichaje fichaje) throws SQLException {
        String query = "INSERT INTO fichajes (fecha, nombre_jugador) VALUES (?, ?)";
        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setDate(1, java.sql.Date.valueOf(fichaje.getFecha()));
            pstmt.setString(2, fichaje.getJugador().getNombre());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void delete(Fichaje fichaje) throws SQLException {
        String query = "DELETE FROM fichajes WHERE fecha = ? AND nombre_jugador = ?";
        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setDate(1, java.sql.Date.valueOf(fichaje.getFecha()));
            pstmt.setString(2, fichaje.getJugador().getNombre());
            pstmt.executeUpdate();
        }
    }

    @Override
    public List<Fichaje> getAll() throws SQLException {
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
        }
        return fichajes;
    }

    private Jugador obtenerJugadorPorNombre(String nombre) throws SQLException {
        String query = "SELECT * FROM jugadores WHERE nombre = ?";
        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nombre);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nacionalidad = rs.getString("nacionalidad");
                    LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
                    return new Jugador(nombre, nacionalidad, fechaNacimiento);
                }
            }
        }
        return null;
    }

	@Override
	public List<Fichaje> obtenerFichajesPorEquipo(String nombreEquipo) throws SQLException {
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
			}
		}
		return fichajes;
	}

	@Override
	public List<Fichaje> obtenerFichajesPorFecha(String fecha) throws SQLException {
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
			}
		}
		return fichajes;
	}

	@Override
	public List<Fichaje> obtenerFichajesEntreEquipos(String equipoOrigen, String equipoDestino) throws SQLException {
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
			}
		}
		return fichajes;
	}
}
