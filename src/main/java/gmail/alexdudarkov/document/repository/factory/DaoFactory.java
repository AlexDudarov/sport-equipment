package gmail.alexdudarkov.document.repository.factory;
import gmail.alexdudarkov.document.repository.AbstractSQLDao;
import gmail.alexdudarkov.document.repository.impl.*;
import gmail.alexdudarkov.document.repository.model.*;

import java.util.HashMap;
import java.util.Map;



public class DaoFactory {
	private static final DaoFactory instance = new DaoFactory();
	private final Map<Class<?>, AbstractSQLDao<?>> creators;


	private DaoFactory() {
		creators = new HashMap<Class<?>, AbstractSQLDao<?>>();
		creators.put(User.class, new UserSQLDao(User.class));
		creators.put(TypeGood.class, new TypeGoodSQLDao(TypeGood.class));
		creators.put(BrandGood.class, new BrandGoodSQLDao(BrandGood.class));
		creators.put(Good.class, new GoodSQLDao(Good.class));
		creators.put(Order.class, new OrderSQLDao(Order.class));
		creators.put(OrderItem.class, new OrderItemSQLDao(OrderItem.class));
	}

	public static DaoFactory getInstance() {
		return instance;
	}

	public AbstractSQLDao<?> getSqlImpl(Class<?> clas) {
		return creators.get(clas);
	};
}
