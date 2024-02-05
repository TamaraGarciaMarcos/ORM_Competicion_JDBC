package Clases;
/**
 * Esta clase se encarga de implementar el patron DAO en el modelo de competicion
 * @author Tamara Garcia Marcos
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Modelo.Competicion;

public class CompeticionDAO implements DAO<Competicion>{
	  private Connection connection;

	    public CompeticionDAO(Connection connection) {
	        this.connection = connection;
	    }

	    @Override
	    public void insert(Competicion competicion) {
	        String query = "INSERT INTO competition (nombre) VALUES (?)";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
	            preparedStatement.setString(1, competicion.getNombre());
	            preparedStatement.executeUpdate();
	            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
	            if (generatedKeys.next()) {
	            	competicion.setId(generatedKeys.getLong(1));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void update(Competicion competicion) {
	        String query = "UPDATE competition SET nombre = ? WHERE id = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, competicion.getNombre());
	            preparedStatement.setLong(2, competicion.getId());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            
	        }
	    }

	    @Override
	    public void delete(Competicion competicion) {
	        String query = "DELETE FROM competicion WHERE id = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setLong(1, competicion.getId());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            
	        }
	    }

		@Override
		public List<Competicion> getAll() {
			
			return null;
		}
		

}


