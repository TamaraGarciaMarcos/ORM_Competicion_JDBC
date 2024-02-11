package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
/**
 * Esta clase simula el modelo del fichaje que se va a usar
 * @author Tamara Garcia Marcos
 */
public class Fichaje implements Serializable{
	private static final long serialVersionUID = 1L;
    private LocalDate fecha;
    private Jugador jugador;
    private Equipo equipoOrigen;
    private Equipo equipoDestino;
    
    public Fichaje(LocalDate fecha, Jugador jugador) {
        this.fecha = fecha;
        this.jugador = jugador;
    }
    public Fichaje(LocalDate fecha, Jugador jugador, Equipo equipoOrigen, Equipo equipoDestino) {
        this.fecha = fecha;
        this.jugador = jugador;
        this.equipoOrigen = equipoOrigen;
        this.equipoDestino = equipoDestino;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Equipo getEquipoOrigen() {
        return equipoOrigen;
    }

    public void setEquipoOrigen(Equipo equipoOrigen) {
        this.equipoOrigen = equipoOrigen;
    }

    public Equipo getEquipoDestino() {
        return equipoDestino;
    }

    public void setEquipoDestino(Equipo equipoDestino) {
        this.equipoDestino = equipoDestino;
    }
}
