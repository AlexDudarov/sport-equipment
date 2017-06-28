package gmail.alexdudarkov.document.service.impl;


import gmail.alexdudarkov.document.repository.model.Order;
import gmail.alexdudarkov.document.service.ServiceAbstract;

public class OrderService  extends ServiceAbstract<Order> {

	public OrderService(Class<Order> typeParameterClass) {
		super(typeParameterClass);
	}
	
}
