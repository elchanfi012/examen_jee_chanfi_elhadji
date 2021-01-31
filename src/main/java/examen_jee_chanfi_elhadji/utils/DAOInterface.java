package examen_jee_chanfi_elhadji.utils;

import java.sql.SQLException;
import java.util.List;

public interface DAOInterface<T, ID> {
	List<T> getAll() throws SQLException;
	T getById(ID id) throws SQLException;
	ID create(T t) throws SQLException;
	Integer update(T t) throws SQLException;
	void delete(T t) throws SQLException;
}
