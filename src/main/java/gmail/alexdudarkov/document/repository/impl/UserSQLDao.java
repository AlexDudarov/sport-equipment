package gmail.alexdudarkov.document.repository.impl;

import java.util.List;

import gmail.alexdudarkov.document.repository.AbstractSQLDao;
import gmail.alexdudarkov.document.repository.exception.DAOException;
import gmail.alexdudarkov.document.repository.hibernate.CloseableSession;
import gmail.alexdudarkov.document.repository.hibernate.HibernateUtil;
import gmail.alexdudarkov.document.repository.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Example;



public class UserSQLDao extends AbstractSQLDao<User> {

	public UserSQLDao(Class<User> typeParameterClass) {
		super(typeParameterClass);
	}

	@Override
	public List<User> getByExample(User user) throws DAOException {
		List<User> users = null;
		try (CloseableSession session = new CloseableSession(HibernateUtil.getSessionFactory().openSession())) {
			Criteria c = session.delegate().createCriteria(User.class).add(Example.create(user));
			users = c.list();
	}
		return users;
	}
	

}
