package gmail.alexdudarkov.document.repository;

import gmail.alexdudarkov.document.repository.exception.DAOException;

import java.io.Serializable;
import java.util.List;




public interface GenericDao<T extends Serializable> {

	public void persist(T object) throws DAOException;

	public T getByPK(int id) throws DAOException;

	public void update(T object) throws DAOException;

	public void delete(T object) throws DAOException;

	public List<T> getAll() throws DAOException;
	
	public List<T> getByExample(T object) throws DAOException;

	public  List<T> getByCriteria(T[] objects) throws DAOException;

}
