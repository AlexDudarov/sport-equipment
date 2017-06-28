package gmail.alexdudarkov.document.repository.impl;



import gmail.alexdudarkov.document.repository.AbstractSQLDao;
import gmail.alexdudarkov.document.repository.exception.DAOException;
import gmail.alexdudarkov.document.repository.model.Order;

import java.util.List;



public class OrderSQLDao extends AbstractSQLDao<Order> {
	public OrderSQLDao(Class<Order> typeParameterClass) {
		super(typeParameterClass);

	}

	@Override
	public List<Order> getByExample(Order object) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
