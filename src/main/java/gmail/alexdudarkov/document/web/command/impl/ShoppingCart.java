package gmail.alexdudarkov.document.web.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gmail.alexdudarkov.document.web.command.Command;

public class ShoppingCart implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession(true);
		if(session.getAttribute("role")==null){
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			try {
				String message="Для заказа войдите в профиль";
				request.setAttribute("message", message);
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/ShoppingCart.jsp");
			if( request.getParameter("orderItems")==null){
				String message="Корзина пуста";
				request.setAttribute("message", message);
				System.out.println(request.getSession(false).getId());
				try {
					dispatcher.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
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
	}
	
}
