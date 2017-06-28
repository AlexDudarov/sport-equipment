package gmail.alexdudarkov.document.repository.impl;


import gmail.alexdudarkov.document.repository.AbstractSQLDao;
import gmail.alexdudarkov.document.repository.exception.DAOException;
import gmail.alexdudarkov.document.repository.model.OrderItem;

import java.util.List;



public class OrderItemSQLDao extends AbstractSQLDao<OrderItem> {

	public OrderItemSQLDao(Class<OrderItem> typeParameterClass) {
		super(typeParameterClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<OrderItem> getByExample(OrderItem object) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
