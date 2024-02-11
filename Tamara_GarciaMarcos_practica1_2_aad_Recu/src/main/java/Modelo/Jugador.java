package Modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Jugador implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombre;
	private String nacionalidad;
	private LocalDate fechaNacimiento;
	private String posicion;

	public Jugador(Long id, String nombre, String nacionalidad, LocalDate fechaNacimiento, String posicion) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
		this.posicion= posicion;
	}
	public Jugador(String nombre, String nacionalidad, LocalDate fechaNacimiento, String posicion) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
		this.posicion= posicion;
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

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

}
