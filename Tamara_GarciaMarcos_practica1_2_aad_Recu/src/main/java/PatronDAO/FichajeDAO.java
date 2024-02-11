package PatronDAO;

import java.util.List;

import Modelo.Fichaje;
/**
 * Esta interfaz hereda del DAO generico y establece métodos específicos
 * @author Tamara Garcia Marcos
 */
public interface FichajeDAO extends DAO_Generico<Fichaje> {
	// Métodos específicos para el DAO de Fichaje si es necesario

	List<Fichaje> obtenerFichajesPorEquipo(String nombreEquipo);

	List<Fichaje> obtenerFichajesPorFecha(String fecha);

	List<Fichaje> obtenerFichajesEntreEquipos(String equipoOrigen, String equipoDestino);
}
