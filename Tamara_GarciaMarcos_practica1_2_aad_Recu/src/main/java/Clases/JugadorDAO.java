package Clases;

/**
 * Esta clase se encarga de implementar el patron DAO en el modelo de jugador * 
 * @author Tamara Garcia Marcos
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.Jugador;

public class JugadorDAO implements DAO<Jugador> {
	 private Connection connection;
	 
	    public JugadorDAO(Connection connection) {
	        this.connection = connection;
	    }

	    @Override
	    public void insert(Jugador jugador) {
	        String query = "INSERT INTO jugador (nombre, nacionalidad, fecha_nacimiento) VALUES (?, ?, ?)";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
	            preparedStatement.setString(1, jugador.getNombre());
	            preparedStatement.setString(2, jugador.getNacionalidad());
	            preparedStatement.setString(3, jugador.getFechaNacimiento());
	            preparedStatement.executeUpdate();
	            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                jugador.setId(generatedKeys.getInt(1));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Manejo de la excepción
	        }
	    }

	    @Override
	    public void update(Jugador jugador) {
	        String query = "UPDATE jugador SET nombre = ?, nacionalidad = ?, fecha_nacimiento = ? WHERE id = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, jugador.getNombre());
	            preparedStatement.setString(2, jugador.getNacionalidad());
	            preparedStatement.setString(3, jugador.getFechaNacimiento());
	            preparedStatement.setLong(4, jugador.getId());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Manejo de la excepción
	        }
	    }

	    @Override
	    public void delete(Jugador jugador) {
	        String query = "DELETE FROM jugador WHERE id = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setLong(1, jugador.getId());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Manejo de la excepción
	        }
	    }

	    @Override
	    public List<Jugador> getAll() {
	        List<Jugador> jugadores = new ArrayList<>();
	        String query = "SELECT * FROM jugador";
	        try (Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {
	            while (resultSet.next()) {
	                long id = resultSet.getLong("id");
	                String apodo = resultSet.getString("apodo");
	                String nombre = resultSet.getString("nombre");
	                String nacionalidad = resultSet.getString("nacionalidad");
	                String fechaNacimiento = resultSet.getString("fecha_nacimiento");
	                String posicion = resultSet.getString("posicion");
	                Jugador jugador = new Jugador(id, apodo, nombre, nacionalidad, fechaNacimiento, posicion);
	                jugadores.add(jugador);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Manejo de la excepción
	        }
	        return jugadores;
	    }


}
