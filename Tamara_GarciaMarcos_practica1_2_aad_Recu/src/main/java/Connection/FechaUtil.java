package Connection;

import java.time.LocalDate;
import java.time.Period;

public class FechaUtil {
	public static int calcularEdad(LocalDate fechaNacimiento) {
		LocalDate fechaActual = LocalDate.now();
		return Period.between(fechaNacimiento, fechaActual).getYears();
	}
}
