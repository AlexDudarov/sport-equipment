package gmail.alexdudarkov.document.service;

import gmail.alexdudarkov.document.repository.AbstractSQLDao;
import gmail.alexdudarkov.document.repository.exception.DAOException;
import gmail.alexdudarkov.document.repository.factory.DaoFactory;
import gmail.alexdudarkov.document.service.exception.ServiceException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public abstract class ServiceAbstract<T extends Serializable> implements GenericService<T> {
	final Class<T> typeParameterClass;
	public ServiceAbstract(Class<T> typeParameterClass){
		
		this.typeParameterClass=typeParameterClass;
	}
	public void persist(T object) throws ServiceException {
		DaoFactory daoObjectFactory = DaoFactory.getInstance();
		AbstractSQLDao<T> abstractSqlDao =(AbstractSQLDao<T>) daoObjectFactory.getSqlImpl(typeParameterClass);
		try {
			abstractSqlDao.persist(object);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public T getByPK(int id) throws ServiceException {
		DaoFactory daoObjectFactory = DaoFactory.getInstance();
		AbstractSQLDao<T>  abstractSqlDao =(AbstractSQLDao<T>) daoObjectFactory.getSqlImpl( typeParameterClass);
		T object;
		try {
			object=abstractSqlDao.getByPK(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
	
		}
		return object;
	}

	public void update(T object) throws ServiceException {
		DaoFactory daoObjectFactory = DaoFactory.getInstance();
		AbstractSQLDao<T>  abstractSqlDao =(AbstractSQLDao<T>) daoObjectFactory.getSqlImpl(typeParameterClass);
		try {
			abstractSqlDao.update(object);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public void delete(T object) throws ServiceException {
		DaoFactory daoObjectFactory = DaoFactory.getInstance();
		AbstractSQLDao<T>  abstractSqlDao =(AbstractSQLDao<T>) daoObjectFactory.getSqlImpl(typeParameterClass);
		try {
			abstractSqlDao.delete(object);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public List<T> getAll() throws ServiceException {
		DaoFactory daoObjectFactory = DaoFactory.getInstance();
		AbstractSQLDao<T>  abstractSqlDao =(AbstractSQLDao<T>) daoObjectFactory.getSqlImpl(typeParameterClass);
		List<T> objectList= new ArrayList<>();
		try {
			objectList=abstractSqlDao.getAll();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return objectList;
	}
	
	public List<T> getByExample(T object) throws ServiceException{
		DaoFactory daoObjectFactory = DaoFactory.getInstance();
		AbstractSQLDao<T>  abstractSqlDao =(AbstractSQLDao<T>) daoObjectFactory.getSqlImpl(typeParameterClass);
		List<T> objectList= new ArrayList<>();
		try {
			objectList=abstractSqlDao.getByExample(object);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return objectList;
		
	}
	
	public  List<T> getByCriteria(T[] objects) throws ServiceException{
		DaoFactory daoObjectFactory = DaoFactory.getInstance();
		AbstractSQLDao<T>  abstractSqlDao =(AbstractSQLDao<T>) daoObjectFactory.getSqlImpl(typeParameterClass);
		List<T> objectList= new ArrayList<>();
		try {
			objectList=abstractSqlDao.getByCriteria(objects);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return objectList;
	}
}
