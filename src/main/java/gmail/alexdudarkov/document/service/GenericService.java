package gmail.alexdudarkov.document.service;

import gmail.alexdudarkov.document.service.exception.ServiceException;

import java.io.Serializable;
import java.util.List;



public interface GenericService <T extends Serializable> {

	public void persist(T object) throws ServiceException;

	public T getByPK(int id) throws ServiceException;

	public void update(T object) throws ServiceException;

	public void delete(T object) throws ServiceException;

	public List<T> getAll() throws ServiceException;
	
	public List<T> getByExample(T object) throws ServiceException;
	
	public  List<T> getByCriteria(T[] objects) throws ServiceException;

}