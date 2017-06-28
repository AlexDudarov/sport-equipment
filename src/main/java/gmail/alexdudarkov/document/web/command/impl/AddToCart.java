package gmail.alexdudarkov.document.web.command.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gmail.alexdudarkov.document.repository.model.Good;
import gmail.alexdudarkov.document.repository.model.OrderItem;
import gmail.alexdudarkov.document.service.ServiceAbstract;
import gmail.alexdudarkov.document.service.exception.ServiceException;
import gmail.alexdudarkov.document.service.factory.ServiceFactory;
import gmail.alexdudarkov.document.web.command.Command;


public class AddToCart implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String[] checkedGood = request.getParameterValues("inCart");
		String[] count = request.getParameterValues("count");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Catalog");
		if (checkedGood == null) {

			String message = "Не выбран ни один товар";
			request.setAttribute("message", message);
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			ServiceAbstract<OrderItem> serviceOrderItem = (ServiceAbstract<OrderItem>) serviceFactory
					.getSqlImpl(OrderItem.class);
			ServiceAbstract<Good> serviceGood= (ServiceAbstract<Good>) serviceFactory.getSqlImpl(Good.class);
		
			Good good = new Good();
			List<OrderItem> orderItems=new ArrayList<>();
			for (int i = 0; i < checkedGood.length; i++) {
				OrderItem orderItem = new OrderItem();
				try {
					good=serviceGood.getByPK(Integer.parseInt(checkedGood[i]));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				orderItem.setGood(good);
				orderItem.setCount(Integer.parseInt(count[i]));
				System.out.println(orderItem);
				orderItems.add(orderItem);
			}
			HttpSession session=request.getSession(true);
			session.setAttribute("orderItems", orderItems);
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
