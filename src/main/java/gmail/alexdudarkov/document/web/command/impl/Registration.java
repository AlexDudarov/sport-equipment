package gmail.alexdudarkov.document.web.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gmail.alexdudarkov.document.repository.model.User;
import gmail.alexdudarkov.document.service.ServiceAbstract;
import gmail.alexdudarkov.document.service.exception.ServiceException;
import gmail.alexdudarkov.document.service.factory.ServiceFactory;
import gmail.alexdudarkov.document.web.command.Command;


public class Registration implements Command {

	@Override
	public void  execute(HttpServletRequest request, HttpServletResponse response) {
		User u=new User();
		u.setLogin(request.getParameter("login"));
		u.setPassword(request.getParameter("password"));
		u.setRole("user");
		ServiceFactory serviceFactory= ServiceFactory.getInstance();
		ServiceAbstract<User> service=(ServiceAbstract<User>) serviceFactory.getSqlImpl(User.class);
		try {
			service.persist(u);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session=request.getSession(true);
		session.setAttribute("userId", u.getId());
	}


}
