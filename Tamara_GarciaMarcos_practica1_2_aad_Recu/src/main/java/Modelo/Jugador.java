package Modelo;
/**
 * Esta clase se encarga de los jugadores de la competicion
 * @author Tamara Garcia Marcos
 */
public class Jugador {

	private long id;
	private String apodo;
	private String nombre;
	private String nacionalidad;
	private String fechaNacimiento;
	private String posicion;
	private Equipo equipo;

	// Constructor
	public Jugador(String apodo, String nombre, String nacionalidad, String fechaNacimiento, String posicion) {
		this.apodo = apodo;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
		this.posicion = posicion;
	}

	public Jugador(long id, String apodo, String nombre, String nacionalidad, String fechaNacimiento, String posicion) {
		this.id = id;
		this.apodo = apodo;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
		this.posicion = posicion;
	}

	// Getters y setters

	public long getId() {
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

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return nombre + ", Nacionalidad: " + nacionalidad + ", Fecha de Nacimiento: " + fechaNacimiento;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}
}
