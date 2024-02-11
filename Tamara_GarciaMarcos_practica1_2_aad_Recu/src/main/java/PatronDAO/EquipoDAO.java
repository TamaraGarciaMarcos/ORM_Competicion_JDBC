package PatronDAO;

import java.util.List;

import Modelo.Equipo;
/**
 * Esta interfaz hereda del DAO generico y establece métodos específicos
 * @author Tamara Garcia Marcos
 */
public interface EquipoDAO extends DAO_Generico<Equipo> {
	// Métodos específicos para el DAO de Equipo si es necesario

	List<Equipo> obtenerEquiposConPlantilla();

	List<Equipo> obtenerEquiposSinPlantilla();

	Equipo obtenerEquipoPorNombre(String nombreEquipo);

	void actualizarPlantillaEquipo(Equipo equipo);
}
