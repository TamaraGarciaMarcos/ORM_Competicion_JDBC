package PatronDAO;

import java.util.List;
/**
 * Esta interfaz hace la funcion de DAO generico para todas las clases
 * @author Tamara Garcia Marcos
 */
public interface DAO_Generico<T> {
	void insert(T object);

	void delete(T object);

	List<T> getAll();
	
}
