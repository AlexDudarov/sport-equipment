package gmail.alexdudarkov.document.web.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import gmail.alexdudarkov.document.repository.model.Good;
import gmail.alexdudarkov.document.service.ServiceAbstract;
import gmail.alexdudarkov.document.service.exception.ServiceException;
import gmail.alexdudarkov.document.service.factory.ServiceFactory;
import gmail.alexdudarkov.document.web.command.Command;


public class CatalogSearch implements Command {

	@Override
	public void  execute(HttpServletRequest request, HttpServletResponse response) {
		Good[] goods;
		List<Good> resultGoods=null;
		
		String[] checkedBrandId=request.getParameterValues("brand");
		String[] checkedTypeId=request.getParameterValues("type");
		if(checkedTypeId==null && checkedBrandId==null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Catalog");
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
		ServiceFactory serviceFactory= ServiceFactory.getInstance();
		ServiceAbstract<Good> serviceGood=(ServiceAbstract<Good>)serviceFactory.getSqlImpl(Good.class);
		goods=new Good[checkedBrandId.length];
		for(int i=0; i<checkedBrandId.length; i++){
			goods[i].getBrand().setId(Integer.parseInt(checkedBrandId[i]));
		}
		try {
			resultGoods = serviceGood.getByCriteria(goods);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		request.setAttribute("goods", resultGoods);
		for(String i: checkedBrandId){
			System.out.println(i);
		}
	}
}