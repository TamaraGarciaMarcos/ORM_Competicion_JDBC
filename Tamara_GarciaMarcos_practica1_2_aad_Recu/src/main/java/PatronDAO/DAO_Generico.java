package PatronDAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO_Generico<T> {
	void insert(T object) throws SQLException;

	void delete(T object) throws SQLException;

	List<T> getAll() throws SQLException;
	// Otros métodos generales si es necesario
}
