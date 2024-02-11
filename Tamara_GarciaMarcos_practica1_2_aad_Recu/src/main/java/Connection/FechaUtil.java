package Connection;

import java.time.LocalDate;
import java.time.Period;
/**
 * Esta clase proporciona un metodo para obtener la edad de los jugadores
 * @author Tamara Garcia Marcos
 */
public class FechaUtil {
	public static int calcularEdad(LocalDate fechaNacimiento) {
		LocalDate fechaActual = LocalDate.now();
		return Period.between(fechaNacimiento, fechaActual).getYears();
	}
}
