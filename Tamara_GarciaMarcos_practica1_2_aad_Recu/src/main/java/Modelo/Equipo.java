package Modelo;
/**
 * Esta clase se encarga de simular a un equipo de la competicion * 
 * @author Tamara Garcia Marcos
 */
import java.util.ArrayList;
import java.util.List;

public class Equipo {

	private long id;
    private String nombre;
    private int victorias;
    private int derrotas;
    private List<Jugador> plantilla;
    private List<Patrocinador> patrocinadores;    
	
    // Constructor
    public Equipo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.plantilla = new ArrayList<>();
        this.patrocinadores= new ArrayList<>();
    }

    public Equipo( String nombre) {
        this.nombre = nombre;
        this.plantilla = new ArrayList<>();
        this.patrocinadores= new ArrayList<>();
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

    public List<Jugador> getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(List<Jugador> plantilla) {
        this.plantilla = plantilla;
    }

    public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getVctorias() {
		return victorias;
	}

	public void setVctorias(int vctorias) {
		this.victorias = vctorias;
	}

	public List<Patrocinador> getPatrocinadores() {
		return patrocinadores;
	}

	public void setPatrocinadores(List<Patrocinador> patrocinadores) {
		this.patrocinadores = patrocinadores;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", vctorias=" + victorias + ", derrotas=" + derrotas
				+ ", plantilla=" + plantilla + ", patrocinadores=" + patrocinadores + "]";
	}
	
	// Métodos adicionales

    public void agregarJugador(Jugador jugador) {
        plantilla.add(jugador);
    }

    public void eliminarJugador(Jugador jugador) {
        plantilla.remove(jugador);
    }

    public void agregarPatrocinador(Patrocinador patrocinador) {
        if (patrocinadores == null) {
            patrocinadores = new ArrayList<>();
        }
        patrocinadores.add(patrocinador);
    }

    public void eliminarPatrocinador(Patrocinador patrocinador) {
        if (patrocinadores != null) {
            patrocinadores.remove(patrocinador);
        }
    }
	
    public void incrementarVictorias() {
        victorias++;
    }

    public void incrementarDerrotas() {
        derrotas++;
    }
}
