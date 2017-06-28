package gmail.alexdudarkov.document.web;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gmail.alexdudarkov.document.web.command.Command;


public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CommandProvider provider= new CommandProvider();


	public MyServlet() {
		super();

	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) {
		String commandName = request.getParameter("action");
		System.out.println(commandName);
		Command executionCommand = provider.getCommand(commandName);
		executionCommand.execute(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
