package PatronDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connection.ConexionBD;
import Modelo.Equipo;

public class EquipoDAOImpl implements EquipoDAO {
	
	// Métodos para crear y eliminar tablas según sea necesario
    public void crearTablas() throws SQLException {
        try (Connection conn = ConexionBD.getConnection()) {
            crearTablaEquipos(conn);
            crearTablaJugadores(conn);
            crearTablaFichajes(conn);
        }
    }

    public void eliminarTablas() throws SQLException {
        try (Connection conn = ConexionBD.getConnection()) {
            eliminarTablaFichajes(conn);
            eliminarTablaJugadores(conn);
            eliminarTablaEquipos(conn);
        }
    }

    private void crearTablaEquipos(Connection conn) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS equipos (id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100) NOT NULL)";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
        }
    }

    private void crearTablaJugadores(Connection conn) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS jugadores (id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100) NOT NULL, nacionalidad VARCHAR(100), fecha_nacimiento DATE, equipo_id INT, FOREIGN KEY (equipo_id) REFERENCES equipos(id))";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
        }
    }

    private void crearTablaFichajes(Connection conn) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS fichajes (id INT AUTO_INCREMENT PRIMARY KEY, fecha DATE, nombre_jugador VARCHAR(100) NOT NULL)";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
        }
    }


    private void eliminarTablaEquipos(Connection conn) throws SQLException {
        String query = "DROP TABLE IF EXISTS equipos";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
        }
    }
    

    private void eliminarTablaJugadores(Connection conn) throws SQLException {
        String query = "DROP TABLE IF EXISTS jugadores";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
        }
    }

    private void eliminarTablaFichajes(Connection conn) throws SQLException {
        String query = "DROP TABLE IF EXISTS fichajes";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
        }
    }
	
	@Override
	public void insert(Equipo equipo) throws SQLException {
		String query = "INSERT INTO equipos (nombre) VALUES (?)";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, equipo.getNombre());
			pstmt.executeUpdate();
		}
	}

	@Override
	public void delete(Equipo equipo) throws SQLException {
		String query = "DELETE FROM equipos WHERE nombre = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, equipo.getNombre());
			pstmt.executeUpdate();
		}
	}

	@Override
	public List<Equipo> getAll() throws SQLException {
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
		}
		return equipos;
	}

	@Override
	public List<Equipo> obtenerEquiposConPlantilla() throws SQLException {
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
			}
		}
		return null;
	}

	@Override
	public void actualizarPlantillaEquipo(Equipo equipo) throws SQLException {
		String query = "UPDATE equipos SET tiene_plantilla = ? WHERE nombre = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setBoolean(1, true); // Marcamos que el equipo tiene plantilla
			pstmt.setString(2, equipo.getNombre());
			pstmt.executeUpdate();
		}
	}

}
