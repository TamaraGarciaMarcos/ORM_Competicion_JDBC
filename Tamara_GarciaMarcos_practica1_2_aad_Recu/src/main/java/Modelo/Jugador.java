package Modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Player")
public class Jugador {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "Nickname")
	private String apodo;
	@Column(name = "Name")
	private String nombre;
	@Column(name = "Country")
	private String nacionalidad;
	@Column(name = "Birth")
	private String fechaNacimiento;
	@Column(name = "Position")
	private String posicion;

	@ManyToOne
	@JoinColumn(name="team_id")
	private Equipo equipo; // Relación ManyToOne con la clase Equipo

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
