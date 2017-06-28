package gmail.alexdudarkov.document.web.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import gmail.alexdudarkov.document.repository.AbstractSQLDao;
import gmail.alexdudarkov.document.repository.impl.GoodSQLDao;
import gmail.alexdudarkov.document.repository.model.Good;
import gmail.alexdudarkov.document.service.ServiceAbstract;
import gmail.alexdudarkov.document.service.impl.GoodService;
import gmail.alexdudarkov.document.web.command.Command;


public class Catalog implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		AbstractSQLDao<Good> goodDao=new GoodSQLDao(Good.class);
		Good g=new Good();
		try {
			//List<User> u= new ArrayList<>();
			//u=userDao.getAll();
			
			
			ServiceAbstract<Good> us=new GoodService(Good.class);
			g=us.getByPK(1);
			System.out.println(g);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("goods", g);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/catalog.jsp");
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
