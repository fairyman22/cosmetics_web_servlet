package controllers.admins.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.ItemsDao;
import daos.OrderDao;
import models.Item;
import models.Order;

public class AdminIndexOrderControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminIndexOrderControllers() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
//		OrderDao orderDao = new OrderDao();
		ItemsDao itemDao = new ItemsDao();
		
		//List<Order> orderList = orderDao.findAll();
		List<Item> itemList = itemDao.findAll();
		
		//request.setAttribute("orderList", orderList);
		request.setAttribute("itemList", itemList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/order/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
