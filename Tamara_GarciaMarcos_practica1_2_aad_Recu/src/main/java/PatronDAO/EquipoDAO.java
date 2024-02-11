package PatronDAO;

import java.sql.SQLException;
import java.util.List;

import Modelo.Equipo;

public interface EquipoDAO extends DAO_Generico<Equipo> {
	// Métodos específicos para el DAO de Equipo si es necesario

	List<Equipo> obtenerEquiposConPlantilla() throws SQLException;

	List<Equipo> obtenerEquiposSinPlantilla() throws SQLException;

	Equipo obtenerEquipoPorNombre(String nombreEquipo) throws SQLException;

	void actualizarPlantillaEquipo(Equipo equipo) throws SQLException;
}
