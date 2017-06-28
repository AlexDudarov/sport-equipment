package gmail.alexdudarkov.document.repository;

import java.io.Serializable;

import java.util.List;

import gmail.alexdudarkov.document.repository.exception.DAOException;
import gmail.alexdudarkov.document.repository.hibernate.CloseableSession;
import gmail.alexdudarkov.document.repository.hibernate.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.criterion.Example;


public abstract class AbstractSQLDao<T extends Serializable> implements GenericDao<T> {
	
	final Class<T> typeParameterClass;
	public AbstractSQLDao(Class<T> typeParameterClass){
		
		this.typeParameterClass=typeParameterClass;
	}
	@Override
	public void persist(T object) throws DAOException {
		try(CloseableSession session= new CloseableSession(HibernateUtil.getSessionFactory().openSession())){
			
			session.delegate().beginTransaction();
			session.delegate().save(object);
			session.delegate().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public T getByPK(int id) throws DAOException {
		T result = null;
		try(CloseableSession session= new CloseableSession(HibernateUtil.getSessionFactory().openSession())){
			result=(T)session.delegate().load(typeParameterClass, id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	public void update(T object) throws DAOException {
		try (CloseableSession session = new CloseableSession(HibernateUtil.getSessionFactory().openSession())) {

			session.delegate().beginTransaction();
			session.delegate().update(object);
			session.delegate().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(T object) throws DAOException {
		try (CloseableSession session = new CloseableSession(HibernateUtil.getSessionFactory().openSession())) {

			session.delegate().beginTransaction();
			session.delegate().delete(object);
			session.delegate().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<T> getAll() throws DAOException {
		List<T> objects=null;
		try (CloseableSession session = new CloseableSession(HibernateUtil.getSessionFactory().openSession())) {
			objects=session.delegate().createCriteria(typeParameterClass).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	@Override
	abstract public List<T> getByExample(T object) throws DAOException;
	@Override
	public List<T> getByCriteria(T[] objects) throws DAOException {
		List<T> object = null;
		try (CloseableSession session = new CloseableSession(HibernateUtil.getSessionFactory().openSession())) {
			Criteria c = session.delegate().createCriteria(typeParameterClass);
			
			for (int i = 0; i < objects.length; i++) {
				c.add(Example.create(objects[i]));
			//	c.add(Example.create((BrandGood)(objects[i]).getBrand()));
				
			}
			object = c.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
}
