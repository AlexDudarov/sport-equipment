package gmail.alexdudarkov.document.web.command.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gmail.alexdudarkov.document.repository.model.User;
import gmail.alexdudarkov.document.service.ServiceAbstract;
import gmail.alexdudarkov.document.service.exception.ServiceException;
import gmail.alexdudarkov.document.service.factory.ServiceFactory;
import gmail.alexdudarkov.document.web.command.Command;


public class Administration implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		List<User> users=new ArrayList<>();
		ServiceFactory serviceFactory= ServiceFactory.getInstance();
		ServiceAbstract<User> service=(ServiceAbstract<User>) serviceFactory.getSqlImpl(User.class);
		try {
			users=service.getAll();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		request.setAttribute("users", users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/administration.jsp");
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
