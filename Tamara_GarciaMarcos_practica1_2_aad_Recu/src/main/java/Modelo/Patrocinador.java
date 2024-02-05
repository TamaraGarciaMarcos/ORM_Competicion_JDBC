package Modelo;
/**
 * Esta clase se encarga de simular un patrocinador de la competicion
 * 
 * @author Tamara Garcia Marcos
 */
import java.util.List;


public class Patrocinador {

	private int id;
	private String nombre;
    private List<Equipo> equipos;
	
	//Constructor
	public Patrocinador(String nombre) {
		this.nombre= nombre;
	}
	
	public Patrocinador (int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Patrocinador [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
