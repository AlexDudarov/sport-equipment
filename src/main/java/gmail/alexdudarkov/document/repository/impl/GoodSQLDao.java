package gmail.alexdudarkov.document.repository.impl;


import java.util.List;

import gmail.alexdudarkov.document.repository.AbstractSQLDao;
import gmail.alexdudarkov.document.repository.exception.DAOException;
import gmail.alexdudarkov.document.repository.hibernate.CloseableSession;
import gmail.alexdudarkov.document.repository.hibernate.HibernateUtil;
import gmail.alexdudarkov.document.repository.model.Good;
import org.hibernate.Criteria;
import org.hibernate.criterion.Example;


public class GoodSQLDao extends AbstractSQLDao<Good> {

	public GoodSQLDao(Class<Good> typeParameterClass) {
		super(typeParameterClass);

	}

	@Override
	public List<Good> getByExample(Good good) throws DAOException {
		List<Good> goods = null;
		List<Good> goods1=null;
		try (CloseableSession session = new CloseableSession(HibernateUtil.getSessionFactory().openSession())) {
			System.out.println(good);
		/*	Criteria c = session.delegate().createCriteria(Good.class, "good") 
					.add(Example.create(good)) //.add(Restrictions.eq("good.availability", good.getAvailability() )) 
					.createAlias("brand","brand") 
					.add(Example.create("good.brand") 
					).createCriteria("type","type") 
					.add(Example.create("good.type") 
					);*/
			Criteria c = session.delegate().createCriteria(Good.class).add(Example.create(good)).createCriteria("brand") 
					.add(Example.create(good.getBrand()));//.createCriteria("type")
					//.add(Example.create(good.getType()));
			Criteria c1 = session.delegate().createCriteria(Good.class).add(Example.create(good)).createCriteria("type") 
					.add(Example.create(good.getType()));
			
			goods = c.list();
			goods1= c1.list();
			goods.retainAll(goods1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return goods;
	}
}
