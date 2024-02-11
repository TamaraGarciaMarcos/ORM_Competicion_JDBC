package Modelo;

import java.io.Serializable;
import java.util.List;
/**
 * Esta clase simula el modelo del equipo que se va a usar
 * @author Tamara Garcia Marcos
 */
public class Equipo implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombre;
	private List<Jugador> plantilla;

	public Equipo(Long id, String nombre, List<Jugador> plantilla) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.plantilla = plantilla;
	}
	public Equipo(String nombre) {
	    this.nombre = nombre;
	    this.id = null; // o establece algún valor por defecto para el id
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id=id;
	}

	


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Jugador> getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(List<Jugador> plantilla) {
		this.plantilla = plantilla;
	}

}
