package gmail.alexdudarkov.document.service.factory;

import gmail.alexdudarkov.document.repository.model.*;
import gmail.alexdudarkov.document.service.ServiceAbstract;
import gmail.alexdudarkov.document.service.impl.*;

import java.util.HashMap;
import java.util.Map;



public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();
	private Map<Class<?>, ServiceAbstract<?>> creators;


	private ServiceFactory() {
		creators = new HashMap<Class<?>, ServiceAbstract<?>>();
		creators.put(User.class, new UserService(User.class));
		creators.put(Good.class, new GoodService(Good.class));
		creators.put(BrandGood.class,new BrandGoodService(BrandGood.class));
		creators.put(TypeGood.class, new TypeGoodService(TypeGood.class));
		creators.put(Order.class, new OrderService(Order.class));
		creators.put(OrderItem.class, new OrderItemService(OrderItem.class));
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public ServiceAbstract<?> getSqlImpl(Class<?> clas) {
		return creators.get(clas);
	};
}
