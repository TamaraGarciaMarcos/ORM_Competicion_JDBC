package Clases;
/**
 * Esta clase se encarga de implementar el patron DAO en el modelo de equipo * 
 * @author Tamara Garcia Marcos
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.Equipo;

public class EquipoDAO implements DAO<Equipo>{
	  private Connection connection;

	    public EquipoDAO(Connection connection) {
	        this.connection = connection;
	    }

	    @Override
	    public void insert(Equipo equipo) {
	        String query = "INSERT INTO equipo (nombre) VALUES (?)";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
	            preparedStatement.setString(1, equipo.getNombre());
	            preparedStatement.executeUpdate();
	            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                equipo.setId(generatedKeys.getInt(1));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Manejo de la excepción (lanzar una propia, loggear, etc.)
	        }
	    }

	    @Override
	    public void update(Equipo equipo) {
	        String query = "UPDATE equipo SET nombre = ? WHERE id = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, equipo.getNombre());
	            preparedStatement.setLong(2, equipo.getId());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Manejo de la excepción
	        }
	    }

	    @Override
	    public void delete(Equipo equipo) {
	        String query = "DELETE FROM equipo WHERE id = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setLong(1, equipo.getId());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Manejo de la excepción
	        }
	    }

	    @Override
	    public List<Equipo> getAll() {
	        List<Equipo> equipos = new ArrayList<>();
	        String query = "SELECT * FROM equipo";
	        try (Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {
	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String nombre = resultSet.getString("nombre");
	                Equipo equipo = new Equipo(id, nombre);
	                equipos.add(equipo);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Manejo de la excepción
	        }
	        return equipos;
	    }

}
