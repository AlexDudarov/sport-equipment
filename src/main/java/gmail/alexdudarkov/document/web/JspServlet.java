package gmail.alexdudarkov.document.web;

import gmail.alexdudarkov.document.repository.model.BrandGood;
import gmail.alexdudarkov.document.repository.model.Good;
import gmail.alexdudarkov.document.repository.model.TypeGood;
import gmail.alexdudarkov.document.service.ServiceAbstract;
import gmail.alexdudarkov.document.service.exception.ServiceException;
import gmail.alexdudarkov.document.service.factory.ServiceFactory;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class JspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ServiceAbstract<Good> serviceGood = (ServiceAbstract<Good>) serviceFactory.getSqlImpl(Good.class);
		ServiceAbstract<BrandGood> serviceGoodList = (ServiceAbstract<BrandGood>) serviceFactory
				.getSqlImpl(BrandGood.class);
		ServiceAbstract<TypeGood> serviceTypeGoodList = (ServiceAbstract<TypeGood>) serviceFactory
				.getSqlImpl(TypeGood.class);
		List<Good> goodList = null;
		List<BrandGood> brandGoodList = null;
		List<TypeGood> typeGoodList = null;
		String[] checkedBrandName = request.getParameterValues("brand");
		String[] checkedTypeName = request.getParameterValues("type");

		try {
			brandGoodList = serviceGoodList.getAll();
			typeGoodList = serviceTypeGoodList.getAll();
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		if (checkedTypeName == null && checkedBrandName == null) {
			try {
				goodList = serviceGood.getAll();
				System.out.println(goodList);
			} catch (ServiceException e) {
			
				e.printStackTrace();
			}

		} else {
			Good good = new Good();
			BrandGood brandGood = new BrandGood();
			TypeGood typeGood = new TypeGood();
			if(checkedBrandName!=null) brandGood.setName(checkedBrandName[0]);
			if(checkedTypeName!=null) typeGood.setName(checkedTypeName[0]);
			good.setAvailability(true);
			good.setBrand(brandGood);
			good.setType(typeGood);
			//good.setAvailability(Availability.valueOf("yes"));
			try {
				goodList = serviceGood.getByExample(good);
			} catch (ServiceException e) {
			}
		}
		request.setAttribute("goods", goodList);
		request.setAttribute("brands", brandGoodList);
		request.setAttribute("types", typeGoodList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("catalog.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
