package gmail.alexdudarkov.document.web.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gmail.alexdudarkov.document.repository.model.Order;
import gmail.alexdudarkov.document.repository.model.OrderItem;
import gmail.alexdudarkov.document.service.ServiceAbstract;
import gmail.alexdudarkov.document.service.exception.ServiceException;
import gmail.alexdudarkov.document.service.factory.ServiceFactory;
import gmail.alexdudarkov.document.web.command.Command;


public class ToOrder implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession(true);
		List<OrderItem> orderItems=(List<OrderItem>) session.getAttribute("orderItems");
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ServiceAbstract<Order> serviceOrder = (ServiceAbstract<Order>) serviceFactory.getSqlImpl(Order.class);
		Order order=new Order();
		order.setOrderItem(orderItems);
		try {
			serviceOrder.persist(order);
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String message="Заказ успешно оформлен";
		request.setAttribute("message", message);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/ShoppingCart.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
