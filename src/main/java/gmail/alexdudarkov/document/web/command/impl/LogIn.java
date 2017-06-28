package gmail.alexdudarkov.document.web.command.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gmail.alexdudarkov.document.repository.model.User;
import gmail.alexdudarkov.document.service.ServiceAbstract;
import gmail.alexdudarkov.document.service.exception.ServiceException;
import gmail.alexdudarkov.document.service.factory.ServiceFactory;
import gmail.alexdudarkov.document.web.command.Command;


public class LogIn implements Command {
	public void  execute(HttpServletRequest request, HttpServletResponse response) {
		User u=new User();
		List<User> users=new ArrayList<>();
		u.setLogin(request.getParameter("login"));
		u.setPassword(request.getParameter("password"));
		ServiceFactory serviceFactory= ServiceFactory.getInstance();
		ServiceAbstract<User> service=(ServiceAbstract<User>) serviceFactory.getSqlImpl(User.class);
		try {
			 users=service.getByExample(u);
			 u=users.get(0);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		HttpSession session=request.getSession(true);
		session.setAttribute("userId", u.getId());
		session.setAttribute("logIn", u.getLogin());
		session.setAttribute("role", u.getRole());
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
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
