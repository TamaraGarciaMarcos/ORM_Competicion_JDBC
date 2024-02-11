package PatronDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Connection.ConexionBD;
import Modelo.Jugador;

public class JugadorDAOImpl implements JugadorDAO {
	private static final int JUGADORES_POR_EQUIPO = 5;
    private static int equipoActual = 1;
    private static int jugadorActual = 1;

    @Override
    public void insert(Jugador jugador) throws SQLException {
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
        }
    }

	@Override
	public void delete(Jugador jugador) throws SQLException {
		String query = "DELETE FROM jugadores WHERE nombre = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, jugador.getNombre());
			pstmt.executeUpdate();
		}
	}

	@Override
	public List<Jugador> getAll() throws SQLException {
		List<Jugador> jugadores = new ArrayList<>();
		String query = "SELECT * FROM jugadores";
		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String nacionalidad = rs.getString("nacionalidad");
				LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
				String posicion= rs.getString("posicion");
				Jugador jugador = new Jugador(nombre, nacionalidad, fechaNacimiento, posicion);
				jugadores.add(jugador);
			}
		}
		return jugadores;
	}

	@Override
	public List<Jugador> obtenerJugadoresPorEquipo(String nombreEquipo) throws SQLException {
	    List<Jugador> jugadores = new ArrayList<>();
	    String query = "SELECT j.nombre, j.nacionalidad, j.fecha_nacimiento " +
	                   "FROM jugadores j " +
	                   "JOIN equipos e ON j.equipo_id = e.id " +
	                   "WHERE e.nombre = ?";
	    try (Connection conn = ConexionBD.getConnection(); 
	         PreparedStatement pstmt = conn.prepareStatement(query)) {
	        pstmt.setString(1, nombreEquipo);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                String nombre = rs.getString("nombre");
	                String nacionalidad = rs.getString("nacionalidad");
	                LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
	                String posicion= rs.getString("posicion");
	                Jugador jugador = new Jugador(nombre, nacionalidad, fechaNacimiento, posicion);
	                jugadores.add(jugador);
	            }
	        }
	    }
	    return jugadores;
	}



	@Override
	public List<Jugador> obtenerJugadoresPorNacionalidad(String nacionalidad) throws SQLException {
		List<Jugador> jugadores = new ArrayList<>();
		String query = "SELECT * FROM jugadores WHERE nacionalidad = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, nacionalidad);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					String nombre = rs.getString("nombre");
					LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
					String posicion= rs.getString("posicion");
					Jugador jugador = new Jugador(nombre, nacionalidad, fechaNacimiento, posicion);
					jugadores.add(jugador);
				}
			}
		}
		return jugadores;
	}

	@Override
	public List<Jugador> obtenerJugadoresPorEdad(int edad) throws SQLException {
		List<Jugador> jugadores = new ArrayList<>();
		String query = "SELECT * FROM jugadores WHERE YEAR(CURDATE()) - YEAR(fecha_nacimiento) = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, edad);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					String nombre = rs.getString("nombre");
					String nacionalidad = rs.getString("nacionalidad");
					LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
					String posicion= rs.getString("posicion");
					Jugador jugador = new Jugador(nombre, nacionalidad, fechaNacimiento, posicion);
					jugadores.add(jugador);
				}
			}
		}
		return jugadores;
	}
}
