package PatronDAO;

import java.util.List;

import Modelo.Jugador;
/**
 * Esta interfaz hereda del DAO generico y establece métodos específicos
 * @author Tamara Garcia Marcos
 */
public interface JugadorDAO extends DAO_Generico<Jugador> {
	// Métodos específicos para el DAO de Jugador si es necesario

	List<Jugador> obtenerJugadoresPorEquipo(String nombreEquipo);

	List<Jugador> obtenerJugadoresPorNacionalidad(String nacionalidad);

	List<Jugador> obtenerJugadoresPorEdad(int edad);
}
